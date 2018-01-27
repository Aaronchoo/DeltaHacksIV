package com.example.android.safeeats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button allergy = (Button) findViewById(R.id.alle);
        allergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openAllergy = new Intent(MainActivity.this, allergies.class);
                startActivity(openAllergy);
            }
        });

        Button choosingChoice = (Button) findViewById(R.id.choosing_names);
        choosingChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startChoices = new Intent(MainActivity.this, NameActivity.class);
                startActivity(startChoices);
            }
        });
    }
}
