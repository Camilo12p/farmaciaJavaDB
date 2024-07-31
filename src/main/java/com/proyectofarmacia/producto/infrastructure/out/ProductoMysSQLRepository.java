package com.proyectofarmacia.producto.infrastructure.out;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.proyectofarmacia.producto.domain.entity.Producto;
import com.proyectofarmacia.producto.domain.entity.service.ProductoService;

public class ProductoMysSQLRepository  implements ProductoService {
    
    private String url;
    private String user;
    private String password;

    public ProductoMysSQLRepository(){
        try{
            Properties properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));        
            
            url=properties.getProperty("url");
            user=properties.getProperty("user");
            password=properties.getProperty("password");

            
        }catch (IOException e){

        }
    }

    @Override
    public void crearProducto(Producto producto) {
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO producto (nombre, registro_invima, via_de_administracion, pricipio_activo, id_unidad_de_medida, id_laboratorio,id_proveedor, id_presentacion, fecha_caducidad, stock, stock_min, stock_max, valor_venta) "+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getRegistroInvima());
            ps.setString(1, producto.getViaDeAdministracion());
            ps.setString(1, producto.getPricipioActivo());
            ps.setInt(1, producto.getIdUnidadDeMedida());
            ps.setInt(1, producto.getIdLaboratorio());
            ps.setInt(1, producto.getIdProveedor());
            ps.setInt(1, producto.getIdPresentacion());
            ps.setDate(1, Date.valueOf(producto.getFechaCaducidad()));
            ps.setInt(1, producto.getStock());
            ps.setInt(1, producto.getStockMin());
            ps.setInt(1, producto.getStockMax());
            ps.setDouble(1, producto.getValor_venta());

            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


}
