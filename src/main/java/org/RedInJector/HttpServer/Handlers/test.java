package org.RedInJector.HttpServer.Handlers;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.RedInJector.BotManagement.Bot;

import java.io.IOException;
import java.io.OutputStream;

public class test implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) {
        // Set the response headers
        Headers headers = exchange.getResponseHeaders();
        headers.set("Content-Type", "text/plain");

        // Set the response status and length

        
        Bot.jda.retrieveUserById("445248333733298178").queue(user ->{
            String response = "Hello, World!  " + user.getAsTag();

            try {
                exchange.sendResponseHeaders(200, response.length());
                // Write the response body
                OutputStream out = exchange.getResponseBody();
                out.write(response.getBytes());
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        
    }
}
