/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.zipcode.config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Draxl
 */
public class Conexion {
    public DriverManagerDataSource Conectar(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        /// DEV ///
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/zip-code");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        
        /// PRD///
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/zip-code");
//        dataSource.setUsername("root");
//        dataSource.setPassword("");
//        
        
        return dataSource;
    }
}
