package com.proyectofarmacia.serverconfig;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Config {

    public static void startServer() {
        
        // Configuración del ResourceConfig
        ResourceConfig config = new ResourceConfig()
                .packages("com.proyectofarmacia")
                .register(JacksonFeature.class); // Registrar JacksonFeature

        // URI del servidor
        URI uri = URI.create("http://localhost:8080/myapp");

        // Crear e iniciar el servidor
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);

        // Agregar un shutdown hook para apagar el servidor ordenadamente
        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));

        try {
            // Iniciar el servidor
            server.start();
            System.out.println("Server started at " + uri);

            // Mantener el servidor en ejecución
            System.in.read(); // Espera hasta que se presione Enter

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Apagar el servidor
            server.shutdownNow();
        }
    }
}

