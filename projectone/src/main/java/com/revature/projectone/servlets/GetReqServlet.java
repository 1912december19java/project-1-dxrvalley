package com.revature.projectone.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.ListView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.projectone.models.refund_list;
import com.revature.projectone.models.refund_model;
import com.revature.projectone.models.user_acount;

public class GetReqServlet extends HttpServlet {

  private ObjectMapper om6 = new ObjectMapper();

  @Override
  public void init() throws ServletException {
    this.om6 = new ObjectMapper();
    super.init();
  }


  refund_model acountR = new refund_model();
  ResultSet rs = null;   
  ObjectMapper mapperR = new ObjectMapper();



  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
   
    System.out.println("Reached GetReqServlet GET");
    HttpSession session = req.getSession();
    int m_id = (Integer) session.getAttribute("ID");
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
      PreparedStatement stmt =
          conn.prepareStatement("SELECT * FROM request_info WHERE member_id = ?");
      stmt.setInt(1, m_id);
      stmt.execute();
      rs = stmt.getResultSet();
      List<refund_model> list = new ArrayList<refund_model>();

      while (rs.next()) {

        refund_model acountR = new refund_model(rs.getInt(1),
             rs.getString(2),
            rs.getString(3), rs.getString(4), rs.getString(5));
        list.add(acountR);
      }
      stmt.close();
      HttpSession session2 = req.getSession();
session2.setAttribute("realone", list);
      String work2 = mapperR.writeValueAsString(session.getAttribute("realone"));
      PrintWriter out = resp.getWriter();
      out.print(work2);
      System.out.println("R you the "+work2.toString());
    } catch (SQLException e) {
    }
  }

}

