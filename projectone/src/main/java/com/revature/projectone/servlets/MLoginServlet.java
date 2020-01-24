package com.revature.projectone.servlets;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.projectone.models.user_acount;

public class MLoginServlet extends HttpServlet {

  private ObjectMapper om = new ObjectMapper();

  @Override
  public void init() throws ServletException {
    this.om = new ObjectMapper();
    super.init();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("Reached LoginServlet POST");
    String ePosition = "Manager";
    String Login_Email = req.getParameter("mEmail");
    String Login_Password = req.getParameter("mPassword");
    ObjectMapper mapper = new ObjectMapper();

  
    ResultSet rs = null;
    user_acount acount = new user_acount();
    Connection conn = null;
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e1) {
      e1.printStackTrace();
    }
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"), System.getenv("username"),
          System.getenv("password"));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      PreparedStatement stmt = conn.prepareStatement(
          " SELECT member_id,first_name,last_name,email,password_,j_pos FROM acount_info WHERE (email = ? AND password_ = ? AND j_pos = ?)");
      stmt.setString(1, Login_Email);
      stmt.setString(2, Login_Password);
      stmt.setString(3, ePosition);
      stmt.execute();
      if (stmt.execute()) {
        rs = stmt.getResultSet();
      }
      while (rs.next()) {
        acount = new user_acount(rs.getInt("member_id"), rs.getString("first_name"),
            rs.getString("last_name"), rs.getString("email"), rs.getString("password_"),
            rs.getString("j_pos"));
      }
      stmt.close();
      if (acount.getFirstName() != null) {
        HttpSession session = req.getSession();
        session.setAttribute("ID", acount.getId());
        session.setAttribute("FNAME", acount.getFirstName());
        session.setAttribute("LNAME", acount.getLastName());
        session.setAttribute("EMAIL", acount.getEmail());
        session.setAttribute("PASSWORD", acount.getPassword());
        session.setAttribute("POSITION", acount.getPosition());
        session.setAttribute("USER", acount);
        
        String work = mapper.writeValueAsString(acount);

        System.out.println(work);
        resp.sendRedirect("projectone/manager-hpage.html");
        
        System.out.println();
      } else {
        resp.sendRedirect("projectone/managerlogin.html");
      }
    } catch (SQLException e) {
    }
  }
}

