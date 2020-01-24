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

public class RequestServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    ObjectMapper mapper = new ObjectMapper();
    System.out.println("Reached RequestServlet POST");
    String EmpID = req.getParameter("EmpID");
    String Type = req.getParameter("r-type");
    Float Amount = Float.parseFloat(req.getParameter("req-amount"));
    Integer m_id = (Integer)session.getAttribute("ID");
    System.out.println("input Type"+Type);
    System.out.println("iput amount"+ Amount);
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
          "BEGIN; INSERT INTO request_info (member_id,refund_type,req_amount) VALUES(?,?,?); COMMIT;");
      stmt.setInt(1, m_id);
      stmt.setString(2, Type);
      stmt.setFloat(3, Amount);
      stmt.executeUpdate();      
      stmt.close();
    } catch (SQLException e) {
    } 
    if(m_id != null) {
     resp.sendRedirect("projectone/employee-hpage.html");
    
   }else {
     resp.sendRedirect("projectone/employee-rform.html");
 }
   }
 }

















