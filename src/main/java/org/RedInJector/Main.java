package org.RedInJector;

import org.RedInJector.BotManagement.Bot;
import org.RedInJector.ConfigManager.Config;
import org.RedInJector.HttpServer.Server;

public class Main {
    public static void main(String[] args) {
        Config.loadConfig();

        if(args == null) {
            System.out.println("Error. No bot Token argument Provided!!!!!!!");
            return;
        }

        Bot.StartBot(args[0]);

        Server.StartHttpServer();

        Runtime.getRuntime().addShutdownHook(new Thread(Bot::shutdown));
    }
}