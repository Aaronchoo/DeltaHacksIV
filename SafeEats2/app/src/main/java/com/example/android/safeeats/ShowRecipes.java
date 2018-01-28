package com.example.android.safeeats;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ShowRecipes extends AppCompatActivity {

    private interface RecipeCallback {
        void onRecipeRecieved(String text);
    }

    private final ObjectMapper objectMapper = new ObjectMapper();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    String url = "http://food2fork.com/api/search";
   // OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_recipes);
        setTitle("Show Recipes!");
        final EditText recieveOrder = (EditText) findViewById(R.id.foodbar);
        final Button submitOrder = (Button) findViewById(R.id.foodSearch);
        final ArrayList<PrefixProducts> finalist = new ArrayList<>();
        finalist.add(new PrefixProducts("http://static.food2fork.com/Jalapeno2BPopper2BGrilled2BCheese2BSandwich2B12B500fd186186.jpg", "Jalapeno Popper Grilled Cheese Sandwich", "2 jalapeno peppers, cut in half lengthwise and seeded\n" +
                "2 slices sour dough bread\n" +
                "1 tablespoon butter, room temperature\n" +
                "2 tablespoons cream cheese, room temperature\n" +
                "1/2 cup jack and cheddar cheese, shredded\n" +
                "1 tablespoon tortilla chips, crumbled", "http://food2fork.com/view/Jalapeno_Popper_Grilled_Cheese_Sandwich/35382"));
        finalist.add(new PrefixProducts("http://static.food2fork.com/Bacon2BWrapped2BJalapeno2BPopper2BStuffed2BChicken2B5002B5909939b0e65.jpg", "Bacon Wrapped Jalapeno Popper Stuffed Chicken", "4 small chicken breasts, pounded thin\n" +
                "salt and pepper to taste\n" +
                "4 jalapenos, diced\n" +
                "4 ounces cream cheese, room temperature\n" +
                "1 cup cheddar cheese, shredded\n" +
                "8 slices bacon", "http://food2fork.com/view/Bacon_Wrapped_Jalapeno_Popper_Stuffed_Chicken/35120"));
        finalist.add(new PrefixProducts("http://static.food2fork.com/scampibf5a.jpg", "Shrimp Scampi", "4 Tablespoons Butter\n" +
                "2 Tablespoons Olive Oil\n" +
                "1/2 whole Medium Onion, Finely Diced\n" +
                "4 cloves Garlic Cloves, Minced Or Pressed\n" +
                "1 pound Large Shrimp, Peeled And Deveined\n" +
                "1/2 cup White Wine\n" +
                "2 whole Lemons\n" +
                "4 dashes Hot Sauce (I Used Tabasco; More To Taste)\n" +
                "Salt And Freshly Ground Black Pepper, To Taste\n" +
                "8 ounces, weight Angel Hair Pasta\n" +
                "Chopped Fresh Basil To Taste\n" +
                "Chopped Fresh Parsley, To Taste\n" +
                "1/2 cup Grated Parmesan Cheese", "http://food2fork.com/view/Shrimp_Scampi/47032"));

        final PrefixAdapter finalAdapter = new PrefixAdapter(ShowRecipes.this, finalist);
        ListView listView = (ListView) findViewById(R.id.foodList);
        listView.setAdapter(finalAdapter);
        submitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recieveOrder.getText().toString().equals("")) {
                    Toast.makeText(ShowRecipes.this, "Input any type of food!", Toast.LENGTH_SHORT).show();
                } else {


                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PrefixProducts pro = finalist.get(position);
                Intent i = new Intent(Intent.ACTION_VIEW);
                Uri.parse(pro.getWebsite());
                startActivity(i);
            }
        });
    }
}
     /*   submitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (recieveOrder.getText().toString().equals("")) {
                    Toast.makeText(ShowRecipes.this, "Input any type of food!", Toast.LENGTH_SHORT).show();
                }
                else{client = new OkHttpClient();
                    try {
                        post("http://food2fork.com/api/search?key=28878fecb7604f01b315811acc08949b&q="+recieveOrder.getText().toString(),"recipe" );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            //Fix bug then navigation thing
        });
    }
    String post(String url, String json) throws IOException{
        RequestBody body = RequestBody.create(JSON,json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();

    }*/

 /*       submitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (recieveOrder.getText().toString().equals("")) {
                    Toast.makeText(ShowRecipes.this, "Input any type of food!", Toast.LENGTH_SHORT).show();
                } else {
                    client = new OkHttpClient();
                    try {
                        final TextView test = (TextView) findViewById(R.id.test);
                        run(recieveOrder.getText().toString(), new RecipeCallback() {
                            @Override
                            public void onRecipeRecieved(String text) {
                                test.setText(text);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    private void run(final String query, final RecipeCallback callback) throws IOException {

            Thread newThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                    Request request = new Request.Builder()
                            .url(url)
                            .post(RequestBody.create(MediaType.parse("application/json"), objectMapper.writeValueAsString(new RecipeRequest(query))))
                            .build();
                        Call call = client.newCall(request);
                        call.enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                callback.onRecipeRecieved(response.body().string());
                            }
                        });

                    } catch (IOException eception) {

                    }
                }
            });

            newThread.start();
    }

}
*/