package com.rulletrippen.rulletrippen.database;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rulletrippen.rulletrippen.MainActivity;
import com.rulletrippen.rulletrippen.R;
import com.rulletrippen.rulletrippen.fragments.RoutesFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.rulletrippen.rulletrippen.R.drawable.route_border;


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
            String output = "";

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
                    output += line + "\n";
                }
                br.close();

                if (urlConnection != null){
                    urlConnection.disconnect();
                }

            }catch(IOException e) {
                return e.toString();
            }

            return output;

        }

        @Override
        protected void onPostExecute(String result) {
            LinearLayout routesLayout = (LinearLayout) routesFragment.getView().findViewById(R.id.routesLayout);
            try {
                JSONObject json = new JSONObject(result);
                if (json != null){

                    //Create gridlayout

                    GridLayout grid = new GridLayout(routesFragment.getContext());
                    /*grid.setColumnCount(2);
                    grid.setRowCount(2);*/
                    grid.setBackgroundResource(R.drawable.route_border);
                    //grid.setOrientation(GridLayout.HORIZONTAL);
                    /*ViewGroup.LayoutParams lP = grid.getLayoutParams();
                    lP.height = ViewGroup.LayoutParams.MATCH_PARENT;
                    lP.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    grid.setLayoutParams(lP);*/
                    routesLayout.addView(grid);


                    /*TextView tVName = new TextView(routesFragment.getContext());
                    tVName.setWidth(GridLayout.LayoutParams.WRAP_CONTENT);
                    tVName.setHeight(GridLayout.LayoutParams.WRAP_CONTENT);
                    tVName.setText(json.getString("title"));
                    grid.addView(tVName);

                    TextView tVETA = new TextView(routesFragment.getContext());
                    tVETA.setWidth(GridLayout.LayoutParams.WRAP_CONTENT);
                    tVETA.setHeight(GridLayout.LayoutParams.WRAP_CONTENT);
                    tVETA.setGravity(Gravity.END);
                    //TODO Eta calculations
                    tVETA.setText("14min");
                    grid.addView(tVETA);

                    TextView tVPoints = new TextView(routesFragment.getContext());
                    tVPoints.setWidth(GridLayout.LayoutParams.WRAP_CONTENT);
                    tVPoints.setHeight(GridLayout.LayoutParams.WRAP_CONTENT);
                    tVPoints.setText(json.getString("points"));
                    grid.addView(tVPoints);

                    TextView tVMetersToStart = new TextView(routesFragment.getContext());
                    tVMetersToStart.setWidth(GridLayout.LayoutParams.WRAP_CONTENT);
                    tVMetersToStart.setHeight(GridLayout.LayoutParams.WRAP_CONTENT);
                    tVMetersToStart.setGravity(Gravity.END);
                    //TODO Eta calculations
                    tVMetersToStart.setText("17m");
                    grid.addView(tVMetersToStart);*/




                }
            } catch (JSONException e){
                //TODO change to somthing useful
                Toast.makeText(routesFragment.getActivity(), "Error getting json.",Toast.LENGTH_LONG).show();
            }
        }
    }
}
