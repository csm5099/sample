package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ButtonActitity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_actitity);

        //패키지매니저 객체화
        final PackageManager pm = getPackageManager();
        //패키지 매니저 getInstalledApplications 패키지 리스트 가져오기
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        
        //뷰에 출력할 앱 패키지 리스트를 생성
        List<ApplicationInfo> list = new ArrayList<>();
        //패키지 리스트의 목록을 확인
        for (ApplicationInfo packageInfo : packages){
            Log.d("ApplicationINfo", "Installed package : " + packageInfo.packageName);
            Log.d("ApplicationINfo", "Source dir : " + packageInfo.sourceDir);
            Log.d("ApplicationINfo", "Launch Activity : " + pm.getLaunchIntentForPackage(packageInfo.packageName));

            list.add(packageInfo);
        }

        ((RecyclerView)findViewById(R.id.adapter)).setAdapter(new AppAdapter(pm, list));
        ((RecyclerView)findViewById(R.id.adapter)).setHasFixedSize((true));
        ((RecyclerView)findViewById(R.id.adapter)).setLayoutManager((new LinearLayoutManager(this)));



    }
}