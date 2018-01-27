package com.example.android.safeeats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        //Assigning the buttons and views to their respective ids in the layout
        final Button addChoices = (Button) findViewById(R.id.add_list);
        final Button chooseOne = (Button) findViewById(R.id.choose_option);
        final EditText nameChoice = (EditText) findViewById(R.id.name_iteam);
        final Button resetAll = (Button) findViewById(R.id.reset_all);
        final EditText detailChoice = (EditText) findViewById(R.id.name_details);
        final TextView showChoice = (TextView) findViewById(R.id.chosen_one);
        final TextView showDetail = (TextView) findViewById(R.id.chosen_detail);

        //Create an array list that will hold the list of names and details
        final ArrayList<ListDetails> choices = new ArrayList<>();
        //Sets an onclicklistener taht will react when they add a choice
        addChoices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check to see if they have actually added info (The only important one is the name (first input))
                if ((nameChoice.getText().toString().equals("")))
                    //If not, tell users to add info
                    Toast.makeText(NameActivity.this, "Add info!", Toast.LENGTH_SHORT).show();
                else{
                    //Otherwise add the info to the arraylist
                    choices.add(new ListDetails(nameChoice.getText().toString(), detailChoice.getText().toString()));
                    //Reset all info
                    nameChoice.setText("");
                    detailChoice.setText("");
                    showChoice.setText("");
                    //Create the list view again w/ new details
                    ListDetailsAdapter someAdapter = new ListDetailsAdapter(NameActivity.this, choices);
                    ListView listChoice = (ListView) findViewById(R.id.list);
                    listChoice.setAdapter(someAdapter);}
            }
        });
        //Listens to see if they have asked to make a choice
        chooseOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Check to see if there are any added info yet
                if(choices.size()>0){
                    //Randomly choose a number
                    double random = Math.random();
                    //Set the range
                    random = random * choices.size();
                    //Cast it to get an integer
                    int randomChoice = (int) random;
                    //Display random choice
                    showChoice.setText(choices.get(randomChoice).getName());
                    //Display the details associated with the choice
                    showDetail.setText(choices.get(randomChoice).getDetails());
                }
                //If not do nothing!

            }
        });
        //If the reset button is clicked
        resetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Clear the elements
                choices.clear();;
                //Erase the list
                ListView listChoice = (ListView) findViewById(R.id.list);
                listChoice.setAdapter(null);
                //Set the textviews that may have content to show nothing
                showChoice.setText("");
                showDetail.setText("");
            }
        });


    }
}
