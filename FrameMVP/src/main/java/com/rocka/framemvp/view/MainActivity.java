package com.rocka.framemvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rocka.framemvp.R;
import com.rocka.framemvp.model.repository.WeatherModel;
import com.rocka.framemvp.model.repository.WeatherModelImpl;
import com.rocka.framemvp.presenter.weather.WeatherContract;
import com.rocka.framemvp.presenter.weather.WeatherPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, WeatherContract.View {

    private Button btnRequset;

    private TextView txtContent;

    private WeatherContract.Presenter mWeatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mWeatherPresenter = new WeatherPresenter(new WeatherModelImpl(), this);
        mWeatherPresenter.start();
    }

    private void initView() {
        btnRequset = (Button) findViewById(R.id.request_btn);
        txtContent = (TextView) findViewById(R.id.content_txt);
        btnRequset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.request_btn) {
            mWeatherPresenter.getWeatherInfo();
        }
    }

    @Override
    public void setPresenter(WeatherContract.Presenter presenter) {
        mWeatherPresenter = presenter;
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setContentText(String text) {
        txtContent.setText(text);
    }
}
