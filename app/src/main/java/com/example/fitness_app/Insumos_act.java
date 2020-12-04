package com.example.fitness_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Insumos_act extends AppCompatActivity {

    private EditText edCodigo,edNombre,edPrecio,edStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos_act);

        edCodigo = (EditText)findViewById(R.id.et4);
        edNombre = (EditText)findViewById(R.id.et5);
        edPrecio = (EditText)findViewById(R.id.et6);
        edStock = (EditText)findViewById(R.id.et7);
    }

    public void AnadirInsumoa(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase(); //Permito la sobre escritura en mi base de datos.

        if(!edCodigo.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues();//Añade insumo

            registro.put("codigo", edCodigo.getText().toString());
            registro.put("nombre", edNombre.getText().toString());
            registro.put("precio", edPrecio.getText().toString());
            registro.put("stock", edStock.getText().toString());

            bd.insert("insumos", null, registro);
            bd.close();

            Toast.makeText(this, "Se ha guardado un insumo",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this,"Debe ingresar insumo",Toast.LENGTH_LONG).show();
        }

    }

    public void MostrarInsumnos(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String codigo = edCodigo.getText().toString();

        if(!codigo.isEmpty())
        {
            //Clase cursor me permite recorrer filas
            Cursor fila = bd.rawQuery("SELECT nombre, precio, stock FROM insumos where codigo="+codigo,null);

            if(fila.moveToFirst())
            {
                edNombre.setText(fila.getString(0));
                edPrecio.setText(fila.getString(1));
                edStock.setText(fila.getString(2));
            }
            else{
                Toast.makeText(this,"El producto no existe",Toast.LENGTH_LONG).show();
            }

        }
        else
        {
            Toast.makeText(this, "Debe ingresar el codigo del insumo", Toast.LENGTH_SHORT).show();
        }
    }

    public void EliminarInsumnos(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = edCodigo.getText().toString();

        if(!codigo.isEmpty())
        {

            bd.delete("insumos","codigo="+codigo,null);//Eliminar el campo según el codigo
            bd.close();
            Toast.makeText(this,"Has eliminado el insumo",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this, "Debe ingresar el codigo del insumo", Toast.LENGTH_SHORT).show();
        }



    }

    public void ActualizarInsumnos(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = edCodigo.getText().toString();

        ContentValues cont = new ContentValues();
        
        cont.put("codigo", edCodigo.getText().toString());
        cont.put("nombre", edNombre.getText().toString());
        cont.put("precio", edPrecio.getText().toString());
        cont.put("stock", edStock.getText().toString());

        if(!codigo.isEmpty())
        {
            bd.update("insumos", cont, "codigo"+codigo, null);
            Toast.makeText(this, "Se ha actualizado el campo",Toast.LENGTH_LONG).show();
        }
    }


}