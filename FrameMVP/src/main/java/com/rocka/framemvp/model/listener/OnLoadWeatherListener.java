package com.rocka.framemvp.model.listener;


import com.rocka.framemvp.model.bean.WeatherBean;

public interface OnLoadWeatherListener {
    void onLoadWeatherSuccess(WeatherBean weatherBean);

    void onLoadWeatherFailed();
}
