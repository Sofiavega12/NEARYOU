package com.example.nearyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nearyou.databinding.ActivityMainBinding;
import com.example.nearyou.databinding.ActivityOpcionesBinding;

public class OpcionesActivity extends AppCompatActivity {
    ActivityOpcionesBinding binding;
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_opciones);
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityOpcionesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OpcionesActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });



        binding.btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //List<Restaurante> restaurantesPorComida = Restaurante.buscarRestaurantesPorComida(restaurantes, "Pizza");
                Intent intent = new Intent(OpcionesActivity.this, Restaurantes.class);
                startActivity(intent);
            }
        });
    }
}