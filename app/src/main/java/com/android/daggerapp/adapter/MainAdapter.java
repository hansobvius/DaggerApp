package com.android.daggerapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.daggerapp.R;
import com.android.daggerapp.databinding.ItemLayoutBinding;
import com.android.daggerapp.model.ProjectModel;
import com.android.daggerapp.viewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

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

    @BindView(R.id.title)
    TextView title;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.item_layout, null);
        title.setText(projectModelList.get(position).getTitle());
        return view;
    }
}
