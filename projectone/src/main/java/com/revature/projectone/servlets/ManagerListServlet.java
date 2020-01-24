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

public class ManagerListServlet extends HttpServlet {

  private ObjectMapper om7 = new ObjectMapper();

  @Override
  public void init() throws ServletException {
    this.om7= new ObjectMapper();
    super.init();
  }


  refund_model acountM = new refund_model();
  ResultSet rs = null;   
  ObjectMapper mapperM = new ObjectMapper();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
   
    System.out.println("Reached managerlistServlet GET");
   
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
          conn.prepareStatement("SELECT r.req_amount, r.req_date, r.refund_type, r.status,r.member_id,a.first_name,a.last_name FROM request_info AS r LEFT JOIN acount_info AS a ON r.member_id = a.member_id;");
      stmt.execute();
      rs = stmt.getResultSet();
      List<refund_model> list2 = new ArrayList<refund_model>();

      while (rs.next()) {

        refund_model acountM = new refund_model(rs.getInt(1),
             rs.getString(2),
            rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
        list2.add(acountM);
      }
      System.out.println("qokw::::"+list2);
      HttpSession session3 = req.getSession();
session3.setAttribute("realsix", list2);
      String work6 = mapperM.writeValueAsString(list2);
      PrintWriter out = resp.getWriter();
      out.print(work6);
      System.out.println("R you the mamanegrorderlist::: "+work6.toString());
    } catch (SQLException e) {
    }
  }


}
