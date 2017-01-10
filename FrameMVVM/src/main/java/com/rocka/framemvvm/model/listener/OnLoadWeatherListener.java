package com.rocka.framemvvm.model.listener;


import com.rocka.framemvvm.model.bean.WeatherBean;

public interface OnLoadWeatherListener {
    void onLoadWeatherSuccess(WeatherBean weatherBean);

    void onLoadWeatherFailed();
}
