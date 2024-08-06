package com.proyectofarmacia.cliente.infrastructure.out;

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
import com.proyectofarmacia.cliente.domain.entity.dto.ClienteDTO;
import com.proyectofarmacia.cliente.domain.entity.service.ClienteDTOService;
import com.proyectofarmacia.cliente.domain.entity.service.ClienteService;
import com.proyectofarmacia.direccion.domain.entity.Direccion;
import com.proyectofarmacia.documento.domain.entity.TipoDocumento;

public class ClienteMySQLRepository implements ClienteService, ClienteDTOService{

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
            String query = "INSERT INTO cliente (id,id_tipo_documento,nombre,apellido,edad,fecha_nacimiento,fecha_creacion,id_direccion)"+ //
                            " VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, cliente.getId());
            ps.setInt(2, cliente.getTipoDocumento());
            ps.setString(3, cliente.getNombres());
            ps.setString(4, cliente.getApellidos());
            ps.setInt(5, cliente.getEdad());
            ps.setDate(6, Date.valueOf(cliente.getFechaNacimiento()));
            ps.setDate(7, Date.valueOf(cliente.getFechaRegistro()));
            ps.setInt(8, cliente.getDireccion().getId());

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
        List<Cliente> clientes = new ArrayList<>();;
        try{    
            String query = "SELECT c.id,c.id_tipo_documento,c.nombre,c.apellido,c.edad,c.fecha_nacimiento,c.fecha_creacion,"+
            "d.id AS id_direccion,d.calle_principal,"+
            "d.interseccion,d.detalles,d.nombre,d.id_ciudad FROM cliente c "+
            "JOIN direccion d ON d.id = c.id_direccion";

            PreparedStatement pStatement = connection.prepareStatement(query);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {

                Direccion direccion = new Direccion();
                direccion.setId(rs.getInt("id_direccion"));    
                direccion.setCallePrincipal((rs.getString("calle_principal")));    
                direccion.setInterseccion((rs.getString("interseccion")));    
                direccion.setDetalle((rs.getString("detalles")));
                direccion.setNombre((rs.getString("nombre")));    
                direccion.setIdCiudad((rs.getInt("id_ciudad")));  

                clientes.add( 
                    new Cliente(
                        rs.getLong("id"),
                        rs.getInt("id_tipo_documento"),
                        rs.getString("nombre"),               
                        rs.getString("apellido"),               
                        rs.getInt("edad"),               
                        LocalDate.parse(rs.getString("fecha_nacimiento")),
                        LocalDate.parse(rs.getString("fecha_creacion")),
                        direccion
                    )
                );            
            }

            return clientes;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return clientes;
    }

    @Override
    public List<ClienteDTO> findAllClientesDTO() {

        // llama el cliente original 
        List<ClienteDTO> clienteDTOs = new ArrayList<>();
        try{
            String query = "SELECT c.id,c.id_tipo_documento,c.nombre,c.apellido,c.edad,c.fecha_nacimiento,"+
            "c.fecha_creacion,"+
            "tipo.id AS id_tipo_documento, tipo.nombre AS tipo_nombre, tipo.id_pais AS tipo_id_pais,"+
            "d.id AS id_direccion, d.nombre AS dnombre,d.calle_principal," + 
            "d.interseccion,d.detalles,d.id_ciudad,"+
            "ci.nombre AS cinombre,r.nombre AS rnombre,"+
            "p.nombre AS pnombre " +
            "FROM cliente c "+
            "JOIN tipo_documento tipo ON tipo.id = id_tipo_documento "+
            "JOIN direccion d ON d.id= c.id_direccion "+
            "JOIN ciudad ci ON d.id_ciudad = ci.id "+
            "JOIN region r ON r.id = ci.id_region "+
            "JOIN pais p ON r.id_pais = p.id ";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Direccion direccion = new Direccion();
                direccion.setId(rs.getInt("id_direccion"));    
                direccion.setCallePrincipal((rs.getString("calle_principal")));    
                direccion.setInterseccion((rs.getString("interseccion")));    
                direccion.setDetalle((rs.getString("detalles")));
                direccion.setNombre((rs.getString("dnombre")));    
                direccion.setIdCiudad((rs.getInt("id_ciudad")));  
                
                TipoDocumento tipoDocumento = new TipoDocumento();
                tipoDocumento.setId(rs.getInt("id_tipo_documento"));
                tipoDocumento.setTipoDocumento(rs.getString("tipo_nombre"));
                tipoDocumento.setIdCiudad(rs.getInt("tipo_id_pais"));


                ClienteDTO clienteDto = new ClienteDTO(
                    rs.getLong("id"),
                    tipoDocumento,
                    rs.getString("nombre"),               
                    rs.getString("apellido"),               
                    rs.getInt("edad"),               
                    LocalDate.parse(rs.getString("fecha_nacimiento")),
                    LocalDate.parse(rs.getString("fecha_creacion")),
                    direccion,
                    rs.getString("cinombre"),
                    rs.getString("rnombre"),
                    rs.getString("pnombre")
                );

                clienteDTOs.add(clienteDto);
                
            }

            return clienteDTOs;

        }catch (SQLException e){
            e.printStackTrace();
        }


        return clienteDTOs;
    }

}
