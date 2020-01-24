package com.revature.projectone.models;

public class login_model {
  
  private String eEmail;
  private String ePassword;
  public String geteEmail() {
    return eEmail;
  }
  public void seteEmail(String eEmail) {
    this.eEmail = eEmail;
  }
  public String getePassword() {
    return ePassword;
  }
  public void setePassword(String ePassword) {
    this.ePassword = ePassword;
  }
  public login_model(String eEmail, String ePassword) {
    super();
    this.eEmail = eEmail;
    this.ePassword = ePassword;
  }
 
  public login_model() {
    super();
  }

}
