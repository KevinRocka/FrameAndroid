package com.rocka.framemvc.model.listener;

import com.rocka.framemvc.model.bean.WeatherBean;

public interface OnLoadWeatherListener {
    void onLoadWeatherSuccess(WeatherBean weatherBean);

    void onLoadWeatherFailed();
}
