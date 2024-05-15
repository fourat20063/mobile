package com.example.seloger.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seloger.R;

public class AnnonceViewHolder extends RecyclerView.ViewHolder {

    public View view;
    public TextView idTv;
    public TextView prixTv;
    public ImageView imageView;

    public AnnonceViewHolder(@Nullable View itemView){
        super(itemView);
        this.view=itemView;
        this.idTv=itemView.findViewById(R.id.idTv);
        this.prixTv=itemView.findViewById(R.id.prixTv);
        this.imageView=itemView.findViewById(R.id.imageView);

    }
}
