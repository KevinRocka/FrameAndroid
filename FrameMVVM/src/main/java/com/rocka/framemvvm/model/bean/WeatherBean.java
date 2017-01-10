package com.rocka.framemvvm.model.bean;


public class WeatherBean extends RequestBean{

    public String city;

    public String time;

    public String temp;

    public WeatherBean(){
        this.setCity("江油");
        this.setTime("14:00");
        this.setTemp("20°");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
