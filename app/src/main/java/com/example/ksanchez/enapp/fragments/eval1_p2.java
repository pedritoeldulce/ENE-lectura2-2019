package com.example.ksanchez.enapp.fragments;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ksanchez.enapp.BaseDatosTemporal;
import com.example.ksanchez.enapp.R;
import com.example.ksanchez.enapp.activities.UsuarioActivity;
import com.example.ksanchez.enapp.modelo.Data;
import com.example.ksanchez.enapp.modelo.SQLConstantes;
import com.example.ksanchez.enapp.pojos.Respuesta;



/**
 * A simple {@link Fragment} subclass.
 */
public class eval1_p2 extends Fragment {

    RadioGroup rgP4;
    RadioGroup rgP5;
    RadioGroup rgP6;

    Context contexto;
    String dni;

    private String P4;
    private String P5;
    private String P6;



    public eval1_p2() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public eval1_p2(Context contexto, String dni) {
        this.contexto = contexto;
        this.dni = dni;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_eval1_p2, container, false);
        rgP4 = (RadioGroup) rootView.findViewById(R.id.ev1_p4_rg1);
        rgP5 = (RadioGroup) rootView.findViewById(R.id.ev1_p5_rg1);
        rgP6 = (RadioGroup) rootView.findViewById(R.id.ev1_p6_rg1);


        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cargarDatos();
    }

    public void cargarDatos(){
        Data data =  new Data(contexto);
        data.open();
        Respuesta respuesta =  data.getRespuesta(dni);
        data.close();


        if(respuesta != null){

            if (!respuesta.getP4().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP4());
                ((RadioButton) rgP4.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP5().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP5());
                ((RadioButton) rgP5.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP6().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP6());
                ((RadioButton) rgP6.getChildAt(childPos)).setChecked(true);
            }


        }

    }


    public boolean validarFragment(){
        boolean correcto = true;

        return correcto;
    }
    public void guardarFragment(){
        ContentValues contentValues =  new ContentValues();

        if(rgP4.indexOfChild(rgP4.findViewById(rgP4.getCheckedRadioButtonId())) >= 0){
            P4 = rgP4.indexOfChild(rgP4.findViewById(rgP4.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P4, P4);
            Log.d("TAG","P4 = "+P4);
        }

        if(rgP5.indexOfChild(rgP5.findViewById(rgP5.getCheckedRadioButtonId())) >= 0){
            P5 = rgP5.indexOfChild(rgP5.findViewById(rgP5.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P5, P5);
            Log.d("TAG","P5 = "+P5);
        }

        if(rgP6.indexOfChild(rgP6.findViewById(rgP6.getCheckedRadioButtonId())) >= 0){
            P6 = rgP6.indexOfChild(rgP6.findViewById(rgP6.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P6, P6);
            Log.d("TAG","P6 = "+P6);
        }


        if(contentValues.size() > 0){
            Data data =  new Data(contexto);
            data.open();
            data.actualizarRespuestas(dni,contentValues);
            data.close();
        }


    }
}
