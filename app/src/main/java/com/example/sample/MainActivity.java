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

    }
    
    // 앱 추가 버튼을 눌렀을 때 설치된 앱 아이콘, 이름, 패키지 이름 목록을 보여줌
    public void onAddButtonClicked(View v){
        Intent showAppList = new Intent(getApplicationContext(), ButtonActitity.class);
        startActivity(showAppList);
    }
}

