package com.example.seloger.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seloger.Annonce;
import com.example.seloger.AnnonceDetails;
import com.example.seloger.R;
import com.example.seloger.ViewHolders.AnnonceViewHolder;

import java.util.ArrayList;
import java.util.List;

public class AnnonceAdapter extends RecyclerView.Adapter<AnnonceViewHolder> {
    ArrayList<Annonce> annonces;
    Context context;
    public AnnonceAdapter (ArrayList<Annonce> annonces){
        this.annonces=annonces;
    }

    @NonNull
    @Override
    public AnnonceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_annonce_design,parent,false);
        return new AnnonceViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull AnnonceViewHolder holder, int position) {
        Annonce a=annonces.get(position);
        holder.idTv.setText("ID : " +a.getId());
        holder.prixTv.setText("Prix : " + String.valueOf(a.getPrix()));


        Bitmap imageContent = BitmapFactory.decodeByteArray(a.getImg(),0,a.getImg().length);
        holder.imageView.setImageBitmap(imageContent);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, AnnonceDetails.class);
                intent.putExtra("annonce",a);
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return annonces.size();
    }
}
