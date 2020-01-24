package com.revature.projectone.servlets;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.projectone.models.user_acount;

public class EHomeServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    System.out.println("Reached EHomeServlet GET");

  HttpSession session = req.getSession();
  ObjectMapper mapper = new ObjectMapper();

  
  String UserInfo = mapper.writeValueAsString(session.getAttribute("USER"));
  System.out.println("my user  ::::  "+UserInfo);
  PrintWriter out = resp.getWriter();
  out.print(UserInfo);
  


  }

}
