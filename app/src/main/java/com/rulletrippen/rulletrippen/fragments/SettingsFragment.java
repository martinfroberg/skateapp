package com.rulletrippen.rulletrippen.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rulletrippen.rulletrippen.R;

public class SettingsFragment extends Fragment {
    private static final String ARG_PAGE_NUMBER = "page_number";

    public SettingsFragment() {
        // Required empty public constructor
    }

    public static SettingsFragment newInstance(int page) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_NUMBER, page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

}
