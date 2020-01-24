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
import com.revature.projectone.models.total;

public class TotalServlet extends HttpServlet {
  
  private ObjectMapper om4= new ObjectMapper();

  @Override
  public void init() throws ServletException {
    this.om4 = new ObjectMapper();
    super.init();
  }
  

  total  TOTALAMOUNT = new total();
  ResultSet rs = null;   
  ObjectMapper mapperT = new ObjectMapper();
  
  
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    System.out.println("Reached TotalServlet GET");
    Integer m_id = (Integer)session.getAttribute("ID");
    System.out.println("Got session id");
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
          "SELECT SUM(amount) AS full FROM request_info WHERE status = TRUE AND member_id =?;");
      stmt.setInt(1, m_id );
      stmt.execute();
      System.out.println("excecuted");
      rs = stmt.getResultSet();
      System.out.println("before while");
      while (rs.next()) {

        TOTALAMOUNT = new total(rs.getFloat(1));
        System.out.println(TOTALAMOUNT);
       
      }
      HttpSession session3 = req.getSession();
session3.setAttribute("realtwo", TOTALAMOUNT);
      String work3 = mapperT.writeValueAsString(session3.getAttribute("realtwo"));
      PrintWriter out = resp.getWriter();
      out.print(work3);
    } catch (SQLException e) {
    }
  
  }
}



