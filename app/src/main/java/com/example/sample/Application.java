package com.example.sample;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.List;

//설치된 앱의 패키지와 인포메이션을 담을 모델 클래스 정의
//ApplicationInfo를 익스탠드하여 작성함
public class Application extends ApplicationInfo{

    List<ApplicationInfo> applicationDetails;
    PackageManager packageManager;
    boolean isSelected;

    public Application(PackageManager packageManager, List<ApplicationInfo> applicationDetails){
        this.applicationDetails = applicationDetails;
        this.packageManager = packageManager;
    }

    public List<ApplicationInfo> getApplicationDetails(){
        return applicationDetails;
    }

    public PackageManager getPackageManager(){
        return packageManager;
    }

    public boolean getSelected() {
        return isSelected;
    }

    public void setPackageManager(PackageManager packageManager){
        this.packageManager = packageManager;
    }

    public void setItems(List<ApplicationInfo> applicationDetails){
        this.applicationDetails = applicationDetails;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}