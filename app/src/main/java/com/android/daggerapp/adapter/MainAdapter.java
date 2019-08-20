package com.android.daggerapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.android.daggerapp.databinding.ItemLayoutBinding;
import com.android.daggerapp.model.ProjectModel;
import com.android.daggerapp.viewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends BaseAdapter {

    private Context context;
    LayoutInflater layoutInflater;
    List<ProjectModel> projectModelList = new ArrayList<>();

    public MainAdapter(Context context){
        this.context = context;
        this.layoutInflater = layoutInflater.from(this.context);
    }

    public void addItems(List<ProjectModel> list){
        projectModelList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return !projectModelList.isEmpty() ? projectModelList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return projectModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemLayoutBinding binding = ItemLayoutBinding.inflate(layoutInflater, parent,false);
        binding.title.setText(projectModelList.get(position).getTitle());
        return binding.getRoot();
    }
}
