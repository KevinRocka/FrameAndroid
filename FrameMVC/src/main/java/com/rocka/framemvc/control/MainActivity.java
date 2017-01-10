package com.rocka.framemvc.control;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rocka.framemvc.R;
import com.rocka.framemvc.model.bean.WeatherBean;
import com.rocka.framemvc.model.listener.OnLoadWeatherListener;
import com.rocka.framemvc.model.repository.WeatherRepositoryImpl;
import com.rocka.framemvc.model.repository.WeatherModel;
import com.rocka.framemvc.view.NormalTextView;


/**
 * xml文件做为view可控范围太低，只能在activity中操作更新view，activity既是control也是view。
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnLoadWeatherListener {

    private Button btnRequset;

    private NormalTextView txtContent;

    private WeatherModel mWeatherModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mWeatherModel = new WeatherRepositoryImpl(this);
    }

    private void initView() {
        btnRequset = (Button) findViewById(R.id.request_btn);
        txtContent = (NormalTextView) findViewById(R.id.content_txt);
        btnRequset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.request_btn) {
            mWeatherModel.getWeatherInfo();
        }
    }

    @Override
    public void onLoadWeatherSuccess(WeatherBean weatherBean) {
        if (weatherBean != null)
            txtContent.setText(weatherBean.getCity() + "  " + weatherBean.getTime() + "   " + weatherBean.getTemp());
    }

    @Override
    public void onLoadWeatherFailed() {
        Toast.makeText(this, "loading failed ...", Toast.LENGTH_LONG).show();
        txtContent.setText("loading failed... please try again later");
    }
}
