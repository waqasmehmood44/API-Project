package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {
private List<ModelClass>  datalist;
private Context context;
public Adapter(Context context, List<ModelClass> datalist){

    this.context=context;
    this.datalist=datalist;
}

      class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView name, phone;
          CustomViewHolder( View itemView) {
            super(itemView);

               name= itemView.findViewById(R.id.name);
              phone=itemView.findViewById(R.id.phone);
        }
    }

     @Override
    public CustomViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
         LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
         View view = layoutInflater.inflate(R.layout.design, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(  Adapter.CustomViewHolder holder, int position) {
         holder.name.setText(datalist.get(position).getName());
        holder.phone.setText(datalist.get(position).getPhone());
     }

    @Override
    public int getItemCount() {
        return datalist.size();
    }


}
