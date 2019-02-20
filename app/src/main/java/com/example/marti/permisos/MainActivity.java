package com.example.marti.permisos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.drm.DrmStore;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ASK_PERMISSIONS = 123;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        textView =  findViewById(R.id.textView);
    }

    public void examplePermission(View view) {
//        Intent cam = new  Intent("android.media.action.CAPTURE_IMAGE");
//        startActivity(cam);
        checkPermission();
    }

    public void clickotro(View view)
    {
        int hasWriteContactsPermission = checkSelfPermission(Manifest.permission.CAMERA);
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA))
            {
                Toast.makeText(this, "Dejame grabarte", Toast.LENGTH_SHORT).show();
                String[] lp = new  String[]{Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(this,lp,1);
            }
            else {
                String[] lp = new  String[]{Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(this,lp,1);
            }
        }
//        requestPermissions(new String[] {Manifest.permission.CAMERA},
//                REQUEST_CODE_ASK_PERMISSIONS);
    }
    public void clickubi(View view)
    {
        int hasWriteContactsPermission = checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION);
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION))
            {
                Toast.makeText(this, "Dejame rastrearte", Toast.LENGTH_SHORT).show();
                String[] lp = new  String[]{Manifest.permission.ACCESS_FINE_LOCATION};
                ActivityCompat.requestPermissions(this,lp,2);
            }
            else {
                String[] lp = new  String[]{Manifest.permission.ACCESS_FINE_LOCATION};
                ActivityCompat.requestPermissions(this,lp,2);
            }
        }
//        requestPermissions(new String[] {Manifest.permission.CAMERA},
//                REQUEST_CODE_ASK_PERMISSIONS);
    }
    

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        {
            case 1:
                if (grantResults.length>0 && grantResults[0] == 0)
                {
                    Toast.makeText(this, "Camara", Toast.LENGTH_SHORT).show();
                }
                
                break;
            case 2:
                Toast.makeText(this, "Ubicacion", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void checkPermission() {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {

            Toast.makeText(MainActivity.this, "This version is not Android 6 or later " + Build.VERSION.SDK_INT, Toast.LENGTH_LONG).show();

        } else {

            int hasWriteContactsPermission = checkSelfPermission(Manifest.permission.CAMERA);

            if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[] {Manifest.permission.CAMERA},
                        REQUEST_CODE_ASK_PERMISSIONS);

                Toast.makeText(MainActivity.this, "Requesting permissions", Toast.LENGTH_LONG).show();

            }else if (hasWriteContactsPermission == PackageManager.PERMISSION_GRANTED){

                Toast.makeText(MainActivity.this, "The permissions are already granted ", Toast.LENGTH_LONG).show();
                openCamera();

            }

        }

        return;
    }

    private void openCamera() {



        Intent intent = new Intent("android.media.action.CAPTURE_IMAGE");
        startActivity(intent);

    }





}

