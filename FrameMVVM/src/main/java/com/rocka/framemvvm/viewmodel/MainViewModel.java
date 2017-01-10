package com.rocka.framemvvm.viewmodel;


import android.util.Log;
import android.view.View;

import com.rocka.framemvvm.databinding.ActivityMainBinding;
import com.rocka.framemvvm.model.bean.RequestBean;
import com.rocka.framemvvm.model.bean.WeatherBean;
import com.rocka.framemvvm.model.listener.OnLoadWeatherListener;
import com.rocka.framemvvm.model.other.Constants;
import com.rocka.framemvvm.model.other.HttpTask;
import com.rocka.framemvvm.model.repository.WeatherModel;
import com.rocka.framemvvm.model.repository.WeatherModelImpl;

import org.json.JSONObject;

public class MainViewModel implements OnLoadWeatherListener{

    private ActivityMainBinding mActivityMainBinding;

    public WeatherBean bean;

    private WeatherModelImpl mWeatherModel;

    public MainViewModel(ActivityMainBinding activityMainBinding) {
        this.mActivityMainBinding = activityMainBinding;
        init();
    }

    private void init(){
        bean = new WeatherBean();
        mWeatherModel = new WeatherModelImpl();
        mWeatherModel.setListener(this);
        mActivityMainBinding.setViewModel(this);
    }

    public void request(View view) {
        mWeatherModel.getWeatherInfo();
    }

    @Override
    public void onLoadWeatherFailed() {

    }

    @Override
    public void onLoadWeatherSuccess(WeatherBean weatherBean) {
        bean.setTime(weatherBean.getTime());
        bean.setCity(weatherBean.getCity());
        bean.setTemp(weatherBean.getTemp());
        //这一句要加上
        mActivityMainBinding.setViewModel(this);
    }
}
