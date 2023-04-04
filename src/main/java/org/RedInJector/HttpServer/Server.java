package org.RedInJector.HttpServer;

import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsServer;
import org.RedInJector.HttpServer.Handlers.test;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.security.KeyStore;

public class Server {
    public static void StartHttpServer() {
        try {
            char[] password = "123456789".toCharArray();

            InputStream in = Server.class.getResourceAsStream("/keystore.jks");

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(in, password);

            // Set up the key manager factory
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(keyStore, password);

            // Set up the trust manager factory
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(keyStore);

            // Set up the SSL context
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

            // Create a new HttpsServer on port 8080
            HttpsServer server = HttpsServer.create(new InetSocketAddress(8080), 0);
            server.setHttpsConfigurator(new HttpsConfigurator(sslContext));

            // Set up a context for handling requests
            server.createContext("/", new test());

            // Start the server in a new thread
            server.start();

            // Print a message to indicate that the server has started
            System.out.println("Server started on port 8080");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
