package com.example.ksanchez.enapp.pojos;

import android.content.ContentValues;

import com.example.ksanchez.enapp.modelo.SQLConstantes;

/**
 * Created by ksanchez on 20/03/2018.
 */

public class Respuesta {
    private String DNI;
    private String NOMBRES;
    private String APELLIDOS;
    private String AULA;

    private String SEDE;
    private String CARGO;

    private String NOTA;

    private String P1;
    private String P2;
    private String P3;

    private String P4;
    private String P5;
    private String P6;

    private String P07_1;
    private String P07_2;
    private String P07_3;
    private String P07_4;
    private String P07_5;

    private String P08_1;
    private String P08_2;
    private String P08_3;
    private String P08_4;
    private String P08_5;

    private String P09_1;
    private String P09_2;
    private String P09_3;
    private String P09_4;


    public Respuesta() {
        this.DNI = "";
        this.NOMBRES = "";
        this.APELLIDOS = "";
        this.AULA = "";
        this.SEDE = "";
        this.CARGO = "";
        this.NOTA = "";

        P1 = "";
        P2 = "";
        P3 = "";

        P4 = "";
        P5 = "";
        P6 = "";

        P07_1 = "";
        P07_2 = "";
        P07_3 = "";
        P07_4 = "";
        P07_5 = "";

        P08_1 = "";
        P08_2 = "";
        P08_3 = "";
        P08_4 = "";
        P08_5 = "";

        P09_1 = "";
        P09_2 = "";
        P09_3 = "";
        P09_4 = "";


    }

    public Respuesta(String DNI, String NOMBRES, String APELLIDOS, String AULA, String SEDE, String CARGO, String NOTA, String p1, String p2, String p3, String p4, String p5, String p6,String p07_1, String p07_2, String p07_3, String p07_4, String p07_5,String p08_1, String p08_2, String p08_3, String p08_4, String p08_5,String p09_1, String p09_2, String p09_3, String p09_4) {
        this.DNI = DNI;
        this.NOMBRES = NOMBRES;
        this.APELLIDOS = APELLIDOS;
        this.AULA = AULA;
        this.SEDE = SEDE;
        this.CARGO = CARGO;
        this.NOTA = NOTA;

        P1 = p1;
        P2 = p2;
        P3 = p3;

        P4 = p4;
        P5 = p5;
        P6 = p6;

        P07_1 = p07_1;
        P07_2 = p07_2;
        P07_3 = p07_3;
        P07_4 = p07_4;
        P07_5 = p07_5;

        P08_1 = p08_1;
        P08_2 = p08_2;
        P08_3 = p08_3;
        P08_4 = p08_4;
        P08_5 = p08_5;

        P09_1 = p09_1;
        P09_2 = p09_2;
        P09_3 = p09_3;
        P09_4 = p09_4;


    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNOMBRES() {
        return NOMBRES;
    }

    public void setNOMBRES(String NOMBRES) {
        this.NOMBRES = NOMBRES;
    }

    public String getAPELLIDOS() {
        return APELLIDOS;
    }

    public void setAPELLIDOS(String APELLIDOS) {
        this.APELLIDOS = APELLIDOS;
    }

    public String getAULA() {
        return AULA;
    }

    public void setAULA(String AULA) {
        this.AULA = AULA;
    }

    public String getSEDE() {
        return SEDE;
    }

    public void setSEDE(String SEDE) {
        this.SEDE = SEDE;
    }

    public String getCARGO() {
        return CARGO;
    }

    public void setCARGO(String CARGO) {
        this.CARGO = CARGO;
    }

    public String getNOTA() {
        return NOTA;
    }

    public void setNOTA(String NOTA) {
        this.NOTA = NOTA;
    }

    public String getP1() {
        return P1;
    }
    public void setP1(String p1) {
        P1 = p1;
    }

    public String getP2() {
        return P2;
    }
    public void setP2(String p2) {
        P2 = p2;
    }

    public String getP3() {
        return P3;
    }
    public void setP3(String p3) {
        P3 = p3;
    }

    public String getP4() {
        return P4;
    }
    public void setP4(String p4) {
        P4 = p4;
    }

    public String getP5() {
        return P5;
    }
    public void setP5(String p5) {
        P5 = p5;
    }

    public String getP6() {
        return P6;
    }
    public void setP6(String p6) {
        P6 = p6;
    }


    public String getP07_1() {
        return P07_1;
    }
    public void setP07_1(String p07_1) {
        P07_1 = p07_1;
    }

    public String getP07_2() {
        return P07_2;
    }
    public void setP07_2(String p07_2) {
        P07_2 = p07_2;
    }

    public String getP07_3() {
        return P07_3;
    }
    public void setP07_3(String p07_3) {
        P07_3 = p07_3;
    }

    public String getP07_4() {
        return P07_4;
    }
    public void setP07_4(String p07_4) {
        P07_4 = p07_4;
    }

    public String getP07_5() {
        return P07_5;
    }
    public void setP07_5(String p07_5) {
        P07_5 = p07_5;
    }


    public String getP08_1() {
        return P08_1;
    }
    public void setP08_1(String p08_1) {
        P08_1 = p08_1;
    }

    public String getP08_2() {
        return P08_2;
    }
    public void setP08_2(String p08_2) {
        P08_2 = p08_2;
    }

    public String getP08_3() {
        return P08_3;
    }
    public void setP08_3(String p08_3) {
        P08_3 = p08_3;
    }

    public String getP08_4() {
        return P08_4;
    }
    public void setP08_4(String p08_4) {
        P08_4 = p08_4;
    }

    public String getP08_5() {
        return P08_5;
    }
    public void setP08_5(String p08_5) {
        P08_5 = p08_5;
    }


    public String getP09_1() {
        return P09_1;
    }
    public void setP09_1(String p09_1) {
        P09_1 = p09_1;
    }

    public String getP09_2() {
        return P09_2;
    }
    public void setP09_2(String p09_2) {
        P09_2 = p09_2;
    }

    public String getP09_3() {
        return P09_3;
    }
    public void setP09_3(String p09_3) {
        P09_3 = p09_3;
    }

    public String getP09_4() {
        return P09_4;
    }
    public void setP09_4(String p09_4) {
        P09_4 = p09_4;
    }




    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.ENA_DNI,DNI);
        contentValues.put(SQLConstantes.ENA_NOMBRES,NOMBRES);
        contentValues.put(SQLConstantes.ENA_APELLIDOS,APELLIDOS);
        contentValues.put(SQLConstantes.ENA_AULA,AULA);

        contentValues.put(SQLConstantes.ENA_SEDE,SEDE);
        contentValues.put(SQLConstantes.ENA_CARGO,CARGO);
        contentValues.put(SQLConstantes.ENA_NOTA,NOTA);

        contentValues.put(SQLConstantes.ENA_P1,P1);
        contentValues.put(SQLConstantes.ENA_P2,P2);
        contentValues.put(SQLConstantes.ENA_P3,P3);

        contentValues.put(SQLConstantes.ENA_P4,P4);
        contentValues.put(SQLConstantes.ENA_P5,P5);
        contentValues.put(SQLConstantes.ENA_P6,P6);

        contentValues.put(SQLConstantes.ENA_P07_1,P07_1);
        contentValues.put(SQLConstantes.ENA_P07_2,P07_2);
        contentValues.put(SQLConstantes.ENA_P07_3,P07_3);
        contentValues.put(SQLConstantes.ENA_P07_4,P07_4);
        contentValues.put(SQLConstantes.ENA_P07_5,P07_5);

        contentValues.put(SQLConstantes.ENA_P08_1,P08_1);
        contentValues.put(SQLConstantes.ENA_P08_2,P08_2);
        contentValues.put(SQLConstantes.ENA_P08_3,P08_3);
        contentValues.put(SQLConstantes.ENA_P08_4,P08_4);
        contentValues.put(SQLConstantes.ENA_P08_5,P08_5);

        contentValues.put(SQLConstantes.ENA_P09_1,P09_1);
        contentValues.put(SQLConstantes.ENA_P09_2,P09_2);
        contentValues.put(SQLConstantes.ENA_P09_3,P09_3);
        contentValues.put(SQLConstantes.ENA_P09_4,P09_4);


        return contentValues;
    }
}
