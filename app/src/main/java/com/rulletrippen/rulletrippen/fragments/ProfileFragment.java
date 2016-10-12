package com.rulletrippen.rulletrippen.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rulletrippen.rulletrippen.R;

public class ProfileFragment extends Fragment {
    private static final String ARG_PAGE_NUMBER = "page_number";

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(int page) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_NUMBER, page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    private void displayRoute(String routeName, String eta, int points, int metersToStart){

    }
}
