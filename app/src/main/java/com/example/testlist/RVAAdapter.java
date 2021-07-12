package com.example.testlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testlist.data.DataBaseCart;
import com.example.testlist.data.modalClass;

import java.util.ArrayList;

public class RVAAdapter extends RecyclerView.Adapter<RVAAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<modalClass> courseModalArrayList;
    private Context context;
    Global sharedData = Global.getInstance();


    private DataBaseCart dbHandler;
    // constructor
    public RVAAdapter(ArrayList<modalClass> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_spinner, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        modalClass modal = courseModalArrayList.get(position);
        holder.NameTV.setText(modal.getItemName());
        holder.price.setText(modal.getItemPrice());




    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView NameTV, price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            NameTV = itemView.findViewById(R.id.title);
            price= itemView.findViewById(R.id.price);
            itemView.findViewById(R.id.positive).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int quan=0;

                    String n= sharedData.getValue();
                    dbHandler = new DataBaseCart(itemView.getContext());
                    String Name = NameTV.toString();
                    System.out.println(Name);
                    if(quan==0)
                    {
                        quan++;
                        String quomo=Integer.toString(quan);
                        dbHandler.addNewItem(n,Name,quomo);
                    }
                    else
                    {
                        quan++;
                        String quomo=Integer.toString(quan);
                        dbHandler.UpdateQuantity(quomo);
                    }


                }
            });



        }
    }

}