package com.revature.projectone.servlets;



  
  import java.io.*;
  import java.awt.image.*;
  import javax.imageio.*;
  
  public class photoservlet {
     public static void main(String[] args) throws Exception {
        BufferedImage bufferimage = ImageIO.read(new File("myimage.jpg"));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ImageIO.write(bufferimage, "jpg", output );
        byte [] data = output.toByteArray();
     }
  }

