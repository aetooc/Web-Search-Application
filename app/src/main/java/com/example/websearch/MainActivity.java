package com.example.websearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (EditText) findViewById(R.id.textView);
    }

    public void Click(View view){
        String url = textView.getText().toString();
        openWebPage(url);
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Toast.makeText(this, "Opening " + url, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        try {
            startActivity(intent);
        }
        catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Enter First!" , Toast.LENGTH_LONG).show();
        }

//  always returning null      if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }

//  no try & catch      startActivity( new Intent(Intent.ACTION_VIEW, webpage));
    }
}