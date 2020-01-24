package com.revature.projectone.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UpdateAcountServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    ObjectMapper mapper = new ObjectMapper();
    System.out.println("Reached UpdateServlet POST");
    String upEmail = req.getParameter("updateEmail");
    String upPass = req.getParameter("updatePassword");
    Integer m_id = (Integer)session.getAttribute("ID");
    
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
          "BEGIN;  UPDATE acount_info SET email = ?, password_ = ? WHERE member_id = ?; COMMIT;");
      stmt.setString(1, upEmail);
      stmt.setString(2, upPass);
      stmt.setInt(3, m_id);
      stmt.executeUpdate();      
      stmt.close();
    } catch (SQLException e) {
    }
    if(m_id != null) {
    resp.sendRedirect("projectone/index.html");
  }else {
    resp.sendRedirect("projectone/employee-update.html");
  }
  }
}

