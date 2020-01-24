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

public class ApproveServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    ObjectMapper mapper = new ObjectMapper();
    System.out.println("Reached DeleteServlet POST");
    Integer EmpID = Integer.parseInt(req.getParameter("e-id1"));
    
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
          "BEGIN;  UPDATE request_info SET status=TRUE, amount = amount+req_amount, req_amount = 0 WHERE member_id=?; COMMIT;");
      stmt.setInt(1, EmpID);
      stmt.executeUpdate();      
      stmt.close();
    } catch (SQLException e) {
    }
    if(EmpID != null) {
    resp.sendRedirect("projectone/manager-hpage.html");
  }else {
    resp.sendRedirect("projectone/manager-work.html");
  }
  }
}



