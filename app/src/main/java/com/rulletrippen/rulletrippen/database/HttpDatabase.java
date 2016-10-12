package com.rulletrippen.rulletrippen.database;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.rulletrippen.rulletrippen.MainActivity;
import com.rulletrippen.rulletrippen.R;
import com.rulletrippen.rulletrippen.fragments.RoutesFragment;

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

public class HttpDatabase  {
    public static class UpdateRoutes extends AsyncTask<String, Void, String> {

        RoutesFragment routesFragment;

        public UpdateRoutes(RoutesFragment routesFragment){
            this.routesFragment = routesFragment;
            this.execute("http://192.168.1.179/Rulletrippen/test.php");
        }

        @Override
        protected String doInBackground(String... urls) {
            StringBuilder sb = new StringBuilder();

            try {
                URL url = new URL(urls[0]);

                HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("User-Agent","Mozilla/5.0");

                urlConnection.connect();

                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                int rc = urlConnection.getResponseCode();

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
            //TODO Create layout for routes with for loop
            TextView tV = (TextView) routesFragment.getView().findViewById(R.id.name);
            tV.setText(result);
        }
    }
}
