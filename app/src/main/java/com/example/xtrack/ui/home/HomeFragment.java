package com.example.xtrack.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.xtrack.MainActivity;
import com.example.xtrack.R;
import com.example.xtrack.trackingphase;

import pl.droidsonroids.gif.GifImageView;

import static com.mapbox.mapboxsdk.Mapbox.getApplicationContext;
import com.kusu.loadingbutton.LoadingButton;

import android.net.wifi.WifiManager;

import org.jetbrains.annotations.NotNull;

public class HomeFragment extends Fragment  {

    private homeFragmentListener listener;
    private GifImageView btn;
    LoadingButton btnOnOff;
    WifiManager wifiManager;

    public TextView connectionStatus;

    public interface homeFragmentListener{
        void onInputSent(CharSequence cSeq);
        void setwifiManager(WifiManager wifiManager);
    }

    public HomeFragment(WifiManager wifiManager) {
        this.wifiManager = wifiManager;
        System.out.println("Running BroadCast Reciever");
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initialWork(view);
        exqListener();



        return view;
    }

    public void connectioStatusText(CharSequence newText){
        connectionStatus.setText(newText);

    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        if (context instanceof homeFragmentListener){
            listener = (homeFragmentListener) context;
        }else{
            throw new RuntimeException(context.toString()
            + "must implement homeFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    private void exqListener() {
        btnOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnOnOff.showLoading();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Intent panelIntent = new Intent(Settings.Panel.ACTION_WIFI);
                    startActivityForResult(panelIntent, 545);
                } else {
                    if (wifiManager.isWifiEnabled() == true) {
                        wifiManager.setWifiEnabled(false);
                    } else if (wifiManager.isWifiEnabled() == false) {
                        wifiManager.setWifiEnabled(true);
                    }
                }
                if (wifiManager.isWifiEnabled()) {
                    btnOnOff.setText("ON WIFI");
                    btnOnOff.hideLoading();
                } else {
                    btnOnOff.setText("OFF WIFI");
                    btnOnOff.hideLoading();
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentrackingphase();
            }
        });


    }

    private void initialWork(View view) {
        btn =  view.findViewById(R.id.button1);
        connectionStatus = (TextView) view.findViewById(R.id.connectionStatus);
        btnOnOff = view.findViewById(R.id.loadingButton);

        if (wifiManager.isWifiEnabled()) {
            btnOnOff.setText("OFF WIFI");
        } else {
            btnOnOff.setText("ON WIFI");
        }
    }

    private void opentrackingphase() {
        Intent intent = new Intent(getContext(), trackingphase.class);
        startActivity(intent);
    }
}