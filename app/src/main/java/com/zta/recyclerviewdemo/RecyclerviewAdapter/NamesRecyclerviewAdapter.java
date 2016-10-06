package com.zta.recyclerviewdemo.RecyclerviewAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zta.recyclerviewdemo.Model.NameItem;
import com.zta.recyclerviewdemo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zee Abbasi on 9/29/2016.
 */

public class NamesRecyclerviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<NameItem> nameItemArrayList;

    public NamesRecyclerviewAdapter(Context context, ArrayList<NameItem> nameItemArrayList){
        this.context= context;
        this.nameItemArrayList= nameItemArrayList;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        ViewGroup nameItemView= (ViewGroup) layoutInflater.inflate(R.layout.recycler_view_item, parent, false);
        NameItemViewHolder nameItemViewHolder= new NameItemViewHolder(nameItemView);
        return nameItemViewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        NameItemViewHolder nameItemViewHolder= (NameItemViewHolder) viewHolder;
        NameItem nameItem= nameItemArrayList.get(position);

        String lastName = nameItem.getLastName().substring(0,1).toUpperCase() + nameItem.getLastName().substring(1).toLowerCase();
        String firstName = nameItem.getFirstName().substring(0,1).toUpperCase() + nameItem.getFirstName().substring(1).toLowerCase();

        nameItemViewHolder.userNameTV.setText(lastName +", "+firstName);

    }

    @Override
    public int getItemCount() {
        return nameItemArrayList.size();
    }

    public class NameItemViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_user_name)
        TextView userNameTV;

        public NameItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
