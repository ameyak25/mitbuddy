package com.example.college.ui.notifications;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.college.R;
import com.example.college.StudentsActivity;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    //private NotificationsViewModel notificationsViewModel;
    ListView listView;
    List list = new ArrayList();
    ArrayAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // notificationsViewModel =
        // ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        //final TextView textView = root.findViewById(R.id.text_notifications);
       /* notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        Button btn = (Button) view.findViewById(R.id.log);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), StudentsActivity.class));
            }
        });
        Button btn1 = (Button) view.findViewById(R.id.Fees);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), StudentsActivity.class));
            }
        });
        Button btn2 = (Button) view.findViewById(R.id.submit);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), StudentsActivity.class));
            }
        });
        Button btn3 = (Button) view.findViewById(R.id.syllabus);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), StudentsActivity.class));
            }
        });
        Button btn4 = (Button) view.findViewById(R.id.exam);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), StudentsActivity.class));
            }
        });
        Button btn5 = (Button) view.findViewById(R.id.Result);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), StudentsActivity.class));
            }
        });
        Button btn6 = (Button) view.findViewById(R.id.Enquiry);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), StudentsActivity.class));
            }
        });



        return view;
    }
}
