package com.example.csern.citask;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText editTextUser;
    EditText editTextPass;
    Button buttonConnect;
    private Toast messToast;
    private User user;
    private GetWebService getWebService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextUser = (EditText) findViewById(R.id.editTextUser);
        editTextPass = (EditText) findViewById(R.id.editTextPass);
        buttonConnect = (Button) findViewById(R.id.buttonConnect);

        buttonConnect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonConnectAction();
            }
        });

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void buttonConnectAction() {

        getWebService = new GetWebService();
        getWebService.execute(Constaints.GET_BY_ID + "?user=" + editTextUser.getText().toString() +
                "&password=" + editTextPass.getText().toString(), "1");
    }

    public class GetWebService extends AsyncTask<String, Void, String> {

        URL url = null;
        String returnedObject;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            //super.onPostExecute(s);
            if (s.equals(editTextUser.getText().toString())) {
                user = new User(editTextUser.getText().
                        toString(), editTextPass.getText().toString());
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                //Bundle bundle = new Bundle();
                intent.putExtra("parametro", user);
                startActivity(intent);
                //showMessage(user.getName());
            } else {
                showMessage(s);
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                url = new URL (params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux: Android 1.5; " +
                        "es-Es) Class CITask");
                int answer = connection.getResponseCode();
                StringBuilder result = new StringBuilder();
                if (answer == HttpURLConnection.HTTP_OK) {
                    InputStream in = new BufferedInputStream(connection.getInputStream());
                    BufferedReader bf = new BufferedReader(new InputStreamReader(in));
                    String line;
                    while ((line = bf.readLine()) != null) {
                        result.append(line);
                    }
                    JSONObject answerJSON = new JSONObject(result.toString());
                    String resultEstado = answerJSON.getString("estado");
                    if (!resultEstado.equals("1")) {
                        returnedObject = "No se ha encontrado el usuario";
                    } else {
                        returnedObject = answerJSON.getString("user");
                    }
                }
            } catch (MalformedURLException mue) {
                return returnedObject = mue.toString();
            } catch (IOException ioe) {
                return returnedObject = ioe.toString();
            } catch (org.json.JSONException jsonException) {
                return returnedObject = jsonException.toString();
            }
            return returnedObject;
        }
    }

    public void showMessage(String message) {
        messToast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        messToast.setGravity(Gravity.CENTER, 0, 0);
        messToast.show();
    }
}
