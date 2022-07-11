package com.example.homework1mouth3;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText theme;
    private EditText text;

    @SuppressLint({"QueryPermissionsNeeded", "IntentReset"})

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.send_btn).setOnClickListener(view -> {
            email = findViewById(R.id.email);
            theme = findViewById(R.id.theme);
            text = findViewById(R.id.text);

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
            intent.setData(Uri.parse(email.getText().toString()));
            intent.putExtra(Intent.EXTRA_SUBJECT, theme.getText().toString());
            intent.setType("plain/text");
            intent.putExtra(Intent.EXTRA_TEXT, text.getText().toString());
            startActivity(Intent.createChooser(intent, text.getText().toString()));
        });
    }
}