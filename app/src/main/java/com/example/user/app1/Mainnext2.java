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

public class Mainnext2 extends AppCompatActivity  {

    private EditText  resp;
    private TextView t;
    public static  String siteUrl;
    Databasehelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next2);
        mydb=new Databasehelper(this);
        t=(TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        siteUrl= intent.getStringExtra(Mainnext.stuff);
        (new ParseURL()).execute(new String[]{siteUrl});


    }

    private class ParseURL extends AsyncTask<String, Void, String> {

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
                buffer.append("Title m2: " + title + "\r\n");

                Elements topicList = doc.select("h2");
                buffer.append("Topic list\r\n");
                for (Element topic : topicList) {
                    String data = topic.text();

                    buffer.append(data+"\r\n");
                }
                Elements topicList2 = doc.select("p");
                buffer.append("Topic list2\r\n");
                for (Element topic : topicList2) {
                    String data = topic.text();

                    buffer.append(data+"\r\n");
                }
                Elements topicList3 = doc.select("div.global");
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
            boolean result=mydb.insertData1(s);
            Cursor res1 = mydb.getAllData1();
            StringBuffer stringBuffer = new StringBuffer();
            if(res1!=null && res1.getCount()>0){
                while (res1.moveToNext()){
                    stringBuffer.append("Id: "+res1.getString(0)+"\n");


                }
                t.setText(stringBuffer.toString());

            }else{

            }
        }
    }
}