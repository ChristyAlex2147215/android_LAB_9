package com.example.recyclerview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AA_RecycleViewAdapter extends RecyclerView.Adapter<AA_RecycleViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<PlanetModel> planetModels;

    public AA_RecycleViewAdapter (Context context, ArrayList<PlanetModel> planetModels,
                                  RecyclerViewInterface recyclerViewInterface)
    {
        this.context=context;
        this.planetModels=planetModels;
        this.recyclerViewInterface=recyclerViewInterface;
    }

    //assign the layout for each items in the recycle view
    @NonNull
    @Override
    public AA_RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.recycler_view_row,parent,false);
        return new AA_RecycleViewAdapter.MyViewHolder(view,recyclerViewInterface);
    }

    //changes the values for each of the attributes in the view
    @Override
    public void onBindViewHolder(@NonNull AA_RecycleViewAdapter.MyViewHolder holder, int position) {
    holder.tvName.setText(planetModels.get(position).getPlanetname());
    holder.tvDescription.setText(planetModels.get(position).getPlanetdescription());
    holder.imageView.setImageResource(planetModels.get(position).getImage());
    holder.tvPrice.setText(planetModels.get(position).getPrice());
    holder.tvMilage.setText(planetModels.get(position).getMilage());

    }

    //return the number of items present in the list of items
    @Override
    public int getItemCount() {
        return planetModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvName,tvDescription,tvPrice,tvMilage;

        public MyViewHolder(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            tvName=itemView.findViewById(R.id.textview);
            tvDescription=itemView.findViewById(R.id.textview2);
            tvPrice=itemView.findViewById(R.id.textView3);
            tvMilage=itemView.findViewById(R.id.textView4);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface!=null)
                    {
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }

                }
            });

        }
    }
}

