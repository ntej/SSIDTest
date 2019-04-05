package com.ntej.ssidtest;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button testButton;
    TextView resultTextView;
    private WifiManager wifiManager;
    private WifiInfo wifiInfo;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testButton = findViewById(R.id.button);
        resultTextView = findViewById(R.id.result_tv);
        setUp();
    }

    private void setUp() {

        wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClicked();
            }
        });
    }

    private void onButtonClicked() {
        try{
          wifiInfo =  wifiManager.getConnectionInfo();
          resultTextView.setText("SSID:"+ wifiInfo.getSSID());

        }catch (Exception e){
            Log.e(TAG, "onButtonClicked: ", e.fillInStackTrace());
            resultTextView.setText(e.getMessage());
        }
    }
}
