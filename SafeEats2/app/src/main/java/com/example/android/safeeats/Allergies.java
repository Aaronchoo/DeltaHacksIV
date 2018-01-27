package com.example.android.safeeats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Allergies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergies);

        final Button submitA = (Button) findViewById(R.id.submitAllergy);
        final EditText allergySubmitted = (EditText) findViewById(R.id.enterAllergy);
<<<<<<< HEAD
        FileOutputStream out = new FileOutputStream("AllergyList.txt");
        FileInputStream in = new FileInputStream("AllergyList.txt");

=======
        final ArrayList<listAllergies> fixedList = new ArrayList<>();
        fixedList.add(new listAllergies("Peanuts"));
        fixedList.add(new listAllergies("Eggs"));
        fixedList.add(new listAllergies("Milk"));
        fixedList.add(new listAllergies("Shell Fish"));
        fixedList.add(new listAllergies("Tofu"));
        fixedList.add(new listAllergies("Food#1"));
        fixedList.add(new listAllergies("Peanuts#2"));
        fixedList.add(new listAllergies("Peanuts#3"));
        fixedList.add(new listAllergies("Peanuts#4"));
        listAllergiesAdapter fixedAdapter = new listAllergiesAdapter(Allergies.this,fixedList);
        ListView listFixed = (ListView) findViewById(R.id.fixedlist);
        listFixed.setAdapter(fixedAdapter);
>>>>>>> 12e185ab1623aaed07f81b0f51675b6dd1496877
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
                    Toast.makeText(Allergies.this,"Enter an allergy!", Toast.LENGTH_SHORT);
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
