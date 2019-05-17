/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sadta;

import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author bangho
 */
public class SADTA {

    public static void main(String[] args) {
        try {
            //conexion PASO 1.
            java.sql.Connection mi_conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sadta2", "root", "");

            //CREAR OBJETO STATEMENT SEGUNDO PASO DEL PROCESO
            java.sql.Statement miStatement = mi_conexion.createStatement();

            //EJECUTAR EL SQL PASO 3, resulset es un objeto en forma de tabla virtual 
            ResultSet mi_resultado = miStatement.executeQuery("SELECT* FROM USUARIO");

            //RECORRER EL RESULSET PASO 4. 
            while (mi_resultado.next()) {// miestras halla un registro
                System.out.println(mi_resultado.getString("Id") + " " + mi_resultado.getString("nombre") + " " + mi_resultado.getString("password") + " " + mi_resultado.getString("correo"));

            }

        } catch (Exception e) {
            System.out.println("NO CONECTA CON LA BASE DE DATOS");
            e.printStackTrace();
        }
    }
}
