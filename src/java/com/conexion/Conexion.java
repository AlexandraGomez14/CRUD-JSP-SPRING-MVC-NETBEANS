package com.conexion;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Gabriela Alexandra Gomez
 */
public class Conexion {
    
    public DriverManagerDataSource conetar(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();    
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/registro");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        System.out.println("conexion exitosa");
        return dataSource;
    }
    
}
