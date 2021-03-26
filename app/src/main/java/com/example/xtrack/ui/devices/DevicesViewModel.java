package com.example.xtrack.ui.devices;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.xtrack.R;

public class DevicesViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private Animation animation;


    public DevicesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}