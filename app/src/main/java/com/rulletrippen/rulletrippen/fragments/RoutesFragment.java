package com.rulletrippen.rulletrippen.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rulletrippen.rulletrippen.R;

public class RoutesFragment extends Fragment {
    private static final String ARG_PAGE_NUMBER = "page_number";

    public RoutesFragment() {
        // Required empty public constructor
    }

    public static RoutesFragment newInstance(int page) {
        RoutesFragment fragment = new RoutesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_NUMBER, page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_routes, container, false);

        TextView txt = (TextView) rootView.findViewById(R.id.testText);
        int page = getArguments().getInt(ARG_PAGE_NUMBER, -1);
        txt.setText(String.format("Page %d", page));

        return rootView;
    }

}
