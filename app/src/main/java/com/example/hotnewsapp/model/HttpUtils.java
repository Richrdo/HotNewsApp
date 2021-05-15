package com.example.hotnewsapp.model;

import android.util.Log;

import com.example.hotnewsapp.entity.News;
import com.example.hotnewsapp.entity.State;
import com.example.hotnewsapp.util.Tools;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpUtils {
    public static final String TAG="MyTag"+"HttpUtils";
    private static String resultStr;

    static List<News> newsList=new ArrayList<>();
    static Gson gson=new Gson();
    static State result=new State();



    //向指定URL发送指定消息，并返回从服务器端获取到的String类型的数据
    public static String send(String strUrl,String content,String method,String contentType){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    URL url=new URL(strUrl);
                    HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                    //设置get或者post
                    connection.setRequestMethod(method);
                    connection.setConnectTimeout(5000);
                    connection.setRequestProperty("Content-Type",contentType);
                    connection.addRequestProperty("Connection","Keep-Alive");
                    OutputStream os=connection.getOutputStream();
                    Log.e(TAG, "send: "+content );
                    os.write(content.getBytes());
                    os.flush();
                    os.close();
                    if (connection.getResponseCode()==200){
                        resultStr=Tools.streamToString(connection.getInputStream());
                        Log.d(TAG, "send: "+result);
                    }else{
                        resultStr="error";
                        Log.d(TAG, "send: "+connection.getResponseCode());
                    }
                } catch (SocketTimeoutException e){
                    resultStr="NetWorkBroken";
                } catch (IOException e){
                    e.printStackTrace();
                    resultStr="other Error";
                }
            }
        });
        thread.start();
        try{
            thread.join();
            Thread.sleep(20);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return resultStr;
    }

    public static String send(String strUrl){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    URL url=new URL(strUrl);
                    HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                    connection.setConnectTimeout(5000);
                    connection.setRequestMethod("GET");
                    connection.addRequestProperty("Connection","Keep-Alive");
                    if (connection.getResponseCode()==200){
                        resultStr=Tools.streamToString(connection.getInputStream());
                        Log.d(TAG, "send: "+result);
                    }else{
                        resultStr="error";
                        Log.d(TAG, "send: "+connection.getResponseCode());
                    }
                } catch (SocketTimeoutException e){
                    resultStr="NetWorkBroken";
                } catch (IOException e){
                    e.printStackTrace();
                    resultStr="other Error";
                }
            }
        });
        thread.start();
        try{
            thread.join();
            Thread.sleep(20);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return resultStr;
    }


    //登录操作
    public static State login(String strUrl){
        resultStr=send(strUrl," ","POST","application/json");
        if (resultStr.equals("NetWorkBroken")){
            result.setCode(404);
            result.setMessage("出现网络问题，请检查是否联网！");
        }else if (resultStr.equals("other Error")){
            result.setCode(404);
            result.setMessage("出现其他故障！");
        }else{
            result=gson.fromJson(resultStr,State.class);
        }
        return result;
    }

    //根据获取到的String转化为列表
    public static List<News> getNews(String type){
        String strUrl="http://47.106.76.106:8080/hotNewsSys/news/"+type;
        resultStr=send(strUrl," ","POST","application/json");
        newsList=gson.fromJson(resultStr,new TypeToken<List<News>>(){}.getType());
        return newsList;
    }

    //根据关键字查询
    public static List<News> getNewsByKey(String key){
        String strUrl="http://47.106.76.106:8080/hotNewsSys/news/research?keywords="+key;
        resultStr=send(strUrl);
        newsList=gson.fromJson(resultStr,new TypeToken<List<News>>(){}.getType());
        return newsList;
    }

    //随机获取N条新闻
    public static List<News> getNRandomNews(int n){
        String strUrl="http://47.106.76.106:8080/hotNewsSys/news/getNHotNews?number="+n;
        resultStr=send(strUrl);
        newsList=gson.fromJson(resultStr,new TypeToken<List<News>>(){}.getType());
        return newsList;
    }

    public static List<News> getCollectNews(String email){
        String strUrl="http://47.106.76.106:8080/hotNewsSys/favorites/getFav?email="+email;
        resultStr=send(strUrl);
        newsList=gson.fromJson(resultStr,new TypeToken<List<News>>(){}.getType());
        return newsList;
    }
}
