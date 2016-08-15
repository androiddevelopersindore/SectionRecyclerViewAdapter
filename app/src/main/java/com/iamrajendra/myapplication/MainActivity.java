package com.iamrajendra.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton_section;
    private Button mButton_flip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void init() {
        mButton_section = (Button) findViewById(R.id.section_b);
        mButton_flip = (Button) findViewById(R.id.flip_b);
        mButton_section.setOnClickListener(this);
        mButton_flip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent =null;
        switch (v.getId())
        {
            case R.id.section_b :
                intent  = new Intent(this,SectionActivity.class);
                startActivity(intent);
                break;
            case R.id.flip_b :
                intent  = new Intent(this,CardFilpAcitivity.class);
                startActivity(intent);
                break;

        }
    }
}
