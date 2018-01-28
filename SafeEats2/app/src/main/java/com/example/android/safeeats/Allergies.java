package com.example.android.safeeats;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import static android.provider.Telephony.Mms.Part.FILENAME;

public class Allergies extends AppCompatActivity {
public class Allergies extends AppCompatActivity implements ListAllergiesDelegate {
    final ArrayList<listAllergies> allergiesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergies);

        final Button submitA = (Button) findViewById(R.id.submitAllergy);
        final EditText allergySubmitted = (EditText) findViewById(R.id.enterAllergy);

        final ArrayList<listAllergies> allergiesList = new ArrayList<>();

        final String filename = "allergicTo";
        final FileOutputStream out;

        final Button delete = (Button) findViewById(R.id.deleteSelected);

        submitA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(allergySubmitted.getText().toString().equals("")){
                    Toast.makeText(Allergies.this,"Enter an allergy!", Toast.LENGTH_SHORT);
                }
                else{
                    try {
                      out = openFileOutput(filename, Context.MODE_PRIVATE);
                      out.write(allergySubmitted.getText().toString());
                      out.close();
                    } catch (Exception e) {
                      e.printStackTrace();
                    }
                    allergiesList.add(new listAllergies(allergySubmitted.getText().toString()));
                    allergiesList.add(new listAllergies(allergySubmitted.getText().toString(),false));
                    allergySubmitted.setText("");
                    listAllergiesAdapter listAdapter = new listAllergiesAdapter(Allergies.this,allergiesList, Allergies.this);
                    ListView listAlle = (ListView) findViewById(R.id.list);
                    listAlle.setAdapter(listAdapter);
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<listAllergies> newList = new ArrayList<listAllergies>();

                for(int i =0; i<allergiesList.size(); i++){
                    if(!allergiesList.get(i).getChecked()){
                        newList.add(allergiesList.get(i));
                    }
                }
                allergiesList.clear();
                allergiesList.addAll(newList);

                listAllergiesAdapter listAdapter = new listAllergiesAdapter(Allergies.this,allergiesList, Allergies.this);
                ListView listAlle = (ListView) findViewById(R.id.list);
                listAlle.setAdapter(listAdapter);

            }
        });
    }

    @Override
    public void setChecked(int position, boolean checked) {
        allergiesList.get(position).setChecked(checked);

    }
}
