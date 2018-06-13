package com.sauravkumar71920gmail.atulyam;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class AboutUsActivity extends AppCompatActivity {

    Toolbar  mControlToolbar;

    AppCompatButton sauravLinked;
    AppCompatButton shivamLinked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        mControlToolbar = (Toolbar) findViewById(R.id.toolbar3);
        mControlToolbar.setTitle("Development Team");
        mControlToolbar.setTitleTextColor(getResources().getColor(R.color.white));

        sauravLinked = (AppCompatButton) findViewById(R.id.saurav_linkedin);
        shivamLinked = (AppCompatButton) findViewById(R.id.shivam_linkedin);

        sauravLinked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent saurav = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/saurav-kumar-347823133/"));
                startActivity(saurav);
            }
        });

        shivamLinked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shivam = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/shivam-singh-29ba97153/"));
                startActivity(shivam);
            }
        });
    }
}
