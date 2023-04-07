package com.example.nearyou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.nearyou.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Creación de usuarios
        List<Usuario> listaUsuarios = new ArrayList<>();
        Usuario usuario1 = new Usuario("Juan", "123456", "juan@gmail.com");
        listaUsuarios.add(usuario1);
        Usuario usuario2 = new Usuario("Ana", "qwerty", "ana@hotmail.com");
        listaUsuarios.add(usuario2);
        Usuario usuario3 = new Usuario("Pedro", "contrasena", "pedro@yahoo.com");
        listaUsuarios.add(usuario3);

        binding.btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailInput = binding.inputCorreo.getText().toString();
                String passwordInput = binding.editPassword.getText().toString();

                if (Usuario.existeEnLista(listaUsuarios, emailInput, passwordInput)) {
                    Intent intent = new Intent(MainActivity.this, OpcionesActivity.class);
                    startActivity(intent);
                } else {
                    binding.txtviewErrores.setText("CORREO O CONTRASEÑA INCORRECTO");
                }
            }
        });


    }

    public static class Usuario {
        private String nombreUsuario;
        private String contrasena;

        private String correo;
        // otros campos de usuario

        public Usuario(String nombreUsuario, String contrasena,String correo) {
            this.nombreUsuario = nombreUsuario;
            this.contrasena = contrasena;
            this.correo = correo;
        }

        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public String getContrasena() {
            return contrasena;
        }

        public String getCorreo() {
            return correo;
        }

        public static boolean existeEnLista(List<Usuario> listaUsuarios, String Correo, String Contraseña) {
            for (Usuario u : listaUsuarios) {
                if (u.getCorreo().equals(Correo) && u.getContrasena().equals(Contraseña)) {
                    return true;
                }
            }
            return false;
        }
    }




}