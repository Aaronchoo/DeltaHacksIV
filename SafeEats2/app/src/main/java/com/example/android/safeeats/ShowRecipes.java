package com.example.android.safeeats;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_recipes);
        final EditText recieveOrder = (EditText) findViewById(R.id.foodbar);
        final Button submitOrder = (Button) findViewById(R.id.foodSearch);

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

    }
}
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