package com.android.daggerapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.daggerapp.R;
import com.android.daggerapp.components.MainComponent;
import com.android.daggerapp.databinding.ItemLayoutBinding;
import com.android.daggerapp.model.ProjectModel;
import com.android.daggerapp.viewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends BaseAdapter {

    private Context context;
    MainComponent mainComponent;
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
        View view = layoutInflater.inflate(R.layout.item_layout, null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.title.setText(projectModelList.get(position).getTitle());
        return view;
    }

    static final class ViewHolder{
        @BindView(R.id.title) TextView title;
        ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
