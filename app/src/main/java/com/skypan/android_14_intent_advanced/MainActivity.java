package com.skypan.android_14_intent_advanced;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("A");
        setContentView(R.layout.activity_main);
        Button btn_to_B = (Button) findViewById(R.id.btn_to_B);

        btn_to_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, b.class);
                startActivity(intent);


            }
        });
    }

    public void Map(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps"));
        startActivity(intent);
    }

    public void edge(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com.tw"));
        startActivity(intent);
    }



    public void Phone(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+"8005551234"));
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    1);
        } else {
            try {
                startActivity(intent);
            } catch(SecurityException e) {
                e.printStackTrace();
            }
        }
    }
}