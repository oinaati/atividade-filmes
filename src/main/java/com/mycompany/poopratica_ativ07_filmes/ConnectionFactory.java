/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poopratica_ativ07_filmes;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Natalia Reis
 *                  RA: 820142521
 */
public class ConnectionFactory {
    private final String usuario = "root";
    private final String senha = "1234";
    private final String host = "localhost";
    private final String porta = "3306";
    private final String db = "usjt_db_filmes";
    
        public Connection obterConexao() {
        try {
            //jdbc:mysql://localhost:3306/usjt_db_pessoas    
            Connection c = DriverManager.getConnection(
                     "jdbc:mysql://" + host + ":" + porta + "/" + db + "?useTimezone=true&serverTimezone=UTC",
                usuario,
                senha
            );
            return c;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
