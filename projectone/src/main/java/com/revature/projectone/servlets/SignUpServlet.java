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

public class SignUpServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("Reached SignUpServlet POST");
    String firstName = req.getParameter("firstname");
    String lastName = req.getParameter("lastname");
    String email = req.getParameter("email");
    String password = req.getParameter("password");
    String position = req.getParameter("position");
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
          "BEGIN; INSERT INTO acount_info(first_name,last_name,email,password_,j_pos) VALUES(?,?,?,?,?); COMMIT;");
      stmt.setString(1, firstName);
      stmt.setString(2, lastName);
      stmt.setString(3, email);
      stmt.setString(4, password);
      stmt.setString(5, position);
      stmt.executeUpdate();      
      stmt.close();
    } catch (SQLException e) {
    }
    resp.sendRedirect("projectone/index.html");
  }
}


