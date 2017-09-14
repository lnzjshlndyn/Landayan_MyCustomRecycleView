package com.example.josh.mycustomrecycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JOSH on 14/09/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.AndroidVersionViewHolder> {
    ArrayList<AndroidVersion> androidVersionArrayList;

    public CustomAdapter(ArrayList<AndroidVersion> androidVersionArrayList) {
        this.androidVersionArrayList = androidVersionArrayList;
    }

    @Override
    public AndroidVersionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
//        AndroidVersionViewHolder androidViewHolder = new AndroidVersionViewHolder();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_layout, parent, false);

        AndroidVersionViewHolder androidViewHolder = new AndroidVersionViewHolder(view);

        return androidViewHolder;
    }

    @Override
    public void onBindViewHolder(AndroidVersionViewHolder holder, int position) {
        AndroidVersion androidVersion = androidVersionArrayList.get(position);
        holder.logo.setImageResource(androidVersion.getLogo());
        holder.codeName.setText("Code Name: " + androidVersion.getCodename());
        holder.version.setText("Version: " + androidVersion.getVersion());
        holder.api.setText("API: " + androidVersion.getApi());
        holder.date.setText("Release Date: " + androidVersion.getDate());
    }

    @Override
    public int getItemCount() {
        return androidVersionArrayList.size();
    }

    public static class AndroidVersionViewHolder extends RecyclerView.ViewHolder{
        ImageView logo;
        TextView codeName, version, api, date;

        public AndroidVersionViewHolder(View view) {
            super(view);

            logo = (ImageView) view.findViewById(R.id.iv_logo);
            codeName = (TextView) view.findViewById(R.id.tv_codename);
            version = (TextView) view.findViewById(R.id.tv_version);
            api = (TextView) view.findViewById(R.id.tv_api);
            date = (TextView) view.findViewById(R.id.tv_rd);
        }
    }
}