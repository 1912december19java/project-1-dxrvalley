package com.revature.projectone.models;

public class total {

  float total;

  public float getTotal() {
    return total;
  }

  public void setTotal(float total) {
    this.total = total;
  }

  public total(float total) {
    super();
    this.total = total;
  }

  public total() {
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Float.floatToIntBits(total);
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
    total other = (total) obj;
    if (Float.floatToIntBits(total) != Float.floatToIntBits(other.total))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "" +total+"";
  }


  
  
}


