package com.example.android.safeeats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Allergies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergies);

        final Button submitA = (Button) findViewById(R.id.submitAllergy);
        final EditText allergySubmitted = (EditText) findViewById(R.id.enterAllergy);
        FileOutputStream out = new FileOutputStream("AllergyList.txt");
        FileInputStream in = new FileInputStream("AllergyList.txt");

        final ArrayList<listAllergies> allergiesList = new ArrayList<>();

        int lengthOfFood, offset;
        while ((c = in.read()) != -1) {
          in.read(lengthOfFood, offset, 1);
          offset++;
          allergiesList.add(new listAllergies(in.read(, offset, lengthOfFood)));
          offset += lengthOfFood;
        }

        submitA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(allergySubmitted.getText().toString() == ""){


                }
                else{

                    out.write(allergySubmitted.getText().toString().getBytes().length);
                    out.write(allergySubmitted.getText().toString().getBytes());
                    allergiesList.add(new listAllergies(allergySubmitted.getText().toString()));
                    allergySubmitted.setText("");
                    listAllergiesAdapter listAdapter = new listAllergiesAdapter(Allergies.this,allergiesList);
                    ListView listAlle = (ListView) findViewById(R.id.list);
                    listAlle.setAdapter(listAdapter);
                }
            }
        });

    }
}
