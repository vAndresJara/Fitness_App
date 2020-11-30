package com.example.fitness_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Planes;

public class Clientes_act extends AppCompatActivity {

    private Spinner spin1, spin2;
    private TextView text;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        spin1 = (Spinner)findViewById(R.id.spinClientes);
        spin2 = (Spinner)findViewById(R.id.spinPlanes);

        text = (TextView)findViewById(R.id.tv);
        edit = (EditText)findViewById(R.id.et3);

        // se recepcionan los datos desde el menú
        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");

        ArrayAdapter<String> adpat = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaClientes);

        spin1.setAdapter(adpat);

        ArrayList<String> listaPlanes = (ArrayList<String>) getIntent().getSerializableExtra("listaPlanes");

        ArrayAdapter<String> adpat2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPlanes);

        spin2.setAdapter(adpat2);

    }

    public void Calcular(View v)
    {
        Planes plan = new Planes();
        String cliente = spin1.getSelectedItem().toString();
        String planes = spin2.getSelectedItem().toString();

        int saldo = Integer.parseInt(edit.getText().toString());
        int xtreme = Integer.parseInt(plan.getXtreme());
        int mindfullness = Integer.parseInt(plan.getMindfullness());
        int resultado = xtreme - saldo;
        int resultados = mindfullness - saldo;

        if(cliente.equals("Horacio") && planes.equals("Xtreme"))
        {
            text.setText("El valor Xtreme es: " + resultado);
        }

        if(cliente.equals("Alexis") && planes.equals("Mindfullness"))
        {
            text.setText("El valor Mindfullness es: " + resultados);
        }
    }

}