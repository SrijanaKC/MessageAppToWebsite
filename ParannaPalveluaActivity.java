package com.example.srijanakc.sanopalaute;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

public class ParannaPalveluaActivity extends AppCompatActivity {

    TextView tv;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paranna_palvelua);

        tv = findViewById(R.id.tvPlace);
        st = getIntent().getExtras().getString("Yritys Oy");
        tv.setText(st);

        Button button1 = (Button) findViewById(R.id.neg);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ParannaPalveluaActivity.this, KirjoitaIdeaActivity.class));
            }
        });

        Button button2 = (Button) findViewById(R.id.pos);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ParannaPalveluaActivity.this, KirjoitaIdeaActivity.class));
            }
        });

        Button button3 = (Button) findViewById(R.id.pidea);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ParannaPalveluaActivity.this, KirjoitaIdeaActivity.class));
            }
        });

    }

    private EditText feedback;

    public void buttonOnClick (View v){

        Button button = (Button) v;
        feedback = (EditText) findViewById(R.id.txtPalaute);



    }
}
