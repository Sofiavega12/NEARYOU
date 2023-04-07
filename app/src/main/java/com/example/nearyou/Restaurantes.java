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
        setContentView(R.layout.activity_restaurantes);
        binding = ActivityRestaurantesBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        List<Restaurante> restaurantes = new ArrayList<>();
        restaurantes.add(new Restaurante("Los Olivos","San Jose","7 am a 5 pm" ,Arrays.asList("Pizza", "Ensalada", "Hamburguesa")));
        restaurantes.add(new Restaurante("La cueva del sapo","San Jose","7 am a 5 pm" ,Arrays.asList("Sushi", "Arroz", "Sopa")));
        restaurantes.add(new Restaurante("Higueron","San Jose","7 am a 5 pm" , Arrays.asList("Tacos", "Burritos", "Quesadillas","Pizza")));

        binding.btnBuscarRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = binding.txtInput.getText().toString();
                List<Restaurante> restaurantesPorComida = Restaurante.buscarRestaurantesPorComida(restaurantes,userInput);
                // Asignar el resultado a un componente de la interfaz de usuario
                if (restaurantesPorComida.isEmpty()) {
                    binding.txtView.setText("SIN COINCIDENCIAS ENCONTRADAS");
                } else {
                    // La lista contiene elementos
                    StringBuilder stringBuilder = new StringBuilder();
                    for (Restaurante restaurante : restaurantesPorComida) {
                        stringBuilder.append("Nombre: "+restaurante.nombre.toString()+"\n"+"Ubicación: "+restaurante.ubicacion.toString()+"\n"+"Horario: "+restaurante.horario.toString() ).append("\n");
                        stringBuilder.append("---------------------------------" ).append("\n");
                    }
                    binding.txtView.setText(stringBuilder.toString());
                }
            }
        });
    }
    public static class Restaurante {
        private String nombre;
        private String ubicacion;
        private String horario;
        private List<String> menu;

        public Restaurante(String nombre,String ubicacion,String horario, List<String> menu) {
            this.nombre = nombre;
            this.ubicacion = ubicacion;
            this.horario = horario;
            this.menu = menu;
        }

        public String getNombre() {
            return nombre;
        }
        public String getUbicacion() {
            return ubicacion;
        }
        public String getHorario() {
            return horario;
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