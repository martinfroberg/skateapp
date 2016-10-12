package com.rulletrippen.rulletrippen;

import com.rulletrippen.rulletrippen.fragments.*;
import com.rulletrippen.rulletrippen.database.FetchFromDatabase;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new AppPagerAdapter(getSupportFragmentManager()));

        tabs.setupWithViewPager(pager);


        //new FetchFromDatabase(this);
    }

    private class AppPagerAdapter extends FragmentPagerAdapter {

        public AppPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos){
                case 0: return RoutesFragment.newInstance(pos + 1);
                case 1: return ProfileFragment.newInstance(pos + 1);
                case 2: return SettingsFragment.newInstance(pos + 1);
                default: return null;
            }
        }
        @Override
        public int getCount(){
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int pos){
            switch(pos){
                case 0: return "Routes";
                case 1: return "Profile";
                case 2: return "Settings";
                default: return "Error";
            }
        }
    }
}
