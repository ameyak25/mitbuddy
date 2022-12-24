package com.example.college.ui.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import com.example.college.Dashboard.EventsActivity;
import com.example.college.Dashboard.PlacementActivity;
import com.example.college.Login.SignInActivity;
import com.example.college.LoginActivity;
import com.example.college.MainActivity3;
import com.example.college.R;


public class DashboardFragment extends Fragment {

   // private DashboardViewModel dashboardViewModel;
    private Button btn;
    private Button btn1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       // dashboardViewModel =
                //ViewModelProviders.of(this).get(DashboardViewModel.class);
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
       // final TextView textView = root.findViewById(R.id.text_dashboard);
       /* dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
       btn=(Button) view.findViewById(R.id.register);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
           }
       });
       btn1=(Button) view.findViewById(R.id.signin);
       btn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(getActivity(), SignInActivity.class));
           }
       });
       TextView tv=(TextView) view.findViewById(R.id.events);
       tv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getActivity(),"You have to Register first",Toast.LENGTH_SHORT).show();
               startActivity(new Intent(getActivity(), EventsActivity.class));
           }
       });
        TextView tv1=(TextView) view.findViewById(R.id.placement);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"You have to Register first",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(),PlacementActivity.class));
            }
        });

        TextView tv2=(TextView) view.findViewById(R.id.Mst);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"You have to Register first",Toast.LENGTH_SHORT).show();
            }
        });
        TextView tv3=(TextView) view.findViewById(R.id.notice);
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"You have to Register first",Toast.LENGTH_SHORT).show();
            }
        });
        TextView tv4=(TextView) view.findViewById(R.id.Exams);
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"You have to Register first",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}