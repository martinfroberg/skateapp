package com.rulletrippen.rulletrippen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rulletrippen.rulletrippen.database.FetchFromDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //new FetchFromDatabase(this);
    }
}
