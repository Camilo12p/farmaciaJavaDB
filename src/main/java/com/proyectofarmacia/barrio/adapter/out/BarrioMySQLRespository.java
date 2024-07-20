package com.proyectofarmacia.barrio.adapter.out;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.proyectofarmacia.barrio.domain.entity.Barrio;
import com.proyectofarmacia.barrio.domain.service.BarrioService;

public class BarrioMySQLRespository implements BarrioService{
     private Connection connection;

    public BarrioMySQLRespository() {
        try{
            Properties properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
            String url= properties.getProperty("url");
            String user= properties.getProperty("user");
            String password= properties.getProperty("password");

            try{
                connection = DriverManager.getConnection(url,user,password);
            }catch(SQLException e){
                e.printStackTrace();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void crearBarrio(Barrio barrio) {
        try{
            String query = "INSERT INTO barrio (calle_principal,interseccion,detalles,nombre,id_ciudad) VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, barrio.getCallePrincipal());
            ps.setString(2, barrio.getInterseccion());
            ps.setString(3, barrio.getDetalle());
            ps.setString(4, barrio.getNombre());
            ps.setInt(5, barrio.getIdCiudad());

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateBarrio(Barrio barrio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBarrio'");
    }

    @Override
    public List<Barrio> findAllBarrio() {
        List<Barrio> barrios = new ArrayList<>();
        try{
            String query="SELECT id,calle_principal,interseccion,detalles,nombre,id_ciudad "+
            "FROM barrio";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Barrio barrio = new Barrio();
                barrio.setId(rs.getInt("id"));    
                barrio.setCallePrincipal((rs.getString("calle_principal")));    
                barrio.setInterseccion((rs.getString("interseccion")));    
                barrio.setDetalle((rs.getString("detalles")));
                barrio.setNombre((rs.getString("nombre")));    
                barrio.setIdCiudad((rs.getInt("id_ciudad")));  
                
                barrios.add(barrio);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return barrios;
    }



}
