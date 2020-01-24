package com.revature.projectone.models;
import java.sql.Array;
import java.sql.Date;
import java.util.Arrays;

public class refund_model {

  
  int id;
  String refund_Type;
  String req_date;
  String req_amount;
  String status;
  String firstname;
  String lastname;
  
  public refund_model() {
    super();
    // TODO Auto-generated constructor stub
  }
  
  public refund_model(int id, String email, String firstName, String position,
      String refund_Type, String req_date, String req_amount, String status) {
    super();
    this.id = id;
  
    this.refund_Type = refund_Type;
    this.req_date = req_date;
    this.req_amount = req_amount;
    this.status = status;
  }

  public refund_model(int id, String refund_Type, String req_date, String status, String req_amount) {
    this.id = id;
    this.refund_Type = refund_Type;
    this.status = status;
    this.req_amount = req_amount;
    this.req_date = req_date;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }



 

  



  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public refund_model(int id, String refund_Type, String req_date, String req_amount, String status,
      String firstname, String lastname) {
    super();
    this.id = id;
    this.refund_Type = refund_Type;
    this.req_date = req_date;
    this.req_amount = req_amount;
    this.status = status;
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public String getRefund_Type() {
    return refund_Type;
  }

  public void setRefund_Type(String refund_Type) {
    this.refund_Type = refund_Type;
  }

  public String getReq_date() {
    return req_date;
  }

  public void setReq_date(String req_date) {
    this.req_date = req_date;
  }

  public String getReq_amount() {
    return req_amount;
  }

  public void setReq_amount(String req_amount) {
    this.req_amount = req_amount;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "refund_model [id=" + id + ", refund_Type=" + refund_Type + ", req_date=" + req_date
        + ", req_amount=" + req_amount + ", status=" + status + ", firstname=" + firstname
        + ", lastname=" + lastname + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
    result = prime * result + id;
    result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
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
    refund_model other = (refund_model) obj;
    if (firstname == null) {
      if (other.firstname != null)
        return false;
    } else if (!firstname.equals(other.firstname))
      return false;
    if (id != other.id)
      return false;
    if (lastname == null) {
      if (other.lastname != null)
        return false;
    } else if (!lastname.equals(other.lastname))
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
}
 
  