package com.example.hotnewsapp.util;

import android.util.Log;

import com.example.hotnewsapp.entity.LoginUser;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class Tools {

    public static LoginUser loginUser=null;

    //将输入流转换为String
    public static String streamToString(InputStream stream){
        byte[] bytes=null;
        try{
            ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
            byte[] buffer=new byte[1024];
            int len=0;
            while((len=stream.read(buffer))!=-1){
                outputStream.write(buffer,0,len);
            }
            outputStream.close();
            stream.close();
            bytes=outputStream.toByteArray();
        }catch (Exception e){
            Log.e("MYTAG", "streaToString失败，MESSAGE="+e.getMessage());

        }
        return new String(bytes);
    }


}
