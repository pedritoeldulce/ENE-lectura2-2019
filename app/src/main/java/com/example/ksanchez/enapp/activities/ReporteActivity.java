package com.example.ksanchez.enapp.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ksanchez.enapp.IOHelper;
import com.example.ksanchez.enapp.R;
import com.example.ksanchez.enapp.modelo.DBHelper;
import com.example.ksanchez.enapp.modelo.Data;
import com.example.ksanchez.enapp.modelo.SQLConstantes;
import com.example.ksanchez.enapp.pojos.Respuesta;

import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;

import static android.os.Environment.getExternalStorageDirectory;


public class ReporteActivity extends AppCompatActivity implements  Response.Listener<JSONObject>, Response.ErrorListener{

    String dni = "ffff";
    TextView caja1,caja2,caja3,caja4,caja5,caja6,caja7,caja8,caja9,caja10;
    TextView caja11,caja12,caja13,caja14,caja15,caja16,caja17,caja18,caja19,caja20;
    TextView caja21,caja22,caja23,caja24,caja25,caja26,caja27,caja28,caja29,caja30;
    String nombreArchivo ="";

    Button btnFinalizar;

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);



        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);

        caja1= findViewById(R.id.dni);
        caja4= findViewById(R.id.aula);
        caja5= findViewById(R.id.sede);
        caja6= findViewById(R.id.cargo);
        caja8= findViewById(R.id.p1);
        caja9= findViewById(R.id.p2);
        caja10= findViewById(R.id.p3);
        caja11= findViewById(R.id.p4);
        caja12= findViewById(R.id.p5);
        caja13= findViewById(R.id.p6);
        caja14 = findViewById(R.id.p7_1);
        caja15 = findViewById(R.id.p7_2);
        caja16 = findViewById(R.id.p7_3);
        caja17 = findViewById(R.id.p7_4);
        caja18 = findViewById(R.id.p7_5);
        caja19 = findViewById(R.id.p8_1);
        caja20 = findViewById(R.id.p8_2);
        caja21 = findViewById(R.id.p8_3);
        caja22 = findViewById(R.id.p8_4);
        caja23 = findViewById(R.id.p8_5);
        caja24 = findViewById(R.id.p9_1);
        caja25 = findViewById(R.id.p9_2);
        caja26 = findViewById(R.id.p9_3);
        caja27 = findViewById(R.id.p9_4);




        Data data = new Data(ReporteActivity.this);
        data.open();


        final DBHelper developeruBD = new DBHelper(getApplicationContext());
        Respuesta cursos = new Respuesta();
        buscarCursosss(cursos);
        caja1.setText(cursos.getDNI());
        //caja2.setText(cursos.getNOMBRES());
        //caja3.setText(cursos.getAPELLIDOS());
        caja4.setText(cursos.getAULA());
        caja5.setText(cursos.getSEDE());
        caja6.setText(cursos.getCARGO());
       // caja7.setText(cursos.getNOTA());
        caja8.setText(cursos. getP1());
        caja9.setText(cursos. getP2());
        caja10.setText(cursos.getP3());
        caja11.setText(cursos.getP4());
        caja12.setText(cursos.getP5());
        caja13.setText(cursos.getP6());
        caja14.setText(cursos.getP07_1());
        caja15.setText(cursos.getP07_2());
        caja16.setText(cursos.getP07_3());
        caja17.setText(cursos.getP07_4());
        caja18.setText(cursos.getP07_5());
        caja19.setText(cursos.getP08_1());
        caja20.setText(cursos.getP08_2());
        caja21.setText(cursos.getP08_3());
        caja22.setText(cursos.getP08_4());
        caja23.setText(cursos.getP08_5());
        caja24.setText(cursos.getP09_1());
        caja25.setText(cursos.getP09_2());
        caja26.setText(cursos.getP09_3());
        caja27.setText(cursos.getP09_4());






        /****** FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE ************/
        /****** FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE ************/
        request= Volley.newRequestQueue(getApplicationContext());          //volley volley volley volley volley volley volley volley volley
        /****** FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE ************/
        /****** FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE ************/




        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {

                    finalizar();
                }

        });


    }

    public void buscarCursosss(Respuesta cursos) {
        final DBHelper developeruBD = new DBHelper(getApplicationContext());
        SQLiteDatabase bd= developeruBD.getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM RESPUESTAS ",null);
        if(cursor.moveToFirst()){
            do{
                cursos.setDNI(cursor.getString(0));
                //cursos.setNOMBRES(cursor.getString(1));
                //cursos.setAPELLIDOS(cursor.getString(2));
                cursos.setAULA(cursor.getString(3));
                cursos.setSEDE(cursor.getString(4));
                cursos.setCARGO(cursor.getString(5));
                cursos.setNOTA(cursor.getString(6));
                cursos.setP1(cursor.getString(7));
                cursos.setP2(cursor.getString(8));
                cursos.setP3(cursor.getString(9));
                cursos.setP4(cursor.getString(10));
                cursos.setP5(cursor.getString(11));
                cursos.setP6(cursor.getString(12));
                cursos.setP07_1(cursor.getString(13));
                cursos.setP07_2(cursor.getString(14));
                cursos.setP07_3(cursor.getString(15));
                cursos.setP07_4(cursor.getString(16));
                cursos.setP07_5(cursor.getString(17));
                cursos.setP08_1(cursor.getString(18));
                cursos.setP08_2(cursor.getString(19));
                cursos.setP08_3(cursor.getString(20));
                cursos.setP08_4(cursor.getString(21));
                cursos.setP08_5(cursor.getString(22));
                cursos.setP09_1(cursor.getString(23));
                cursos.setP09_2(cursor.getString(24));
                cursos.setP09_3(cursor.getString(25));
                cursos.setP09_4(cursor.getString(26));






            }while(cursor.moveToNext());
        }
    }



















    public void finalizar(){




            /****** WEB SERVICE  WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE  ************/
            /****** WEB SERVICE  WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE  ************/


           String url = "http://192.168.202.79/DevWServices/control5_ws.php?%20DNI="+caja1.getText()+"%20&NOMBRES=0%20&AULA="+caja4.getText()+"%20&SEDE="+caja5.getText()+"%20&CARGO=0%20&P1="+caja8.getText()+"%20&P2="+caja9.getText()+"%20&P3="+caja10.getText()+"%20&P4="+caja11.getText()+"%20&P5="+caja12.getText()+"%20&P6="+caja13.getText()+"%20&P7_1="+caja14.getText()+"%20&P7_2="+caja15.getText()+"%20&P7_3="+caja16.getText()+"%20&P7_4="+caja17.getText()+"%20&P7_5="+caja18.getText()+"%20&P8_1="+caja19.getText()+"%20&P8_2="+caja20.getText()+"%20&P8_3="+caja21.getText()+"%20&P8_4="+caja22.getText()+"%20&P8_5="+caja23.getText()+"%20&P9_1="+caja24.getText()+"%20&P9_2="+caja25.getText()+"%20&P9_3="+caja26.getText()+"%20&P9_4="+caja27.getText()+"";


            jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url,null,this,this);
            request.add(jsonObjectRequest);

            url = url.replace(" ","%20");
            Log.e("ReporteActivity","sincronizarWebService-url:"+url);


            /****** FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE ************/
            /****** FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE ************/



    }




    /****** WEB SERVICE  WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE  ************/
    /****** WEB SERVICE  WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE  ************/

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this, "Se registro exitosamente", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "No se puede enviar los datos ", Toast.LENGTH_SHORT).show();
    }


    /****** FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE ************/
    /****** FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE ************/


}
