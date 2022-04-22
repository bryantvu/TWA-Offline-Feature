package com.pictroom.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class OfflineActivity extends Activity {

    private static final String TAG = "OfflineActivity";
    private boolean networkFlag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);

        Log.d(TAG, "onCreate");
        Button btnCheckNetwork=(Button)findViewById(R.id.btn_recheck);
        btnCheckNetwork.setOnClickListener(v -> checkNetwork());
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume");
        checkNetwork();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart");
        checkNetwork();
    }

//    @Override
//    protected void onPause(){
//        super.onPause();
//        Log.d(TAG, "onPause");
//        checkNetwork();
//    }

    private void checkNetwork(){
        if(!isNetworkAvailable()){
            Log.d(TAG, "network not available");
            Toast.makeText(this,"network offline", Toast.LENGTH_SHORT).show();
        }else if(!networkFlag){
            Log.d(TAG, "network available");
            networkFlag=true;
            Toast.makeText(this,"network available", Toast.LENGTH_SHORT).show();
            finish();
            startActivity(new Intent(OfflineActivity.this, MainActivity.class));

        }else{
            Log.d(TAG, "network available, already starting new activity");
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
