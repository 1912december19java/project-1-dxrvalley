package com.revature.projectone.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.projectone.models.user_acount;

public class user_acountDaoPostgres implements user_acountDao {
  private static Connection conn;

  // This guy will run when the class loads, after static fields are initialized.
  static {
    // This explicitly loads the Driver class:
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
  }
  
  public List<user_acount> getInfo(Integer id) {
    // TODO Auto-generated method stub
    return null;
  }

  public user_acount signup() {
    // TODO Auto-generated method stub
    return null;
  }

  public user_acount login() {
    // TODO Auto-generated method stub
    return null;
  }

  public void updateInfo() {
    // TODO Auto-generated method stub
    
  }

  public void refund() {
    // TODO Auto-generated method stub
    
  }

  public void checkStatus() {
    // TODO Auto-generated method stub
    
  }

}
