package com.rocka.framemvp.presenter.weather;

import com.rocka.framemvp.model.bean.WeatherBean;
import com.rocka.framemvp.model.listener.OnLoadWeatherListener;
import com.rocka.framemvp.model.repository.WeatherModelImpl;

/**
 * 具体业务Presenter的实现,关联了WeatherContract.View接口，把网络请求到的数据提供给View。
 *
 */
public class WeatherPresenter implements WeatherContract.Presenter, OnLoadWeatherListener {

    WeatherModelImpl mWeatherModel;

    WeatherContract.View mWeatherView;

    public WeatherPresenter(WeatherModelImpl model, WeatherContract.View view) {
        this.mWeatherModel = model;
        this.mWeatherView = view;
        this.mWeatherModel.setListener(this);
    }

    @Override
    public void getWeatherInfo() {
        if (mWeatherModel != null) {
            mWeatherModel.getWeatherInfo();
        }
    }

    @Override
    public void start() {
        mWeatherView.setContentText("Loading Weather Presed Btn");
    }

    @Override
    public void onLoadWeatherSuccess(WeatherBean weatherBean) {
        mWeatherView.setContentText(weatherBean.getCity() + "————" + weatherBean.getTime() + "----" + weatherBean.getTemp());
        mWeatherView.showToast("loading success");
    }

    @Override
    public void onLoadWeatherFailed() {
        mWeatherView.setContentText("Loading Weather failed");
    }
}
