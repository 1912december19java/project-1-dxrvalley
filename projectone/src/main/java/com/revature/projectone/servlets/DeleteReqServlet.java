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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.projectone.models.refund_model;

public class DeleteReqServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    ObjectMapper mapper = new ObjectMapper();
    System.out.println("Reached DeleteServlet POST");
    String EmpID = req.getParameter("EmpID");
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
          "BEGIN; DELETE FROM request_info WHERE(status=TRUE OR status=FALSE);COMMIT;");
      stmt.executeUpdate();      
      stmt.close();
    } catch (SQLException e) {
    }
    if(m_id != null) {
    resp.sendRedirect("projectone/employee-hpage.html");
  }else {
    resp.sendRedirect("projectone/status-check.html");
  }
  }
}



