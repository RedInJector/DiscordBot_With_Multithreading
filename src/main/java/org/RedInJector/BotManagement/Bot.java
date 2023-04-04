package org.RedInJector.BotManagement;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Bot {
    public static JDA jda;
    private static ExecutorService executor;
    public static void StartBot(String TOKEN) {
        executor = Executors.newSingleThreadExecutor();


        jda = JDABuilder.createDefault(TOKEN)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();

        jda.addEventListener(new CommandListener(executor));

        jda.updateCommands().addCommands(
                Commands.slash("command1", "a"),
                Commands.slash("command2", "a")
        ).queue();

        System.out.println("Bot Started");
    }

    public static void shutdown() {
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            // handle interruption
        }
    }
}
