package org.RedInJector.BotManagement.Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Command2Executor extends BotCommand{

    public Command2Executor(SlashCommandInteractionEvent event) {
        this.event = event;

    }

    @Override
    void ExecuteCommand(SlashCommandInteractionEvent event) {
        event.getHook().sendMessage("Reply 2").queue();
    }
}
