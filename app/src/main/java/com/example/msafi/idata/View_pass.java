package com.example.msafi.idata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class View_pass extends AppCompatActivity {
TextView name, value;
PassDatabase passDatabase;
Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pass);
        name = findViewById(R.id.pass_name);
        value = findViewById(R.id.pass_value);
        delete = findViewById(R.id.delete);
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        passDatabase = new PassDatabase(this);
        Intent intent = getIntent();
       final String a1 = intent.getStringExtra("name");
        String a2 = intent.getStringExtra("value");

        name.setText(a1);
        value.setText(a2);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = a1;
                int a = passDatabase.delete(uname);
                if(a<=0){
                    Toast.makeText(getApplicationContext(), "Not Deleted!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Deleted!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
