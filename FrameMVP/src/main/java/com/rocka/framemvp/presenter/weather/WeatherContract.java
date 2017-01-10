package com.rocka.framemvp.presenter.weather;


import com.rocka.framemvp.presenter.base.BasePresenter;
import com.rocka.framemvp.presenter.base.BaseView;

public interface WeatherContract {

    interface Presenter extends BasePresenter {
        /**
         * 执行获取天气请求
         */
        void getWeatherInfo();
    }

    interface View extends BaseView<Presenter> {
        /**
         * 展示Toast
         *
         * @param text
         */
        void showToast(String text);

        /**
         * 设置文本
         *
         * @param text
         */
        void setContentText(String text);
    }

}
