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
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ksanchez.enapp.R;
import com.example.ksanchez.enapp.modelo.Data;
import com.example.ksanchez.enapp.modelo.SQLConstantes;
import com.example.ksanchez.enapp.pojos.Respuesta;

/**
 * A simple {@link Fragment} subclass.
 */
public class eval1_p4 extends Fragment {


    Spinner spP09sp1;
    Spinner spP09sp2;
    Spinner spP09sp3;
    Spinner spP09sp4;

    private String P09_1 = "";
    private String P09_2= "";
    private String P09_3= "";
    private String P09_4= "";

    Context contexto;
    String dni;


    public eval1_p4() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public eval1_p4(Context contexto, String dni) {
        this.contexto = contexto;
        this.dni = dni;
        Log.d("TAG","en el public eval1_4");
    }

    @SuppressLint("ValidFragment")


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_eval1_p4, container, false);
        Log.d("TAG","en el public View onCreateView");
        spP09sp1 = (Spinner) rootView.findViewById(R.id.eval1_p09_sp1);
        spP09sp2 = (Spinner) rootView.findViewById(R.id.eval1_p09_sp2);
        spP09sp3 = (Spinner) rootView.findViewById(R.id.eval1_p09_sp3);
        spP09sp4 = (Spinner) rootView.findViewById(R.id.eval1_p09_sp4);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState); Log.d("TAG","en el void onViewCreated @Nullable, justo antes de llamar a la funcion cargarDatos()");
       cargarDatos();
    }


    public void cargarDatos(){
        Data data = new Data(contexto);
        data.open();
        Respuesta respuesta = data.getRespuesta(dni);
        Log.d("TAG","en el void cargarDatos inicio fragment_eval1_p3: "+respuesta);


        if(!respuesta.getP09_1().equals("")){
            spP09sp1.setSelection(Integer.parseInt(respuesta.getP09_1()));
        }
        if(!respuesta.getP09_2().equals("")){
            spP09sp2.setSelection(Integer.parseInt(respuesta.getP09_2()));
        }
        if(!respuesta.getP09_3().equals("")){
            spP09sp3.setSelection(Integer.parseInt(respuesta.getP09_3()));
        }
        if(!respuesta.getP09_4().equals("")){
            spP09sp4.setSelection(Integer.parseInt(respuesta.getP09_4()));
        }
        Log.d("TAG","en el void cargarDatos final fragment_eval1_p3  acabando de leer: "+respuesta);
        data.close();


    }

    public boolean validarFragment(){
        boolean correcto = true;

        if ( spP09sp1.getSelectedItemPosition()==spP09sp2.getSelectedItemPosition()
                || spP09sp1.getSelectedItemPosition() ==spP09sp3.getSelectedItemPosition() || spP09sp1.getSelectedItemPosition()==spP09sp4.getSelectedItemPosition()
                || spP09sp2.getSelectedItemPosition()==spP09sp3.getSelectedItemPosition() || spP09sp2.getSelectedItemPosition()==spP09sp4.getSelectedItemPosition()
                || spP09sp3.getSelectedItemPosition()==spP09sp4.getSelectedItemPosition()
            )
        {
            correcto=false;
            Toast.makeText(getActivity(),"Las respuestas no deben coincidir",Toast.LENGTH_SHORT).show();
        }
        Log.d("TAG","en el validar Fragment correcto: "+correcto);
        return correcto;
    }
    


    public void guardarFragment(){
        ContentValues contentValues = new ContentValues();

        Log.d("TAG","en el guardar Fragment...");
        P09_1 = spP09sp1.getSelectedItemPosition() + "";
        contentValues.put(SQLConstantes.ENA_P09_1, P09_1);
        P09_2 = spP09sp2.getSelectedItemPosition() + "";
        contentValues.put(SQLConstantes.ENA_P09_2, P09_2);
        P09_3 = spP09sp3.getSelectedItemPosition() + "";
        contentValues.put(SQLConstantes.ENA_P09_3, P09_3);
        P09_4 = spP09sp4.getSelectedItemPosition() + "";
        contentValues.put(SQLConstantes.ENA_P09_4, P09_4);


        if(contentValues.size() > 0){
            Data data =  new Data(contexto);
            data.open();
            data.actualizarRespuestas(dni,contentValues);
            data.close();
        }
    }
}
