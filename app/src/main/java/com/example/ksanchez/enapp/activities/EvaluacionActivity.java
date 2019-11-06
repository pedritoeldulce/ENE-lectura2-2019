package com.example.ksanchez.enapp.activities;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ksanchez.enapp.IOHelper;
import com.example.ksanchez.enapp.R;
import com.example.ksanchez.enapp.fragments.eval1_p1;
import com.example.ksanchez.enapp.fragments.eval1_p2;
import com.example.ksanchez.enapp.fragments.eval1_p3;
import com.example.ksanchez.enapp.fragments.eval1_p4;
import com.example.ksanchez.enapp.modelo.Data;
import com.example.ksanchez.enapp.modelo.SQLConstantes;
import com.example.ksanchez.enapp.pojos.Respuesta;

import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Timer;
import java.util.TimerTask;

import static android.os.Environment.getExternalStorageDirectory;


import android.widget.TextView;  //reloj
import android.os.CountDownTimer;  //reloj
import android.widget.Toast;


public class EvaluacionActivity extends AppCompatActivity implements  Response.Listener<JSONObject>, Response.ErrorListener{

    Button btnFinalizar, btnSiguiente, btnAnterior;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment fragmentActual;
    String dni = "";
    int contador = 1;
    final int TIEMPO = 20;

    TextView reloj;          //reloj

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion);
        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        btnAnterior = (Button) findViewById(R.id.btnAnterior);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);


        reloj = (TextView) findViewById(R.id.reloj);     //reloj
        long tStart = System.currentTimeMillis();        //reloj


        Bundle bundle = getIntent().getExtras();
        dni = bundle.getString("dni");

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contador + 1 <=4){
                    if(validarFragment(contador)){
                        guardarFragment(contador);
                        contador++;
                        setFragment(contador,1);
                    }
                }
            }
        });

        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contador - 1 > 0) {
                    guardarFragment(contador);
                    contador--;
                    setFragment(contador,-1);
                }
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                //calcular nota

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(EvaluacionActivity.this);
                dialogo1.setTitle("Mensaje de Confirmación");
                dialogo1.setMessage("¿Está seguro que desea finalizar la evaluación?");
                dialogo1.setCancelable(false);

                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {

                if(validarFragment(contador)){
                    guardarFragment(contador);
                    contador++;
                    setFragment(contador,1);
                    finalizar();
                }

                    }
                });

                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialogo1.show();

            }
        });

        /***********************inicio reloj **************/
        /***********************inicio reloj **************/

        setFragment(1,1);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                finalizar();
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, TIEMPO*60*1000);

        CountDownTimer cTimer = null;
        cTimer = new CountDownTimer(TIEMPO*60*1000+5*1000, 1000) {
            public void onTick(long millisUntilFinished) {
                //Long.toString(millisUntilFinished);
                reloj.setText(String.format(" " + millisUntilFinished/(1000*60)));
                reloj.append(String.format(" : " ));

                if ((millisUntilFinished/1000)%60 <10){
                    reloj.append(String.format("0" + (millisUntilFinished/1000)%60));
                }else{
                    reloj.append(String.format("" + (millisUntilFinished/1000)%60));
                }

            }
            public void onFinish() {
                 finalizar();
            }
        };
        cTimer.start();

        /***********************fin reloj **************/
        /***********************fin reloj **************/


        /*final View decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener (new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0)
                { decorView.setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_FULLSCREEN); } } });*/





        /****** FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE ************/
        /****** FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE ************/
        request= Volley.newRequestQueue(getApplicationContext());          //volley volley volley volley volley volley volley volley volley
        /****** FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE ************/
        /****** FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE ************/



    }     /***  ojo aca acaba el oncreate lo q sigue es un metodo fuera del oncreate asi tienes q ponerlo***////

    /*@Override
    protected void onResume(){
        super.onResume();
        final int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        final View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(uiOptions);}*/


    public boolean validarFragment(int numFragment){
        boolean correcto = false;
        switch (numFragment){
            case 1:
                eval1_p1 eval1_p1 = (eval1_p1) fragmentActual;
                correcto=eval1_p1.validarFragment();
                break;
            case 2:
                eval1_p2 eval1_p2 = (eval1_p2) fragmentActual;
                correcto=eval1_p2.validarFragment();
                break;
            case 3:
                eval1_p3 eval1_p3 = (eval1_p3) fragmentActual;
                correcto=eval1_p3.validarFragment();
                break;
            case 4:
                eval1_p4 eval1_p4 = (eval1_p4) fragmentActual;
                correcto=eval1_p4.validarFragment();
                break;

        }
        return correcto;
    }


    void escribirCampoXml(XmlSerializer s, String campo,String valor){
        try {
            s.startTag("", campo);
            if(valor != null) s.text(valor);
            else s.text("");
            s.endTag("", campo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFragment(int numFragment,int direccion){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if(direccion > 0){
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
        }else{
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
        }
        switch (numFragment){
            case 1:
                btnAnterior.setVisibility(View.GONE);
                btnFinalizar.setVisibility(View.GONE);
                btnSiguiente.setVisibility(View.VISIBLE);
                fragmentActual = new eval1_p1(EvaluacionActivity.this, dni);
                fragmentTransaction.replace(R.id.fragment_evaluacion,fragmentActual,"pagina1");
                break;
            case 2:
                btnAnterior.setVisibility(View.VISIBLE);
                btnFinalizar.setVisibility(View.GONE);
                btnSiguiente.setVisibility(View.VISIBLE);
                fragmentActual = new eval1_p2(EvaluacionActivity.this,dni);
                fragmentTransaction.replace(R.id.fragment_evaluacion,fragmentActual,"pagina2");
                break;


            case 3:
                btnAnterior.setVisibility(View.VISIBLE);
                btnFinalizar.setVisibility(View.GONE);
                btnSiguiente.setVisibility(View.VISIBLE);
                fragmentActual = new eval1_p3(EvaluacionActivity.this,dni);
                fragmentTransaction.replace(R.id.fragment_evaluacion,fragmentActual,"pagina3");
                break;

            case 4:
                btnAnterior.setVisibility(View.VISIBLE);
                btnFinalizar.setVisibility(View.VISIBLE);
                btnSiguiente.setVisibility(View.GONE);
                fragmentActual = new eval1_p4(EvaluacionActivity.this,dni);
                fragmentTransaction.replace(R.id.fragment_evaluacion,fragmentActual,"pagina4");
                break;
        }
        fragmentTransaction.commit();
    }

    public void guardarFragment(int numFragment){
        switch (numFragment){
            case 1:
                eval1_p1 eval1_p1 = (eval1_p1) fragmentActual;
                eval1_p1.guardarFragment();
                break;
            case 2:
                eval1_p2 eval1_p2 = (eval1_p2) fragmentActual;
                eval1_p2.guardarFragment();
                break;

            case 3:
                eval1_p3 eval1_p3 = (eval1_p3) fragmentActual;
                eval1_p3.guardarFragment();
                break;
            case 4:
                eval1_p4 eval1_p4 = (eval1_p4) fragmentActual;
                eval1_p4.guardarFragment();
                break;

        }
    }

    @SuppressLint("NewApi")
    public void finalizar(){
        guardarFragment(contador);
        Data data = new Data(EvaluacionActivity.this);
        data.open();
        Respuesta respuesta = data.getRespuesta(dni);

        double nota = 0;


        respuesta.setNOTA(String.valueOf(nota));
        data.actualizarRespuestas(dni,respuesta.toValues());

        data.close();
        String nombreArchivo =  respuesta.getDNI()+ "C2"+ ".xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "RESPUESTAS");
            serializer.attribute("", "dni", respuesta.getDNI());
            escribirCampoXml(serializer, SQLConstantes.ENA_DNI, respuesta.getDNI());
           // escribirCampoXml(serializer, SQLConstantes.ENA_NOMBRES, respuesta.getNOMBRES());    borrnado nombre y cargo
           // escribirCampoXml(serializer, SQLConstantes.ENA_APELLIDOS, respuesta.getAPELLIDOS());
            escribirCampoXml(serializer, SQLConstantes.ENA_AULA, respuesta.getAULA());
            escribirCampoXml(serializer, SQLConstantes.ENA_SEDE, respuesta.getSEDE());
            escribirCampoXml(serializer, SQLConstantes.ENA_CARGO, respuesta.getCARGO());         //borrando nombre y cargo
         //   escribirCampoXml(serializer, SQLConstantes.ENA_NOTA, respuesta.getNOTA());

            escribirCampoXml(serializer, SQLConstantes.ENA_P1, respuesta.getP1());
            escribirCampoXml(serializer, SQLConstantes.ENA_P2, respuesta.getP2());
            escribirCampoXml(serializer, SQLConstantes.ENA_P3, respuesta.getP3());

            escribirCampoXml(serializer, SQLConstantes.ENA_P4, respuesta.getP4());
            escribirCampoXml(serializer, SQLConstantes.ENA_P5, respuesta.getP5());
            escribirCampoXml(serializer, SQLConstantes.ENA_P6, respuesta.getP6());

            escribirCampoXml(serializer, SQLConstantes.ENA_P07_1, respuesta.getP07_1());
            escribirCampoXml(serializer, SQLConstantes.ENA_P07_2, respuesta.getP07_2());
            escribirCampoXml(serializer, SQLConstantes.ENA_P07_3, respuesta.getP07_3());
            escribirCampoXml(serializer, SQLConstantes.ENA_P07_4, respuesta.getP07_4());
            escribirCampoXml(serializer, SQLConstantes.ENA_P07_5, respuesta.getP07_5());

            escribirCampoXml(serializer, SQLConstantes.ENA_P08_1, respuesta.getP08_1());
            escribirCampoXml(serializer, SQLConstantes.ENA_P08_2, respuesta.getP08_2());
            escribirCampoXml(serializer, SQLConstantes.ENA_P08_3, respuesta.getP08_3());
            escribirCampoXml(serializer, SQLConstantes.ENA_P08_4, respuesta.getP08_4());
            escribirCampoXml(serializer, SQLConstantes.ENA_P08_5, respuesta.getP08_5());

            escribirCampoXml(serializer, SQLConstantes.ENA_P09_1, respuesta.getP09_1());
            escribirCampoXml(serializer, SQLConstantes.ENA_P09_2, respuesta.getP09_2());
            escribirCampoXml(serializer, SQLConstantes.ENA_P09_3, respuesta.getP09_3());
            escribirCampoXml(serializer, SQLConstantes.ENA_P09_4, respuesta.getP09_4());


            /****** WEB SERVICE  WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE  ************/
            /****** WEB SERVICE  WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE  ************/


            String url = "http://192.168.202.79/DevWServices/control5_ws.php?%20DNI="+respuesta.getDNI()+"%20&NOMBRES=0%20&AULA="+respuesta.getAULA()+"%20&SEDE="+respuesta.getSEDE()+"%20&CARGO="+respuesta.getCARGO()+"%20&P1="+respuesta.getP1()+"%20&P2="+respuesta.getP2()+"%20&P3="+respuesta.getP3()+"%20&P4="+respuesta.getP4()+"%20&P5="+respuesta.getP5()+"%20&P6="+respuesta.getP6()+"%20&P7_1="+respuesta.getP07_1()+"%20&P7_2="+respuesta.getP07_2()+"%20&P7_3="+respuesta.getP07_3()+"%20&P7_4="+respuesta.getP07_4()+"%20&P7_5="+respuesta.getP07_5()+"%20&P8_1="+respuesta.getP08_1()+"%20&P8_2="+respuesta.getP08_2()+"%20&P8_3="+respuesta.getP08_3()+"%20&P8_4="+respuesta.getP08_4()+"%20&P8_5="+respuesta.getP08_5()+"%20&P9_1="+respuesta.getP09_1()+"%20&P9_2="+respuesta.getP09_2()+"%20&P9_3="+respuesta.getP09_3()+"%20&P9_4="+respuesta.getP09_4()+"";


            jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url,null,this,this);
            request.add(jsonObjectRequest);

            url = url.replace(" ","%20");
            Log.e("ReporteActivity","sincronizarWebService-url:"+url);


            /****** FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE ************/
            /****** FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE ************/



            serializer.endTag("", "RESPUESTAS");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "ENE_LECTURA2");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            File file2 = new File(nuevaCarpeta, "xfs088.xml");

            IOHelper.writeToFile(file,result);
            IOHelper.writeToFile(file2,"result");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finishAffinity();



    }

    @Override
    public void onBackPressed() {
        // do nothing.
    }

    @Override
    protected void onPause() {
        super.onPause();

        ActivityManager activityManager = (ActivityManager) getApplicationContext()
                .getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.moveTaskToFront(getTaskId(), 0);
    }


    /****** WEB SERVICE  WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE  ************/
    /****** WEB SERVICE  WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE WEB SERVICE  ************/

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this, "Se registro exitosamente", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "No se puede conectar", Toast.LENGTH_SHORT).show();
    }


    /****** FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE ************/
    /****** FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE  FIN WEB SERVICE ************/


}
