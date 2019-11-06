package com.example.ksanchez.enapp.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.ksanchez.enapp.pojos.Respuesta;

/**
 * Created by ksanchez on 20/03/2018.
 */

public class Data {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public Data(Context contexto) {
        this.contexto = contexto;
        sqLiteOpenHelper = new DBHelper(contexto);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void open(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close(){
        sqLiteOpenHelper.close();
    }

    public long getNumeroItemsRespuestas(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstantes.tablaRespuestas);
    }

    public void insertarRespuesta(Respuesta respuesta){
        sqLiteDatabase.insert(SQLConstantes.tablaRespuestas,null,respuesta.toValues());
    }

    public Respuesta getRespuesta(String dni){
        Respuesta respuesta = null;
        String[] whereArgs = new String[]{dni};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablaRespuestas, null,SQLConstantes.WHERE_CLAUSE_DNI,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                respuesta = new Respuesta();
                respuesta.setDNI(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_DNI)));
                respuesta.setNOMBRES(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_NOMBRES)));

                respuesta.setAPELLIDOS(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_APELLIDOS)));
                respuesta.setAULA(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_AULA)));

                respuesta.setSEDE(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_SEDE)));
                respuesta.setCARGO(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_CARGO)));

                respuesta.setNOTA(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_NOTA)));

                respuesta.setP1(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P1)));
                respuesta.setP2(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P2)));
                respuesta.setP3(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P3)));

                respuesta.setP4(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P4)));
                respuesta.setP5(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P5)));
                respuesta.setP6(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P6)));

                respuesta.setP07_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P07_1)));
                respuesta.setP07_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P07_2)));
                respuesta.setP07_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P07_3)));
                respuesta.setP07_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P07_4)));
                respuesta.setP07_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P07_5)));

                respuesta.setP08_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P08_1)));
                respuesta.setP08_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P08_2)));
                respuesta.setP08_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P08_3)));
                respuesta.setP08_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P08_4)));
                respuesta.setP08_5(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P08_5)));

                respuesta.setP09_1(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P09_1)));
                respuesta.setP09_2(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P09_2)));
                respuesta.setP09_3(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P09_3)));
                respuesta.setP09_4(cursor.getString(cursor.getColumnIndex(SQLConstantes.ENA_P09_4)));

            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return respuesta;
    }

    public void actualizarRespuestas(String dni, ContentValues contentValues){
        String[] whereArgs = new String[]{dni};
        sqLiteDatabase.update(SQLConstantes.tablaRespuestas,contentValues,SQLConstantes.WHERE_CLAUSE_DNI,whereArgs);
    }

    public boolean consultarregistro(){


        boolean correcto = true;
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablaRespuestas,null,null,null,null,null,null);

            if (cursor !=null) {
                if (cursor.getCount() > 0) {


                    correcto = false;

                }
            }
        }
        finally{
            if(cursor != null) cursor.close();
        }

        return correcto;

    }

}
