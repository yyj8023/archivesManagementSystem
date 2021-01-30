package com.archivesManagementSystem.springboot.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MD5Utils {
    public static String MD5(String password){
        String salt = "!@#$%^CMGD!@#$%";
        String pwdSalt = password + salt;
        String result = "";
        try {
            //创建具有制定算法名称的信息摘要
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算即加密处理，总共加密5此
            byte[] output = messageDigest.digest(pwdSalt.getBytes());
            for (int i=0;i<5;i++){
                output = messageDigest.digest(output);
            }
            result = Base64.getEncoder().encodeToString(output);
            System.out.println(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
}
