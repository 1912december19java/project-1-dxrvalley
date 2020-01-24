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

public class RHomeServlet extends HttpServlet {
  
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
      System.out.println("Reached EHomeServlet GET");

    HttpSession session = req.getSession();
    ObjectMapper mapper = new ObjectMapper();

    
    String id2 = session.getAttribute("ID").toString();
    String first2 = session.getAttribute("FNAME").toString();
    String last2 = session.getAttribute("LNAME").toString();
    String email2= session.getAttribute("EMAIL").toString();
    String password2 = session.getAttribute("PASSWORD").toString();
    String pos2 = session.getAttribute("POSITION").toString();
    String UserInfo2 = mapper.writeValueAsString(session.getAttribute("USER"));
    
    PrintWriter out = resp.getWriter();
    out.print(UserInfo2);
    
System.out.println(UserInfo2);

    }

  }

