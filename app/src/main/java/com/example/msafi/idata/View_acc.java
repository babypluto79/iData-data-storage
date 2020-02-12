package com.example.msafi.idata;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class View_acc extends AppCompatActivity {
AccDatabase accDatabase;
TextView name, value;
Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_acc);
        name = findViewById(R.id.acc_name);
        value = findViewById(R.id.acc_value);
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
accDatabase = new AccDatabase(this);
      Intent intent = getIntent();
     final  String a1 = intent.getStringExtra("name");
      String a2 = intent.getStringExtra("value");

      name.setText(a1);
      value.setText(a2);

      delete.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String uname = a1;
              int a = accDatabase.delete(uname);
              if(a<=0){
                  Toast.makeText(getApplicationContext(), "Not Deleted!", Toast.LENGTH_SHORT).show();

              }
              else{
                  Toast.makeText(getApplicationContext(), "Deleted!", Toast.LENGTH_SHORT).show();

              }
          }

      });
    }
}
