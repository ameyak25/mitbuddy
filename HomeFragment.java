package com.example.college.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import com.example.college.ContactsActivity;
import com.example.college.MainActivity;
import com.example.college.MainActivity2;
import com.example.college.MainActivity3;
import com.example.college.R;
import com.example.college.Website1Activity;
import com.example.college.Website2Activity;
import com.example.college.Website3Activity;
import com.example.college.WebsiteActivity;


import org.w3c.dom.Text;

import java.net.URI;

public class HomeFragment extends Fragment {

    //private HomeViewModel homeViewModel;
    private TextView tView;
    //private TextView tv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //homeViewModel =
               // ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView textView = view.findViewById(R.id.content);
        /*homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public voizvd onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        tView=(TextView) view.findViewById(R.id.explore);
        tView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (getActivity(), MainActivity3.class));
            }
        });
        TextView tView1=(TextView) view.findViewById(R.id.get1);
        tView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (getActivity(), MainActivity3.class));
            }
        });
        TextView tView2=(TextView) view.findViewById(R.id.get2);
        tView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (getActivity(), MainActivity3.class));
            }
        });
        TextView tView3=(TextView) view.findViewById(R.id.get3);
        tView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (getActivity(), MainActivity3.class));
            }
        });

        Button btn=(Button) view.findViewById(R.id.contacts);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent (getActivity(), ContactsActivity.class));
           }
       });

        Button btn1=(Button) view.findViewById(R.id.all);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (getActivity(), WebsiteActivity.class));
            }
        });
        Button btn2=(Button) view.findViewById(R.id.placement);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (getActivity(), Website1Activity.class));
            }
        });
        Button btn3=(Button) view.findViewById(R.id.news);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (getActivity(), Website2Activity.class));
            }
        });
        Button btn4=(Button) view.findViewById(R.id.campus);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (getActivity(), Website3Activity.class));
            }
        });

        return view;
    }

}