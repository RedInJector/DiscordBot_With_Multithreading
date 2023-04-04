package org.RedInJector.BotManagement;

import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.RedInJector.BotManagement.Commands.Command1Executor;
import org.RedInJector.BotManagement.Commands.Command2Executor;

import java.util.concurrent.ExecutorService;

public class CommandListener extends ListenerAdapter {
    private final ExecutorService executorService;

    public CommandListener(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        event.deferReply().setEphemeral(true).queue();

        switch (event.getName()) {
            case "command1" -> executorService.execute(new Command1Executor(event));
            case "command2" -> executorService.execute(new Command2Executor(event));
        }
    }
}
