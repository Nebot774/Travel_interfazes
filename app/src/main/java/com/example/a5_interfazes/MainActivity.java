package com.example.a5_interfazes;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageSwitcher imageSwitcher;
    private int[] imageIds = {R.drawable.image1, R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8,R.drawable.image9,R.drawable.image10 };

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travels); // Asegúrate de que el nombre del layout sea correcto

        // Inicializar el Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);


        // Inicializar RecyclerView
        recyclerView = findViewById(R.id.Recycled);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ImageAdapter adapter = new ImageAdapter(this, imageIds, new ImageAdapter.ItemClickListener() {
@Override
public void onItemClick(View view, int position) {
        // Cambiar la imagen en ImageSwitcher al clickear en un ítem del RecyclerView
        imageSwitcher.setImageResource(imageIds[position]);
        }
        });
        recyclerView.setAdapter(adapter);

        // Inicializar ImageSwitcher
        imageSwitcher = findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
@Override
public View makeView() {
        ImageView imageView = new ImageView(MainActivity.this);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return imageView;
        }
        });

        // Configurar animaciones para ImageSwitcher
        imageSwitcher.setInAnimation(this, android.R.anim.fade_in);
        imageSwitcher.setOutAnimation(this, android.R.anim.fade_out);

    }
}


