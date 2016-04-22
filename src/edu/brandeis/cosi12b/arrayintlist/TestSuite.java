package edu.brandeis.cosi12b.arrayintlist;

public class TestSuite {

  /*
   * Test Suites
   */
  public boolean test1() {
    ArrayIntList a = new ArrayIntList();
    if (a.length() != 0) {
      return error("Test1");
    } else
      return success("Test1");
  }

  public boolean test2() {
    ArrayIntList a = new ArrayIntList();
    a.add(100);
    if (a.length() != 1) {
      return error("Test2");
    } else
      return (success("Test2"));
  }

  public boolean test3() {
    ArrayIntList a = new ArrayIntList();
    a.add(1);
    a.add(34);
    if (!a.toString().equals("[1,34]")) {
      return error("Test3: " + a.toString());
    } else {
      return success("Test3");
    }
  }
  
  public boolean test4() {
    ArrayIntList list1= new ArrayIntList();
    list1.add(3);
    list1.add(8);
    list1.add(9);
    list1.add(7);
    if (list1.length() != 4)
      return error("test4: Length ne 4");
    list1.set(3,42);
    if (list1.length() != 4)
      return error("test4: add in the middle, wrong length: "+list1.length());
    if (list1.get(2) != 9)
      return error("test4: add in the middle index 2 was: "+list1.get(2));
    if (list1.get(3) != 42)
      return error("test4: add in the middle index 3 was: "+list1.get(2));
    return success("test4");
  }
  
  public boolean test5() {
    ArrayIntList list1= new ArrayIntList();
    list1.add(3);
    list1.add(8);
    list1.add(9);
    list1.add(7);
    list1.remove(2);
    if ((list1.length() != 3) || (list1.get(2) != 7)) {
      return error("test5: remove in the middle failed");
    }
    return success("test5");
    
  }
  
  public boolean test6() {
    ArrayIntList list1= new ArrayIntList();
    list1.add(3);
    list1.add(8);
    list1.add(9);
    list1.add(7);
    if (list1.indexOf(9) != 2)
      return error("test6: indexof error");
    if (list1.contains(11) == true)
      return error("test6: contains error: " + list1.contains(8));
    if (list1.isEmpty())
      return error("test6: isEmpty error");
    return success("test6");
  }
  
  public boolean test7() {
    ArrayIntList list1= new ArrayIntList(20);
    if (list1.length() != 0)
        return error("test7: incorrect length");
    if (list1.capacity() != 20)
      return error("test7: incorect capacity");
    return success("test7");
  }
  
  public boolean test8() {
    ArrayIntList list1 = new ArrayIntList(20);
    list1.add(99);
    if (list1.get(0) != 99)
      return error("test8: get failure");
    try {
      list1.get(1);
    } catch (ArrayIndexOutOfBoundsException e)  {
        return success("test8");
    }
    return error("test8: didn't throw exception");
  }
  
  public boolean test9() {
    ArrayIntList list1 = new ArrayIntList(20);
    list1.set(30, 100);
    try {
      int value = list1.get(30);
      if (value != 100) 
        return error("test9: expansion of underlying array didn't work");
      } catch (Exception e) {
        return error("test9: expansion caused an exception");
    }
    return success("test9");
  }


  /*
   * Utility methods
   */

  private boolean error(String message) {
    System.out.println("ERROR: " + message);
    return false;
  }

  private boolean success(String message) {
    System.out.println("OK: " + message);
    return true;
  }

}
