package com.cookandroid.project_db.Network;

import android.os.AsyncTask;

import com.cookandroid.project_db.Custom_Adapter;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkInsert extends AsyncTask<String, Void, String> {

    private URL Url;
    private String URL_Address="http://localhost:8080/testWeb/testDB3_insert.jsp";
    private Custom_Adapter adapter;

    public NetworkInsert(Custom_Adapter adapter){
        this.adapter=adapter;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String res="";
        try{
            Url=new URL(URL_Address);
            HttpURLConnection con=(HttpURLConnection) Url.openConnection();

            //전송모드 설정
            con.setDefaultUseCaches(false);
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestMethod("POST");

            //content-type 설정
            con.setRequestProperty("Content-type","application/x-www-form-urlencoded; charset=utf-8");

            //전송값 설정
            StringBuffer buffer=new StringBuffer();
            buffer.append("id").append("=").append(strings[0]);
            buffer.append("&name").append("=").append(strings[1]);
            buffer.append("&phone").append("=").append(strings[2]);
            buffer.append("&grade").append("=").append(strings[3]);

            //서버로 전송
            OutputStreamWriter outStream=new OutputStreamWriter(con.getOutputStream(),"UTF-8");
            PrintWriter writer=new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush();

            StringBuilder builder=new StringBuilder();
            BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
            String line;
            while((line=in.readLine())!=null){
                builder.append(line +"\n");
            }

            res=builder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    //result

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        int res=0;
        try{
            res=JsonParser.getResultJson(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(res==0){
            //RESULT_OK==0
        }else{
            new NetworkGet(adapter).execute("");
        }
    }
}
