package com.neversettle.statusdownloader.ui.instagram;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neversettle.statusdownloader.R;
import com.neversettle.statusdownloader.ui.main.MainActivity;
import com.neversettle.statusdownloader.widget.CustomAppBar;


public class InstagramFragment extends Fragment {


    public static InstagramFragment newInstance() {
        InstagramFragment fragment = new InstagramFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupToolbar();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_instagram, container, false);
    }

    private void setupToolbar() {
        CustomAppBar appBar = ((MainActivity) getActivity()).getCustomAppBar();
        appBar.setTitle(getString(R.string.instagram));
    }
}