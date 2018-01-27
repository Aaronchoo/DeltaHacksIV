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

        final Button openAllergies = (Button) findViewById(R.id.openAllergies);
        openAllergies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openAllergy = new Intent(MainActivity.this, Allergies.class);
                startActivity(openAllergy);
            }
        });
    }
}
