package com.example.ksanchez.enapp.fragments;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.ksanchez.enapp.R;
import com.example.ksanchez.enapp.modelo.Data;
import com.example.ksanchez.enapp.modelo.SQLConstantes;
import com.example.ksanchez.enapp.pojos.Respuesta;


public class eval1_p3 extends Fragment {

    RadioGroup rgP7_1,rgP7_2,rgP7_3,rgP7_4,rgP7_5;
    RadioGroup rgP8_1,rgP8_2,rgP8_3,rgP8_4,rgP8_5;

    Context contexto;
    String dni;

    private String P7_1,P7_2,P7_3,P7_4,P7_5;
    private String P8_1,P8_2,P8_3,P8_4,P8_5;



    public eval1_p3() {
        // Required empty public constructor
    }


    @SuppressLint("ValidFragment")
    public eval1_p3(Context contexto, String dni) {
        this.contexto = contexto;
        this.dni = dni;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_eval1_p3, container, false);

        rgP7_1 = (RadioGroup) rootView.findViewById(R.id.ev1_p7_1_rg1);
        rgP7_2 = (RadioGroup) rootView.findViewById(R.id.ev1_p7_2_rg1);
        rgP7_3 = (RadioGroup) rootView.findViewById(R.id.ev1_p7_3_rg1);
        rgP7_4 = (RadioGroup) rootView.findViewById(R.id.ev1_p7_4_rg1);
        rgP7_5 = (RadioGroup) rootView.findViewById(R.id.ev1_p7_5_rg1);

        rgP8_1 = (RadioGroup) rootView.findViewById(R.id.ev1_p8_1_rg1);
        rgP8_2 = (RadioGroup) rootView.findViewById(R.id.ev1_p8_2_rg1);
        rgP8_3 = (RadioGroup) rootView.findViewById(R.id.ev1_p8_3_rg1);
        rgP8_4 = (RadioGroup) rootView.findViewById(R.id.ev1_p8_4_rg1);
        rgP8_5 = (RadioGroup) rootView.findViewById(R.id.ev1_p8_5_rg1);




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
            if (!respuesta.getP07_1().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP07_1());
                ((RadioButton) rgP7_1.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP07_2().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP07_2());
                ((RadioButton) rgP7_2.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP07_3().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP07_3());
                ((RadioButton) rgP7_3.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP07_4().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP07_4());
                ((RadioButton) rgP7_4.getChildAt(childPos)).setChecked(true);
            }

            if (!respuesta.getP07_5().equals("")) {
                int childPos = Integer.parseInt(respuesta.getP07_5());
                ((RadioButton) rgP7_5.getChildAt(childPos)).setChecked(true);
            }
                if (!respuesta.getP08_1().equals("")) {
                    int chilldPos = Integer.parseInt(respuesta.getP08_1());
                    ((RadioButton) rgP8_1.getChildAt(chilldPos)).setChecked(true);
                }

                if (!respuesta.getP08_2().equals("")) {
                    int chilldPos = Integer.parseInt(respuesta.getP08_2());
                    ((RadioButton) rgP7_2.getChildAt(chilldPos)).setChecked(true);
                }

                if (!respuesta.getP08_3().equals("")) {
                    int chilldPos = Integer.parseInt(respuesta.getP08_3());
                    ((RadioButton) rgP7_3.getChildAt(chilldPos)).setChecked(true);
                }

                if (!respuesta.getP08_4().equals("")) {
                    int chilldPos = Integer.parseInt(respuesta.getP08_4());
                    ((RadioButton) rgP7_4.getChildAt(chilldPos)).setChecked(true);
                }

                if (!respuesta.getP08_5().equals("")) {
                    int chilldPos = Integer.parseInt(respuesta.getP08_5());
                    ((RadioButton) rgP7_5.getChildAt(chilldPos)).setChecked(true);
            }
        }
    }


    public boolean validarFragment(){
        boolean correcto = true;
        return correcto;
    }

    public void guardarFragment(){
        ContentValues contentValues =  new ContentValues();

        if(rgP7_1.indexOfChild(rgP7_1.findViewById(rgP7_1.getCheckedRadioButtonId())) >= 0){
            P7_1 = rgP7_1.indexOfChild(rgP7_1.findViewById(rgP7_1.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P07_1, P7_1);
        }

        if(rgP7_2.indexOfChild(rgP7_2.findViewById(rgP7_2.getCheckedRadioButtonId())) >= 0){
            P7_2 = rgP7_2.indexOfChild(rgP7_2.findViewById(rgP7_2.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P07_2, P7_2);
        }

        if(rgP7_3.indexOfChild(rgP7_3.findViewById(rgP7_3.getCheckedRadioButtonId())) >= 0){
            P7_3 = rgP7_3.indexOfChild(rgP7_3.findViewById(rgP7_3.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P07_3, P7_3);
        }

        if(rgP7_4.indexOfChild(rgP7_4.findViewById(rgP7_4.getCheckedRadioButtonId())) >= 0){
            P7_4 = rgP7_4.indexOfChild(rgP7_4.findViewById(rgP7_4.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P07_4, P7_4);
        }

        if(rgP7_5.indexOfChild(rgP7_5.findViewById(rgP7_5.getCheckedRadioButtonId())) >= 0){
            P7_5 = rgP7_5.indexOfChild(rgP7_5.findViewById(rgP7_5.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P07_5, P7_5);
        }



        if(rgP8_1.indexOfChild(rgP8_1.findViewById(rgP8_1.getCheckedRadioButtonId())) >= 0){
            P8_1 = rgP8_1.indexOfChild(rgP8_1.findViewById(rgP8_1.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P08_1, P8_1);
        }

        if(rgP8_2.indexOfChild(rgP8_2.findViewById(rgP8_2.getCheckedRadioButtonId())) >= 0){
            P8_2 = rgP8_2.indexOfChild(rgP8_2.findViewById(rgP8_2.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P08_2, P8_2);
        }

        if(rgP8_3.indexOfChild(rgP8_3.findViewById(rgP8_3.getCheckedRadioButtonId())) >= 0){
            P8_3 = rgP8_3.indexOfChild(rgP8_3.findViewById(rgP8_3.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P08_3, P8_3);
        }

        if(rgP8_4.indexOfChild(rgP8_4.findViewById(rgP8_4.getCheckedRadioButtonId())) >= 0){
            P8_4 = rgP8_4.indexOfChild(rgP8_4.findViewById(rgP8_4.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P08_4, P8_4);
        }

        if(rgP8_5.indexOfChild(rgP8_5.findViewById(rgP8_5.getCheckedRadioButtonId())) >= 0){
            P8_5 = rgP8_5.indexOfChild(rgP8_5.findViewById(rgP8_5.getCheckedRadioButtonId())) + "";
            contentValues.put(SQLConstantes.ENA_P08_5, P8_5);
        }

        if(contentValues.size() > 0){
            Data data =  new Data(contexto);
            data.open();
            data.actualizarRespuestas(dni,contentValues);
            data.close();
        }
    }
}
