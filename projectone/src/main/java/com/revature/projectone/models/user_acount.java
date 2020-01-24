package com.revature.projectone.models;

import java.sql.Array;
import java.sql.Date;
import java.util.Arrays;

public class user_acount {
  Object id;
  Object firstName;
  Object lastName;
  Object email;
  Object password;
  Object position;
  Object refund_Type;
  Object req_date;
  Object req_amount;
  Object amount;
  Object status;

  public user_acount() {
    super();
  }

  
  
  
  
  public user_acount(Integer id, String position, String refund_Type, String req_date,
      Integer req_amount, Integer amount, String status) {
    super();
    this.id = id;
    this.position = position;
    this.refund_Type = refund_Type;
    this.req_date = req_date;
    this.req_amount = req_amount;
    this.amount = amount;
    this.status =status;
  }





  public user_acount(Integer id, String firstName, String lastName, String email, String password,
      String position) {
    super();
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.position = position;
  }




  public user_acount(Integer id, String firstName, String lastName, String email, String password,
      String position, String refund_Type, String req_date, Integer req_amount,
      Integer amount, String status) {
    super();
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.position = position;
    this.refund_Type = refund_Type;
    this.req_date = req_date;
    this.req_amount = req_amount;
    this.amount = amount;
    this.status = status;
  }





  public user_acount(String id, String firstName,String email, String password,
      String position, String refund_type, String req_date, String status) {
    // TODO Auto-generated constructor stub
  }





  public user_acount(int int1, String string, String string2, String string3, String string4,
      String string5, String string6, String string7) {
    // TODO Auto-generated constructor stub
  }





  public Object getStatus() {
    return status;
  }





  public void setStatus(Object status) {
    this.status = status;
  }


  public Object getId() {
    return id;
  }





  public void setId(Object id) {
    this.id = id;
  }





  public Object getFirstName() {
    return firstName;
  }





  public void setFirstName(Object firstName) {
    this.firstName = firstName;
  }





  public Object getLastName() {
    return lastName;
  }





  public void setLastName(Object lastName) {
    this.lastName = lastName;
  }





  public Object getEmail() {
    return email;
  }





  public void setEmail(Object email) {
    this.email = email;
  }





  public Object getPassword() {
    return password;
  }





  public void setPassword(Object password) {
    this.password = password;
  }





  public Object getPosition() {
    return position;
  }





  public void setPosition(Object position) {
    this.position = position;
  }





  public Object getRefund_Type() {
    return refund_Type;
  }





  public void setRefund_Type(Object refund_Type) {
    this.refund_Type = refund_Type;
  }





  public Object getReq_date() {
    return req_date;
  }





  public void setReq_date(Object req_date) {
    this.req_date = req_date;
  }





  public Object getReq_amount() {
    return req_amount;
  }





  public void setReq_amount(Object req_amount) {
    this.req_amount = req_amount;
  }





  public Object getAmount() {
    return amount;
  }





  public void setAmount(Object amount) {
    this.amount = amount;
  }





  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((amount == null) ? 0 : amount.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result = prime * result + ((position == null) ? 0 : position.hashCode());
    result = prime * result + ((refund_Type == null) ? 0 : refund_Type.hashCode());
    result = prime * result + ((req_amount == null) ? 0 : req_amount.hashCode());
    result = prime * result + ((req_date == null) ? 0 : req_date.hashCode());
    result = prime * result + ((status == null) ? 0 : status.hashCode());
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
    user_acount other = (user_acount) obj;
    if (amount == null) {
      if (other.amount != null)
        return false;
    } else if (!amount.equals(other.amount))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    } else if (!firstName.equals(other.firstName))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    } else if (!lastName.equals(other.lastName))
      return false;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    if (position == null) {
      if (other.position != null)
        return false;
    } else if (!position.equals(other.position))
      return false;
    if (refund_Type == null) {
      if (other.refund_Type != null)
        return false;
    } else if (!refund_Type.equals(other.refund_Type))
      return false;
    if (req_amount == null) {
      if (other.req_amount != null)
        return false;
    } else if (!req_amount.equals(other.req_amount))
      return false;
    if (req_date == null) {
      if (other.req_date != null)
        return false;
    } else if (!req_date.equals(other.req_date))
      return false;
    if (status == null) {
      if (other.status != null)
        return false;
    } else if (!status.equals(other.status))
      return false;
    return true;
  }





  @Override
  public String toString() {
    return "user_acount [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
        + ", email=" + email + ", password=" + password + ", position=" + position
        + ", refund_Type=" + refund_Type + ", req_date=" + req_date + ", req_amount=" + req_amount
        + ", amount=" + amount + ", status=" + status + "]";
  }











  
}


