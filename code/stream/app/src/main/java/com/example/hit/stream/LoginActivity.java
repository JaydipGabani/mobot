package com.example.hit.stream;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void submit(View v) {
        EditText uname = (EditText) findViewById(R.id.username);
        EditText pass = (EditText) findViewById(R.id.password);
        if (pass.getText().toString().equals("admin")) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("name", uname + "");
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(LoginActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

