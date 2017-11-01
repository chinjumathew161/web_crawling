package com.example.user.app1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.String;
import  android.util.Log;
import java.io.IOException;
import android.os.AsyncTask;

public class Mainnext3 extends AppCompatActivity {
    private EditText  resp;
    private TextView t;
    public static  String siteUrl;
    Databasehelper mydb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next3);
        mydb1=new Databasehelper(this);
        t=(TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        siteUrl= intent.getStringExtra(Mainnext.stuff);
        if(siteUrl.equals("https://stackoverflow.com")) {

            (new ParseURL1()).execute(new String[]{siteUrl});

        }
        else if(siteUrl.equals("https://www.drugs.com")) {
            (new ParseURL2()).execute(new String[]{siteUrl});

        }
    }

    private class ParseURL1 extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            StringBuffer buffer = new StringBuffer();
            try {
                Log.d("JSwa", "Connecting to ["+strings[0]+"]");
                Document doc  = Jsoup.connect(strings[0]).get();
                Log.d("JSwa", "Connected to ["+strings[0]+"]");
                // Get document (HTML page) title
                String title = doc.title();
                Log.d("JSwA", "Title ["+title+"]");
                buffer.append("Title m3: " + title + "\r\n");

                Elements topicList = doc.select("h2");
                buffer.append("Topic list\r\n");
                for (Element topic : topicList) {
                    String data = topic.text();

                    buffer.append("Data rrrrr ["+data+"] \r\n");
                }
                Elements topicList2 = doc.select("p");
                buffer.append("Topic list2\r\n");
                for (Element topic : topicList2) {
                    String data = topic.text();

                    buffer.append(data+"\r\n");
                }

                Elements topicList3 = doc.select("li.-item");
                buffer.append("Topic list3\r\n");
                for (Element topic : topicList3) {
                    String data = topic.text();

                    buffer.append(data+"\r\n");
                }




            }
            catch(Throwable t) {
                t.printStackTrace();
            }

            return buffer.toString();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            boolean result=mydb1.insertData(s);
            Cursor res = mydb1.getAllData();
            StringBuffer stringBuffer = new StringBuffer();
            if(res!=null && res.getCount()>0){
                while (res.moveToNext()){
                    stringBuffer.append("Id: "+res.getString(0)+"\n");


                }
                t.setText(stringBuffer.toString());

            }else{

            }
        }
    }
    private class ParseURL2 extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            StringBuffer buffer = new StringBuffer();
            try {
                Log.d("JSwa", "Connecting to ["+strings[0]+"]");
                Document doc  = Jsoup.connect(strings[0]).get();
                Log.d("JSwa", "Connected to ["+strings[0]+"]");

                Elements topicList = doc.select("div.contentBox");
                buffer.append("Topic list\r\n");
                for (Element topic : topicList) {
                    String data = topic.text();

                    buffer.append(data +"\r\n");
                }





            }
            catch(Throwable t) {
                t.printStackTrace();
            }

            return buffer.toString();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            boolean result=mydb1.insertData2(s);
            Cursor res = mydb1.getAllData2();
            StringBuffer stringBuffer = new StringBuffer();
            if(res!=null && res.getCount()>0){
                while (res.moveToNext()){
                    stringBuffer.append("Id: "+res.getString(0)+"\n");


                }
                t.setText(stringBuffer.toString());

            }else{

            }
        }
    }


}
