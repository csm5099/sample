package com.example.myapplication;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

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
        for (ApplicationInfo packageInfo : packages) {
            Log.d("ApplicationInfo", "Installed package :" + packageInfo.packageName);
            Log.d("ApplicationInfo", "Source dir : " + packageInfo.sourceDir);
            Log.d("ApplicationInfo", "Launch Activity :" + pm.getLaunchIntentForPackage(packageInfo.packageName));

            // 화면에 설치된 앱 정보만 가져온다
            if(packageInfo.sourceDir.contains("/data/app/")){
                list.add(packageInfo);
            }
        }

        ((RecyclerView)findViewById(R.id.adapter)).setAdapter(new AppAdapter(pm,list));
        ((RecyclerView)findViewById(R.id.adapter)).setHasFixedSize(true);
        ((RecyclerView)findViewById(R.id.adapter)).setLayoutManager(new LinearLayoutManager(this));

    }
}