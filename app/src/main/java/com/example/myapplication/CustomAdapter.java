package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
        Context ctx;
        ArrayList<Offre> list;

        public CustomAdapter(Context ctx, ArrayList<Offre> list) {
            this.ctx = ctx;
            this.list = list;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(ctx).inflate(R.layout.row, parent, false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MyViewHolder h, int pos) {
            Offre o = list.get(pos);

            h.id.setText("ID : " + o.getId());
            h.poste.setText(o.getPoste());
            h.desc.setText(o.getDescription());

            h.itemView.setOnClickListener(v -> {
                Intent i = new Intent(ctx, UpdateActivity.class);
                i.putExtra("id", o.getId());
                i.putExtra("poste", o.getPoste());
                i.putExtra("desc", o.getDescription());
                ctx.startActivity(i);
            });
        }

        @Override
        public int getItemCount() { return list.size(); }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView id, poste, desc;

            public MyViewHolder(View v) {
                super(v);
                id = v.findViewById(R.id.txt_id);
                poste = v.findViewById(R.id.txt_poste);
                desc = v.findViewById(R.id.txt_desc);
            }
        }
    }

