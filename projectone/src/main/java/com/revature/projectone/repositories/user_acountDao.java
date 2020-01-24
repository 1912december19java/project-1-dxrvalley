package com.revature.projectone.repositories;

import java.util.List;
import com.revature.projectone.models.user_acount;;

public interface user_acountDao {
  
  List<user_acount> getInfo(Integer id);
  
  user_acount signup();
  
  user_acount login();
  
  void updateInfo();
  
  void refund();
  
  void checkStatus();
  
 
}
