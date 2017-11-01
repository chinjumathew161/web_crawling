package com.example.user.app1;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.os.Bundle;


public class Mainnext extends AppCompatActivity {
    Button button,b2;
    public static  String message;
    public static  String m;
    public static final String stuff = "xxxx";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.stuff);
        addListenerOnButton();
        addListenerOnButton2();
    }

    public void addListenerOnButton() {

        button = (Button) findViewById(R.id.button4);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(message.equals("stackoverflow")) {

                    Intent browserIntent =
                            new Intent(Intent.ACTION_VIEW, Uri.parse("https://stackoverflow.com"));
                    startActivity(browserIntent);
                }
                else if(message.equals("tutorialspoint"))
                {
                    Intent browserIntent =
                            new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tutorialspoint.com"));
                    startActivity(browserIntent);
                }
                else if(message.equals("generic medicines"))
                {
                    Intent browserIntent =
                            new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.drugs.com"));
                    startActivity(browserIntent);
                }


            }

        });
    }
    public void addListenerOnButton2() {



        b2 = (Button) findViewById(R.id.button5);
        b2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                if(message.equals("tutorialspoint"))
                {
                    Intent i1 = new Intent(Mainnext.this,Mainnext2.class);
                    m="https://www.tutorialspoint.com";
                    Bundle bundle = new Bundle();
                    bundle.putString(stuff,m);
                    i1.putExtras(bundle);
                    startActivity(i1);
                }
                else if(message.equals("stackoverflow")) {
                    Intent i = new Intent(Mainnext.this,Mainnext3.class);
                    m="https://stackoverflow.com";
                    Bundle bundle = new Bundle();
                    bundle.putString(stuff,m);


                    i.putExtras(bundle);
                    startActivity(i);
                }
                else if(message.equals("generic medicines")) {
                    Intent i = new Intent(Mainnext.this,Mainnext3.class);
                    m="https://www.drugs.com";
                    Bundle bundle = new Bundle();
                    bundle.putString(stuff,m);


                    i.putExtras(bundle);
                    startActivity(i);
                }



            }
        });
    }
}
