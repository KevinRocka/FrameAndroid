package com.rocka.framemvvm;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rocka.framemvvm.databinding.ActivityMainBinding;
import com.rocka.framemvvm.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this , R.layout.activity_main);
        new MainViewModel(binding);
    }


}
