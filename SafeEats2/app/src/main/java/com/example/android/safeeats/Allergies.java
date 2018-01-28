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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.provider.Telephony.Mms.Part.FILENAME;

public class Allergies extends AppCompatActivity implements ListAllergiesDelegate {
    final ArrayList<listAllergies> allergiesList = new ArrayList<>();

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    DatabaseReference foods = ref.child("Allergic To");

    public void addAllergy(String s) {
//        int listNumber = 0, tryCount = 0;
//        while (ref.child("Allergic To").child(Integer.toString(tryCount)).getKey() != "-1") {
//            listNumber++;
//            tryCount++;
//        }
//        ref.child("Allergic To").child(Integer.toString(listNumber)).setValue(s);
        ref.child("Allergic To").child(s).setValue(1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergies);
        //  String filename ="test";
        final Button submitA = (Button) findViewById(R.id.submitAllergy);
        final EditText allergySubmitted = (EditText) findViewById(R.id.enterAllergy);

        //String FILENAME = "AllergyList";
        // final FileOutputStream out = openFileOutput(FILENAME, Context.MODE_PRIVATE);
        //FileInputStream in = openFileInput(FILENAME);

        final Button delete = (Button) findViewById(R.id.deleteSelected);
        
       ValueEventListener eventListener = new ValueEventListener() {
         @Override
         public void onDataChange(DataSnapshot snapshot) {
             ArrayList<listAllergies> newList = new ArrayList<listAllergies>();
             String allergy = "";
             Boolean repeat = false;
            for (DataSnapshot ds : snapshot.getChildren()) {
//                repeat = false;
                allergy = ds.getKey();
                newList.add(new listAllergies(allergy, false));
//                for (int i = 0; i < allergiesList.size(); i++) {
//                    if (allergiesList.get(i).getAllergies().toUpperCase().equals(allergy.toUpperCase())) {
//                        repeat = true;
//                    }
//                }
//                if (allergy != "" && !repeat) {
//                    allergiesList.add(new listAllergies(allergy, false));
//                }
                allergiesList.clear();
                allergiesList.addAll(newList);

                listAllergiesAdapter listAdapter = new listAllergiesAdapter(Allergies.this,allergiesList, Allergies.this);
                ListView listAlle = (ListView) findViewById(R.id.list);
                listAlle.setAdapter(listAdapter);
            }
         }

         @Override
         public void onCancelled(DatabaseError databaseError) {
           Toast.makeText(Allergies.this, "Failed", Toast.LENGTH_SHORT).show();
         }
       };
       foods.addValueEventListener(eventListener);

        submitA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(allergySubmitted.getText().toString().equals("")){
                    Toast.makeText(Allergies.this,"Enter an allergy!", Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean repeated = false;
                    for(int i =0; i<allergiesList.size(); i++){
                        if(allergiesList.get(i).getAllergies().toUpperCase().equals(allergySubmitted.getText().toString().toUpperCase())){
                            repeated = true;
                            break;
                        }

                    }
                    if(repeated) {
                        Toast.makeText(Allergies.this,"The Allergy is already in the system!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        addAllergy(allergySubmitted.getText().toString());
                        allergiesList.add(new listAllergies(allergySubmitted.getText().toString(), false));
                        allergySubmitted.setText("");
                        listAllergiesAdapter listAdapter = new listAllergiesAdapter(Allergies.this, allergiesList, Allergies.this);
                        ListView listAlle = (ListView) findViewById(R.id.list);
                        listAlle.setAdapter(listAdapter);
                    }
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ArrayList<listAllergies> newList = new ArrayList<listAllergies>();

                for(int i =0; i<allergiesList.size(); i++){
                    if(allergiesList.get(i).getChecked()){
//                        newList.add(allergiesList.get(i));
//                    } else {
                        ref.child("Allergic To").child(allergiesList.get(i).getAllergies()).removeValue();
                    }
                }
//                allergiesList.clear();
//                allergiesList.addAll(newList);
//
//                listAllergiesAdapter listAdapter = new listAllergiesAdapter(Allergies.this,allergiesList, Allergies.this);
//                ListView listAlle = (ListView) findViewById(R.id.list);
//                listAlle.setAdapter(listAdapter);

            }
        });
    }

    @Override
    public void setChecked(int position, boolean checked) {
        allergiesList.get(position).setChecked(checked);

    }
}
