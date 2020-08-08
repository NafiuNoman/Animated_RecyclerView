package com.example.animals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    //ImageView image;
    // TextView text;

    Context context;
    String [] conName;
    int [] continentPic;

    static  String msg;

    public MyAdapter(Context context,String[] name, int[] continentPic) {
        this.context = context;
        conName = name;
        this.continentPic = continentPic;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        // we can use context or parent.getContext() in LayoutInflater.from(.....);

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.my_row,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);




        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {




        holder.textView.setText(conName[position]);
        holder.imageView.setImageResource(continentPic[position]);
        holder.imageView.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_animation));
        holder.textView.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_scale));

         msg = holder.textView.getText().toString();



        holder.customRowId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int con = holder.customRowId.getChildCount();
                Toast.makeText(context, "count is"+con, Toast.LENGTH_SHORT).show();
         
            }
        });




    }

    @Override
    public int getItemCount() {
        return conName.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        ConstraintLayout customRowId;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            imageView = itemView.findViewById(R.id.imageId);
            textView = itemView.findViewById(R.id.textId);
            customRowId = itemView.findViewById(R.id.rowId);

        }



    }
}
