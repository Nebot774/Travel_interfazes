package com.example.a5_interfazes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private int[] images;
    private LayoutInflater inflater;
    private ItemClickListener clickListener;

    // Constructor del adaptador
    ImageAdapter(Context context, int[] images, ItemClickListener clickListener) {
        this.inflater = LayoutInflater.from(context);
        this.images = images;
        this.clickListener = clickListener;
    }

    // Crear nuevos views (invocado por el layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_imagen, parent, false);
        return new ViewHolder(view);
    }

    // Reemplazar los contenidos de una vista (invocado por el layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
    }

    // Retorna el tamaño de tu dataset (invocado por el layout manager)
    @Override
    public int getItemCount() {
        return images.length;
    }

    // Proporcionar una referencia a las vistas para cada ítem de datos
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.mamaImagen);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // Interfaz para recibir clics en ítems
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}


