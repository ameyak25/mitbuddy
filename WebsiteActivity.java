package com.example.college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class WebsiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);
    }
    public void Open(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mitujjain.ac.in/Alumni"));
        startActivity(intent);
    }

}