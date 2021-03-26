package com.example.xtrack.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.xtrack.R;
import com.example.xtrack.trackingphase;

import pl.droidsonroids.gif.GifImageView;

import static com.mapbox.mapboxsdk.Mapbox.getApplicationContext;

public class HomeFragment extends Fragment  {
    private GifImageView btn;


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btn =  view.findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                opentrackingphase();
            }
        });
        return view;
    }

    private void opentrackingphase() {
        Intent intent = new Intent(getContext(), trackingphase.class);
        startActivity(intent);
    }
}