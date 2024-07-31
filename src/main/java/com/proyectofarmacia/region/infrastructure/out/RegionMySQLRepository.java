package com.proyectofarmacia.region.infrastructure.out;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import com.proyectofarmacia.region.domain.entity.Region;
import com.proyectofarmacia.region.domain.service.RegionService;

public class RegionMySQLRepository implements RegionService {
    private String url;
    private String user;
    private String password;


    // constructor
    public RegionMySQLRepository() {
        try{
            Properties properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            
        }catch (IOException e){
            e.printStackTrace();
        }
    
    }

    // metodos

    @Override
    public List<Region> getAllRegion() {
        
        List<Region> regiones = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id,nombre,id_pais FROM region";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                regiones.add(
                    new Region(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("id_pais")
                    )
                );
            }

            return regiones;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return regiones;
    }

    

}
