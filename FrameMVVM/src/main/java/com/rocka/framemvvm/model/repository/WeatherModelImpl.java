package com.rocka.framemvvm.model.repository;



import com.rocka.framemvvm.model.bean.RequestBean;
import com.rocka.framemvvm.model.bean.WeatherBean;
import com.rocka.framemvvm.model.listener.OnLoadWeatherListener;
import com.rocka.framemvvm.model.other.Constants;
import com.rocka.framemvvm.model.other.HttpTask;

import org.json.JSONObject;

/**
 * @Author：<a href="kevin.rocka@gmail.com">Kevin Rocka</a>
 * @version: 1.0
 * @Time: 2016/12/3 17:07
 * @Description: 数据获取的实现(从网络,从数据库,从文件等)
 */
public class WeatherModelImpl implements WeatherModel {

    OnLoadWeatherListener mOnLoadWeatherListener;


    @Override
    public void getWeatherInfo() {
        new HttpTask(){

            @Override
            public RequestBean onParse(JSONObject object) {
                final WeatherBean bean = new WeatherBean();
                try {
                    bean.setCity(object.getJSONObject("weatherinfo").getString("city"));
                    bean.setTemp(object.getJSONObject("weatherinfo").getString("temp"));
                    bean.setTime(object.getJSONObject("weatherinfo").getString("time"));
                }catch (Exception e){
                    e.printStackTrace();
                    onRequestFailed();
                }
                return bean;
            }

            @Override
            public void onRequestSuccess(RequestBean bean) {
                mOnLoadWeatherListener.onLoadWeatherSuccess((WeatherBean) bean);
            }

            @Override
            public void onRequestFailed() {
                mOnLoadWeatherListener.onLoadWeatherFailed();
            }
        }.path(Constants.WEATHER_URL).execute();
    }

    public void setListener(OnLoadWeatherListener listener) {
        this.mOnLoadWeatherListener = listener;
    }
}
