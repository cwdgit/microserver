package com.chinasofti.springcloud.utils;

import java.util.UUID;
public class UuidUtil
{
  public static String get32UUID()
  {
    String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
    return uuid;
  }
    public void getUUID(){
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        System.out.print(uuid);
    }
}
