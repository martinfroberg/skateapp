package com.rulletrippen.rulletrippen.database;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.rulletrippen.rulletrippen.MainActivity;
import com.rulletrippen.rulletrippen.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Martin-PC on 2016-10-04.
 */

public class HttpDatabase extends AsyncTask<String, Void, String> {
    public MainActivity MainActivity;

    public HttpDatabase(MainActivity ma){
        MainActivity = ma;

        //this.execute("http://localhost/rulletrippen/test.php");
        this.execute("http://192.168.1.179/Rulletrippen/test.php");
    }


    @Override
    protected String doInBackground(String... urls) {
        StringBuilder sb = new StringBuilder();
        //System.setProperty("java.net.preferIPv4Stack", "true");

        int rc = 2;
        try {
            URL url = new URL(urls[0]);

            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("User-Agent","Mozilla/5.0");

            urlConnection.connect();
            if (urlConnection.getResponseCode() != 2){
                rc = 10;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            rc = urlConnection.getResponseCode();

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();

            if (urlConnection != null){
                urlConnection.disconnect();
            }

        }catch(IOException e) {
            return e.toString();
        }

        return sb.toString();

    }

    @Override
    protected void onPostExecute(String result) {

        /*TextView tt = (TextView) MainActivity.findViewById(R.id.testText);
        tt.setText(result);*/

        //System.gc();
    }
}
