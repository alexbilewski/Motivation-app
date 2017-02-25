package com.example.android.motivationcard;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ImageButton bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (ImageButton) findViewById(R.id.imageButton);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent  = new Intent(Intent.ACTION_SEND);
                shareIntent .setType("text/plain");
                shareIntent .setType("image/jpg");
                String shareBody = "\"The journey to the top is more important than the view that is waiting there for You.\" ....Enjoy the process!";
                File photoFile = new File(getFilesDir(), "share.jpg");
                shareIntent .putExtra(Intent.EXTRA_TEXT, shareBody);
                shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(photoFile));
                startActivity(Intent.createChooser(shareIntent, "Share with Your friends"));
            }
        });
    }
}

