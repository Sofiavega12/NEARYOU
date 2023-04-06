package com.example.nearyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.nearyou.databinding.ActivityMainBinding;
import com.example.nearyou.databinding.ActivityRestaurantesBinding;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.util.Log;

public class Restaurantes extends AppCompatActivity {
    private TextInputLayout textInputLayout;
    ActivityRestaurantesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityRestaurantesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Log.d("com.example.nearyou","hola");

        List<Restaurante> restaurantes = new ArrayList<>();
        restaurantes.add(new Restaurante("Restaurante 1", Arrays.asList("Pizza", "Ensalada", "Hamburguesa")));
        restaurantes.add(new Restaurante("Restaurante 2",Arrays.asList("Sushi", "Arroz", "Sopa")));
        restaurantes.add(new Restaurante("Restaurante 3", Arrays.asList("Tacos", "Burritos", "Quesadillas")));

        binding.btnBuscarRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("com.example.nearyou","mundo");
                String userInput = binding.txtInput.getText().toString();
                List<Restaurante> restaurantesPorComida = Restaurante.buscarRestaurantesPorComida(restaurantes,userInput);
                //Log.d("Lista restaurantes: ", restaurantesPorComida.get(0).toString());
                binding.txtView.setText("Hola");
            }
        });
    }
    public static class Restaurante {
        private String nombre;
        private List<String> menu;

        public Restaurante(String nombre, List<String> menu) {
            this.nombre = nombre;
            this.menu = menu;
        }

        public String getNombre() {
            return nombre;
        }

        public List<String> getMenu() {
            return menu;
        }

        public static List<Restaurante> buscarRestaurantesPorComida(List<Restaurante> restaurantes, String comida) {
            List<Restaurante> restaurantesPorComida = new ArrayList<>();
            for (Restaurante restaurante : restaurantes) {
                if (restaurante.getMenu().contains(comida)) {
                    restaurantesPorComida.add(restaurante);
                }
            }
            return restaurantesPorComida;
        }
    }
}