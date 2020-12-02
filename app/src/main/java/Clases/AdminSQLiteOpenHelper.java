package Clases;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    //Constructor de mi fichero de base de gatos
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //OnCreate: Mer permite definir la configuració inicial de mi base de gatos
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE insumos(codigo int primary key, nombre text, precio float, stock int)");
    }

    //onUpgrade : me permite realizar cambios esquematicos en mi modelo
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
