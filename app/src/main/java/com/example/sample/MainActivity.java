package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);
    }

    public void buttonListApps(View view) {
        List<ApplicationInfo> applicationInfoList = getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
        String[] stringArray = new String[applicationInfoList.size()];

        int i = 0;
        for (ApplicationInfo applicationInfo : applicationInfoList) {
            stringArray[i] = applicationInfo.packageName;
            i++;
        }
        listView.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, stringArray));
        textView.setText(applicationInfoList.size() + "Apps are installed");
    }
}

