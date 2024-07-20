package com.proyectofarmacia.cliente.adapter.out;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.proyectofarmacia.cliente.domain.entity.Cliente;
import com.proyectofarmacia.cliente.domain.entity.service.ClienteService;

public class ClienteMySQLRepository implements ClienteService{

    private Connection connection;



    public ClienteMySQLRepository() {
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
    public void crearCliente(Cliente cliente) {
        try{
            String query = "INSERT INTO cliente (id,id_tipo_documento,nombre,apellido,edad,fecha_nacimiento,fecha_creacion,id_barrio)"+ //
                            " VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, cliente.getId());
            ps.setInt(2, cliente.getTipoDocumento());
            ps.setString(3, cliente.getNombres());
            ps.setString(4, cliente.getApellidos());
            ps.setInt(5, cliente.getEdad());
            ps.setDate(6, Date.valueOf(cliente.getFechaNacimiento()));
            ps.setDate(7, Date.valueOf(cliente.getFechaRegistro()));
            ps.setInt(8, cliente.getIdBarrio());

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCliente'");
    }

    @Override
    public Optional<Cliente> findClienteById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findClienteById'");
    }

    @Override
    public List<Cliente> findAllCliente() {
        String query = "SELECT id,nombre,appellido,edad,fecha_nacimiento,fecha_creacion,"+
        "id_barrio FROM cliente";
        List<Cliente> clientes = new ArrayList<>();;
        try{    
            PreparedStatement pStatement = connection.prepareStatement(query);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                clientes.add( 
                    new Cliente(
                        rs.getLong("id"),
                        rs.getInt("id_tipo_documento"),
                        rs.getString("nombre"),               
                        rs.getString("apellido"),               
                        rs.getInt("edad"),               
                        LocalDate.parse(rs.getString("fecha_nacimiento")),               
                        LocalDate.parse(rs.getString("fecha_creacion")),
                        rs.getInt("id_barrio")               
                    )
                
                );            
            }

            return clientes;

        }catch(SQLException e){

        }

        return clientes;
    }

}
