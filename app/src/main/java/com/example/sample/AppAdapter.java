package com.example.sample;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sample.databinding.RecyclerAppItemBinding;

import java.util.ArrayList;
import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.ItemViewHolder>{

//    설치된 앱의 모델 클래스 리스트 생성
    private ArrayList<Application> mApplicationList;
//
//    private List<ApplicationInfo> items;
//    private PackageManager pm;
//    public AppAdapter(PackageManager pm,List<ApplicationInfo> items){
//        this.items = items;
//        this.pm = pm;
//    }
//
//    public void clear(){
//        this.items.clear();
//    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_app_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position){
        holder.onBind(mApplicationList.get(position));
    }

    @Override
    public int getItemCount(){
        return mApplicationList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        private RecyclerAppItemBinding binding;

        ItemViewHolder(View itemView){
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
        void onBind(Application application){
//            binding.title.setText(pm.getApplicationLabel(info));
//            binding.name.setText(info.packageName);
            binding.title.setText(application.getPackageManager().getApplicationLabel(application));
            binding.name.setText(application.packageName);
            try{
                binding.img.setBackground(application.getPackageManager().getApplicationIcon(application.packageName));
            } catch (PackageManager.NameNotFoundException e){
              e.printStackTrace();
            }
        }
    }
}
