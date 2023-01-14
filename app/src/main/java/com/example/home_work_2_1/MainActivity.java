package com.example.home_work_2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText gmail;
    private EditText theme;
    private EditText text;
    private Button send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("plain/text");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{gmail.getText().toString()});
                email.putExtra(Intent.EXTRA_SUBJECT, theme.getText().toString());
                email.putExtra(Intent.EXTRA_TEXT, text.getText().toString());
                startActivity(email);
            }
        });
    }

    private void initView() {
        gmail = findViewById(R.id.et_mail);
        theme = findViewById(R.id.et_themes);
        text = findViewById(R.id.et_text);
        send = findViewById(R.id.btn_send);
    }

}