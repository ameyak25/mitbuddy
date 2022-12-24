package com.example.college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class StudentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
    }
    public void Link(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.rgpv.ac.in/Login/StudentLogin.aspx"));
        startActivity(intent);
    }
    public void Syllabus(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.rgpv.ac.in/Uni/frm_ViewScheme.aspx"));
        startActivity(intent);
    }
    public void Exams(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.rgpv.ac.in/AboutRGTU/Examination.aspx"));
        startActivity(intent);
    }
    public void Results(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://result.rgpv.ac.in/Result/ProgramSelect.aspx"));
        startActivity(intent);
    }

    public void Fee(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.mitujjain.ac.in/Download"));
        startActivity(intent);
    }
    public void Fee1(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.onlinesbi.com/sbicollect/icollecthome.htm"));
        startActivity(intent);
    }
    public void Enquiry(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.mitujjain.ac.in/Enquiry-Form"));
        startActivity(intent);
    }

}