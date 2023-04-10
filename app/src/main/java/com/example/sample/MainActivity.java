package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final PackageManager pm = getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        List<ApplicationInfo> list = new ArrayList<>();
        for (ApplicationInfo packageInfo : packages){
            Log.d("ApplicationINfo", "Installed package : " + packageInfo.packageName);
            Log.d("ApplicationINfo", "Source dir : " + packageInfo.sourceDir);
            Log.d("ApplicationINfo", "Launch Activity : " + pm.getLaunchIntentForPackage(packageInfo.packageName));

            list.add(packageInfo);
        }

        ((RecyclerView)findViewById(R.id.adapter)).setAdapter(new AppAdapter());
        ((RecyclerView)findViewById(R.id.adapter)).setHasFixedSize((true));
        ((RecyclerView)findViewById(R.id.adapter)).setLayoutManager((new LinearLayoutManager(this)));

    }
    
    // 앱 추가 버튼을 눌렀을 때 설치된 앱 아이콘, 이름, 패키지 이름 목록을 보여줌
    public void onAddButtonClicked(View v){
        Intent showAppList = new Intent(getApplicationContext(), ButtonActitity.class);
        startActivity(showAppList);
    }
}

