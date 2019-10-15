package com.drzyl.cs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;

public class Cs {
  public static void main(String[] args) {
//    LinkedHashSet<String> aa = new LinkedHashSet<String>();
//    aa.add("qwe");
//    aa.add("qweq");
//    aa.add("qwew-asd");
//    Gson gson = new Gson();
//    String aaa = gson.toJson(aa);
//    LinkedHashSet<String> ss = new LinkedHashSet<String>(gson.fromJson(aaa, new TypeToken<Collection<String>>(){}.getType()));
//    System.out.println(aaa);
    String aa = "qwe/wer/ert";
    String[] bb = aa.split("/");
    System.out.println(bb.toString());
//    ArrayList qq = new ArrayList(bb);
//    for (String s : qq) {
//      System.out.println(s);
//    }
  }
}
