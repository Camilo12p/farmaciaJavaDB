package com.proyectofarmacia.ciudad.infrastructure.in;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import com.proyectofarmacia.ciudad.domain.entity.Ciudad;
import com.proyectofarmacia.ciudad.domain.service.CiudadService;

public class CiudadMySQLRespository implements CiudadService {
    private String url;
    private String user;
    private String password;

    public CiudadMySQLRespository(){
        try{
            Properties properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        }catch (IOException e){

        }
    }

    @Override
    public List<Ciudad> getAllCiudad() {
        List<Ciudad> ciudades = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, user, password)){
        
            String query = "SELECT id,nombre,id_region FROM ciudad";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ciudades.add(
                    new Ciudad(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("id_region")
                    )
                );
            }

            return ciudades;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return ciudades;
    }



}
