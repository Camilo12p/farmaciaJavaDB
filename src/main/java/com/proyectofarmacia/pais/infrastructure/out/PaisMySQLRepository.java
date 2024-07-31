package com.proyectofarmacia.pais.infrastructure.out;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.proyectofarmacia.pais.domain.entity.Pais;
import com.proyectofarmacia.pais.domain.service.PaisService;

public class PaisMySQLRepository implements PaisService{

    // Attributes
    private String url;
    private String user;
    private String password;

    // constructors
    public PaisMySQLRepository (){
        Properties properties = new Properties();
        try{
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
    public Optional<Pais> getPaisById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPaisById'");
    }

    @Override
    public List<Pais> getAllPais() {


        List<Pais> paises = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id,nombre FROM pais";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                paises.add(
                    new Pais(
                         rs.getInt("id"), 
                         rs.getString("nombre")
                    )
                );
            }

            return paises;

            
        }catch (SQLException e){
            e.printStackTrace();
        }


        return paises;
    }

        


}
