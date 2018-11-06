package net.similarsu.happy.lombok.entity;

import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;

public class ValExample {
  //val error = new ArrayList<String>();

  public String example() {
    val example = new ArrayList<String>();
    example.add("Hello, World!");
    val foo = example.get(0);
    return foo.toLowerCase();
  }
  
  public void example2() {
    val map = new HashMap<Integer, String>();
    map.put(0, "zero");
    map.put(5, "five");
    for (val entry : map.entrySet()) {
      System.out.printf("%d: %s\n", entry.getKey(), entry.getValue());
    }
  }

  /**
   * error
   * @return
   */
  /*public int example3(){
    val num = 1;
    num =2 ;
    return num;
  }*/
}