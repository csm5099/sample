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

import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.ItemViewHolder>{

    private List<ApplicationInfo> items;
    private PackageManager pm;

    public AppAdapter(PackageManager pm,List<ApplicationInfo> items){
        this.items = items;
        this.pm = pm;
    }

    public void clear(){
        this.items.clear();
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_app_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position){
        holder.onBind(items.get(position));
    }

    @Override
    public int getItemCount(){
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        private RecyclerAppItemBinding binding;

        ItemViewHolder(View itemView){
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
        void onBind(ApplicationInfo info){
            binding.title.setText(pm.getApplicationLabel(info));
            binding.name.setText(info.packageName);
            try{
                binding.img.setBackground(pm.getApplicationIcon(info.packageName));
            } catch (PackageManager.NameNotFoundException e){
              e.printStackTrace();
            }
        }
    }
}
