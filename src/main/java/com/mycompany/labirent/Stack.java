
package com.mycompany.labirent;

import java.util.Arrays;


public class Stack {

  int kapasite;
  int[][] s; // Stack Dizisi
  int ust; // Ekleme ve çıkarmada artıp azalacak
  public  Stack(int kapasite) {
    this.kapasite = kapasite;
    s = new int[kapasite][2]; // Stack boyutu 
    ust = -1; //   Boş Stack’te eleman sayısı -1
}
  // Stack dolu mu? Yani ust==kapasite-1 ise dizi dolu
  boolean dolumu() {
    if (ust == kapasite - 1) {
      return true;
    } else
      return false;
  }

  // Stack boş mu? Yani ust==-1
  boolean bosmu() {
    return ust == -1;
  }
  //  Stack ekleme
  void push(int[] x) {
    if (!dolumu()) {
      ust = ust + 1;
      s[ust]=x;
        System.out.println(Arrays.toString(s[ust])+"Stack'e eklendi");
    }
  }
  // Stack eleman çıkarma
  int[] pop() {
    if (!bosmu()) {
      int[] tmp=s[ust];
      ust = ust - 1;
      System.out.println(Arrays.toString(s[ust + 1])+ "Stackten cikarildi");
      return tmp;
    }
    return null;
  }
  int[] peek(){
      int peek[]=s[ust];
      return peek;
  }
} 
