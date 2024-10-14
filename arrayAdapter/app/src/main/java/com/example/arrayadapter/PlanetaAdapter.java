package com.example.arrayadapter;

import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PlanetaAdapter extends ArrayAdapter<Planeta> {

    Context mContext;
    Integer mResource;
    List <Planeta>myListPlaneta;


    public PlanetaAdapter(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        myListPlaneta = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(mResource, parent, false);

        TextView tvnomeplaneta = view.findViewById(R.id.textViewNome);
        ImageView imageView = view.findViewById(R.id.imageView);

        Planeta planeta = myListPlaneta.get(position);
        tvnomeplaneta.setText(planeta.nome);
        imageView.setImageResource(planeta.foto);

        return (view);

    }
}
