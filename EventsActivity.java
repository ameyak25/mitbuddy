package com.example.college.Dashboard;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.example.college.viewActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.os.FileUtils;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

import com.example.college.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class EventsActivity extends AppCompatActivity {
    public static final int PERMISSION_REQUEST_CODE = 1;
    private static final int REQUEST_GALLERY = 201;
    ImageView image;
    Button uploadbtn;
    TextView d;
    Uri pdfUri;

    FirebaseStorage storage;
    FirebaseDatabase database;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        storage=FirebaseStorage.getInstance();
        database=FirebaseDatabase.getInstance();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission
                        (EventsActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED) {
                    filePicker();
                }
                else
                {
                    ActivityCompat.requestPermissions(EventsActivity.this,new String[]
                            {Manifest.permission.READ_EXTERNAL_STORAGE},9);
                }
            }

        });
        d=findViewById(R.id.des);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(EventsActivity.this, viewActivity.class));
                Intent intent=new Intent(EventsActivity.this,viewActivity.class);
                startActivity(intent);
            }
        });
        uploadbtn=(Button) findViewById(R.id.upload);
        uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pdfUri!=null)
                {
                    uploadFile(pdfUri);
                }
                else
                {
                    Toast.makeText(EventsActivity.this,"Select a File"
                    ,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void uploadFile(Uri pdfUri)
    {
       progressDialog=new ProgressDialog(this);
       progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
       progressDialog.setTitle("Uploading in Progress");
       progressDialog.setProgress(0);
       progressDialog.show();

        final String fileName=System.currentTimeMillis()+"";
        //final String fileName1=System.currentTimeMillis()+"";
        StorageReference storageReference=storage.getReference();

        storageReference.child("Upload").child(fileName).putFile(pdfUri)
        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                String url=taskSnapshot.getStorage().getDownloadUrl().toString();
                DatabaseReference reference=database.getReference();
                reference.child(fileName).setValue(url).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(!task.isSuccessful())
                        {
                            Toast.makeText(EventsActivity.this,"Success",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(EventsActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
               // Toast.makeText(EventsActivity.this,"Something went Wrong",Toast.LENGTH_SHORT).show();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                int CurrentProgress=(int) (100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(CurrentProgress);
            }
        });
    }


    private void filePicker() {
        Toast.makeText(EventsActivity.this, "filePicker called", Toast.LENGTH_SHORT).show();

        Intent opengallery = new Intent();
        opengallery.setType("*/*");
        opengallery.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(opengallery, REQUEST_GALLERY);
    }

    /*private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(EventsActivity.this
                , Manifest.permission.READ_EXTERNAL_STORAGE)) {
            Toast.makeText(EventsActivity.this, "Please give permission to upload a file", Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(EventsActivity.this, new String[]
                    {Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }

    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(EventsActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }*/

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==9 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            filePicker();
        }
        else
        {
            Toast.makeText(EventsActivity.this,"please provide permission",Toast.LENGTH_SHORT).show();
        }
       /* switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(EventsActivity.this, "Authorized", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EventsActivity.this, "Authorization Failed", Toast.LENGTH_SHORT).show();
                }
        }*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_GALLERY && resultCode==RESULT_OK && data!=null)
        {
            pdfUri=data.getData();
        }
        else
        {
            Toast.makeText(EventsActivity.this,"Please select file",Toast.LENGTH_SHORT).show();
        }
        /* switch (requestCode) {
            case REQUEST_GALLERY:
                if (resultCode == RESULT_OK) {
                   // String path = data.getData().getPath();
                    //image.setImage(path);
                    pdfUri=data.getData();
                    //des.setText("A File is selected:"+data.getData().getLastPathSegment());
                }
                break;
        }*/
    }
}
