package edu.brandeis.cosi12b.arrayintlist;

public class ArrayIntList {
  private int[] list;
  private int size;
  private int capacity;

  public ArrayIntList() {
    this(20);
  }
  
  public ArrayIntList(int initialCapacity) {
    list = new int[initialCapacity];
    size = 0;
    capacity = initialCapacity;
  }
  
  public int capacity() {
    return capacity;
  }
  public int length() {
    return size;
  }

  public void add(int i) {
    list[size] = i;
    size++;
  }

  public String toString() {
    StringBuffer s = new StringBuffer();
    s.append("[");
    for (int i = 0; i < size - 1; i++) {
      s.append(Integer.toString(list[i]));
      s.append(",");
    }
    s.append(Integer.toString(list[size-1]));
    s.append("]");
    return (s.toString());
  }

  public void set(int index, int value) {
    expandIfNecessary(index);
    for (int i=size; i>index; i--) {
      list[i] = list[i-1];
    }
    list[index] = value;
    if (index > size)
      size = index+1;
  }

  private void expandIfNecessary(int index) {
    if (index < capacity) return;
    int newCapacity = capacity*2 + index;
    int[] oldArray = list;
    list = new int[newCapacity];
    for (int i=0; i<size; i++)
      list[i] = oldArray[i];
    capacity = newCapacity;
  }

  public int get(int index) {
    if (index < 0 || index >= size)
      throw new ArrayIndexOutOfBoundsException("i: " + index + " s: " + size);
    return list[index];
  }
  
  public void remove(int index) {
    for (int i=index; i < size; i++)
      list[i] = list[i+1];
    size--;
  }
  
  public boolean isEmpty() {
    return length()==0;
  }
  
  public int indexOf(int value) {
    for (int i=0; i < size; i++) {
      if (list[i] == value) return i;
    }
    return -1;
   }
  
  public boolean contains(int value) {
    return (indexOf(value) != -1);
  }
}
