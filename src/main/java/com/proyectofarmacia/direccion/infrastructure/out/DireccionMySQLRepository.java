package com.proyectofarmacia.direccion.infrastructure.out;

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

import com.proyectofarmacia.direccion.domain.entity.Direccion;
import com.proyectofarmacia.direccion.domain.service.DireccionService;

public class DireccionMySQLRepository implements DireccionService{
     private Connection connection;

    public DireccionMySQLRepository() {
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
    public void crearDireccion(Direccion direccion) {
        try{
            String query = "INSERT INTO direccion (calle_principal,interseccion,detalles,nombre,id_ciudad) VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, direccion.getCallePrincipal());
            ps.setString(2, direccion.getInterseccion());
            ps.setString(3, direccion.getDetalle());
            ps.setString(4, direccion.getNombre());
            ps.setInt(5, direccion.getIdCiudad());

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateDireccion(Direccion direccion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBarrio'");
    }

    @Override
    public List<Direccion> findAllDirecciones() {
        List<Direccion> barrios = new ArrayList<>();
        try{
            String query="SELECT id,calle_principal,interseccion,detalles,nombre,id_ciudad "+
            "FROM direccion";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Direccion direccion = new Direccion();
                direccion.setId(rs.getInt("id"));    
                direccion.setCallePrincipal((rs.getString("calle_principal")));    
                direccion.setInterseccion((rs.getString("interseccion")));    
                direccion.setDetalle((rs.getString("detalles")));
                direccion.setNombre((rs.getString("nombre")));    
                direccion.setIdCiudad((rs.getInt("id_ciudad")));  
                
                barrios.add(direccion);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return barrios;
    }

    @Override
    public Optional<Direccion> findDireccionById(int id) {
        try{
            String query = "SELECT id,calle_principal,interseccion,detalles,nombre,id_ciudad "+
            "FROM direccion WHERE direccion.id = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(query);

            if(rs.next()){
            
                Direccion direccion = new Direccion();
                direccion.setId(rs.getInt("id"));    
                direccion.setCallePrincipal((rs.getString("calle_principal")));    
                direccion.setInterseccion((rs.getString("interseccion")));    
                direccion.setDetalle((rs.getString("detalles")));
                direccion.setNombre((rs.getString("nombre")));    
                direccion.setIdCiudad((rs.getInt("id_ciudad")));  
                
                return Optional.of(direccion);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }



}
