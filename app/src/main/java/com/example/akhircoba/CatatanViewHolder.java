package com.example.akhircoba;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CatatanViewHolder extends RecyclerView.ViewHolder {

    public TextView JudulTv, IsiTv;

    public CatatanViewHolder(@NonNull View itemView) {
        super(itemView);
        JudulTv = itemView.findViewById(R.id.Judul_tv);
        IsiTv = itemView.findViewById(R.id.Isi_tv);
    }
}
