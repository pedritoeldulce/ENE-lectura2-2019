package com.example.ksanchez.enapp.modelo;

/**
 * Created by ksanchez on 20/03/2018.
 */

public class SQLConstantes {
    public static final String dbName = "ena.db";
    public static final String tablaRespuestas = "respuestas";

    //COLUMNAS
    public static final String ENA_DNI = "DNI";
    public static final String ENA_NOMBRES = "NOMBRES";
    public static final String ENA_APELLIDOS = "APELLIDOS";
    public static final String ENA_AULA = "AULA";

    public static final String ENA_SEDE = "SEDE";
    public static final String ENA_CARGO = "CARGO";

    public static final String ENA_NOTA = "NOTA";

    public static final String ENA_P1 = "P1";
    public static final String ENA_P2 = "P2";
    public static final String ENA_P3 = "P3";

    public static final String ENA_P4 = "P4";
    public static final String ENA_P5 = "P5";
    public static final String ENA_P6 = "P6";

    public static final String ENA_P07_1 = "P07_1";
    public static final String ENA_P07_2 = "P07_2";
    public static final String ENA_P07_3 = "P07_3";
    public static final String ENA_P07_4 = "P07_4";
    public static final String ENA_P07_5 = "P07_5";

    public static final String ENA_P08_1 = "P08_1";
    public static final String ENA_P08_2 = "P08_2";
    public static final String ENA_P08_3 = "P08_3";
    public static final String ENA_P08_4 = "P08_4";
    public static final String ENA_P08_5 = "P08_5";

    public static final String ENA_P09_1 = "P09_1";
    public static final String ENA_P09_2 = "P09_2";
    public static final String ENA_P09_3 = "P09_3";
    public static final String ENA_P09_4 = "P09_4";


    public static final String SQL_CREATE_TABLA_PREGUNTAS =
            "CREATE TABLE " + tablaRespuestas + "(" +
                    ENA_DNI + " TEXT PRIMARY KEY," +
                    ENA_NOMBRES + " TEXT," +
                    ENA_APELLIDOS + " TEXT," +
                    ENA_AULA + " TEXT," +
                    ENA_SEDE + " TEXT," +
                    ENA_CARGO + " TEXT," +
                    ENA_NOTA + " TEXT," +

                    ENA_P1 + " TEXT," +
                    ENA_P2 + " TEXT," +

                    ENA_P3 + " TEXT," +
                    ENA_P4 + " TEXT," +
                    ENA_P5 + " TEXT," +
                    ENA_P6 + " TEXT," +

                    ENA_P07_1 + " TEXT," +
                    ENA_P07_2 + " TEXT," +
                    ENA_P07_3 + " TEXT," +
                    ENA_P07_4 + " TEXT," +
                    ENA_P07_5 + " TEXT," +

                    ENA_P08_1 + " TEXT," +
                    ENA_P08_2 + " TEXT," +
                    ENA_P08_3 + " TEXT," +
                    ENA_P08_4 + " TEXT," +
                    ENA_P08_5 + " TEXT," +

                    ENA_P09_1 + " TEXT," +
                    ENA_P09_2 + " TEXT," +
                    ENA_P09_3 + " TEXT," +
                    ENA_P09_4 + " TEXT" + ");"


                    //ENA_P12_8 + " TEXT" + ");"
            ;

    public static final String SQL_DELETE_TABLA_PREGUNTAS = "DROP TABLE " + tablaRespuestas;

    public static final String WHERE_CLAUSE_DNI = "DNI=?";


}
