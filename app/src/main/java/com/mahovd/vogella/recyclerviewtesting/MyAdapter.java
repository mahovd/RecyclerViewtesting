package com.mahovd.vogella.recyclerviewtesting;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;


import java.util.ArrayList;

/**
 * Created by mahovd on 22/11/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<String> mDataset;

    //Provide a reference to the views for each data item
    //Complex data items may need more then one view per item, and
    //you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder{
        //each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;

        public ViewHolder(View v){
            super(v);
            txtHeader = (TextView) v.findViewById(R.id.first_line);
            txtFooter = (TextView) v.findViewById(R.id.second_line);
        }
    }

    public void add(int position, String item){
        mDataset.add(position,item);
        notifyItemInserted(position);
    }

    public void remove(String item){
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    //Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<String> myDataset){
        mDataset = myDataset;
    }

    //Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        //set the view's size, margins, paddings and layout parameter
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //Replace the contents of a view (invoked by the layout manager)


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element at your dataset at this position
        // - replace the contents of the view with that element
        final String name = mDataset.get(position);
        holder.txtHeader.setText(mDataset.get(position));

        //TODO: App crashes after approximately ten clicks
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(name);
            }
        });

        holder.txtFooter.setText("Footer: " + mDataset.get(position));

    }

    //Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
