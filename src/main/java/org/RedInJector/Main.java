package org.RedInJector;

import org.RedInJector.BotManagement.Bot;
import org.RedInJector.ConfigManager.Config;
import org.RedInJector.HttpServer.Server;

public class Main {
    public static void main(String[] args) {
        Config.loadConfig();

        Bot.StartBot();

        Server.StartHttpServer();

        Runtime.getRuntime().addShutdownHook(new Thread(Bot::shutdown));
    }
}