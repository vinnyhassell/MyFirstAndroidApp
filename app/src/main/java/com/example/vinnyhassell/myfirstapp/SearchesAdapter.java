package com.example.vinnyhassell.myfirstapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class SearchesAdapter extends RecyclerView.Adapter<SearchesAdapter.MyViewHolder>
{

    private List<Search> searchesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView searchName;
        public CheckBox searchEnabled;

        public MyViewHolder(View view) {
            super(view);
            searchName = (TextView) view.findViewById(R.id.searchName);
            searchEnabled = (CheckBox) view.findViewById(R.id.searchEnabled);
        }
    }


    public SearchesAdapter(List<Search> searchesList) {
        this.searchesList = searchesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Search search = searchesList.get(position);
        holder.searchName.setText(search.getSearchName());
        //(String.valueOf(search.isSearchEnabled()));
        holder.searchEnabled.setChecked(search.isSearchEnabled());
    }

    @Override
    public int getItemCount() {
        return searchesList.size();
    }
}
