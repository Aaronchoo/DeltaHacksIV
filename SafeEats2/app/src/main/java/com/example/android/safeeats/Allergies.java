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

public class Allergies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergies);

        final Button submitA = (Button) findViewById(R.id.submitAllergy);
        final EditText allergySubmitted = (EditText) findViewById(R.id.enterAllergy);

        final ArrayList<listAllergies> allergiesList = new ArrayList<>();

//        File file = new File(context.getFilesDir(), "AllergyList");
        File directory;
        if (filename.isEmpty()) {
            directory = getFilesDir();
        }
        else {
            directory = getDir(filename, MODE_PRIVATE);
        }
        File[] files = directory.listFiles();

        final FileOutputStream out = openFileOutput(filename, Context.MODE_PRIVATE);

        FileInputStream in = openFileInput(filename);
        Scanner s = new Scanner(in);
        while (sc.hasNext()) {
            allergiesList.add(new listAllergies(s.next()));
        }
//        int offset = 0, c;
//        String temp = "";
//        while ((c = in.read()) != -1) {
////          in.read();
////          offset++;
////          in.read(temp, offset, lengthOfFood);
////          allergiesList.add(new listAllergies(temp));
////          offset += lengthOfFood;
//            allergiesList.add(new listAllergies(in.read()));
//        }

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
