package com.revature.projectone.models;

import java.util.List;

public class refund_list {
  
  private String list;


  
  public refund_list() {
    super();
  }



  public refund_list(List<refund_model> list2) {
    // TODO Auto-generated constructor stub
  }

  @Override
  public String toString() {
    return  list ;
  } 

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((list == null) ? 0 : list.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    refund_list other = (refund_list) obj;
    if (list == null) {
      if (other.list != null)
        return false;
    } else if (!list.equals(other.list))
      return false;
    return true;
  }
  
  
}
