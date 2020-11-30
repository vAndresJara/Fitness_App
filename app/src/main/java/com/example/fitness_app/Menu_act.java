package com.example.fitness_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int [] imagen = {R.drawable.a, R.drawable.b,R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        vf = (ViewFlipper)findViewById(R.id.slider);

        for(int i = 0; i< imagen.length; i++)
        {
            Flip_Image(imagen[i]);
        }

    }

    public void Flip_Image(int i)
    {
        //Vamos a dar la configuración del Slider
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view); //añadimos las imagenees al ViewFlipper
        vf.setFlipInterval(2300); //Su desplazamiento será de 2300  milisegundo
        vf.setAutoStart(true); //Iniciador de forma automatica.

        //Sentido al Slider
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);


    }

    public void Maps(View v)
    {
        Intent i = new Intent(this, Maps_act.class);
        startActivity(i);

    }

    public void Info(View v)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);

    }

    public void Clientes(View v)
    {
        //Se genera la info para enviar al Act.
        ArrayList<String> clientes = new ArrayList<String>();
        ArrayList<String> planes = new ArrayList<String>();

        clientes.add("Horacio");
        clientes.add("Alexis");

        planes.add("Xtreme");
        planes.add("Mindfullness");

        Intent i = new Intent(this, Clientes_act.class);
        i.putExtra("listaClientes",clientes);
        i.putExtra("listaPlanes",planes);
        startActivity(i);

    }




}