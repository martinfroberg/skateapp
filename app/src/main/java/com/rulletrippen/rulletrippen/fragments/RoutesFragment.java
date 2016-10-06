package com.rulletrippen.rulletrippen.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rulletrippen.rulletrippen.R;

public class RoutesFragment extends Fragment {

    public RoutesFragment() {
        // Required empty public constructor
    }

    public static RoutesFragment newInstance() {
        RoutesFragment fragment = new RoutesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_routes, container, false);
    }

}
