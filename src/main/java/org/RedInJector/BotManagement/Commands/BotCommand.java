package org.RedInJector.BotManagement.Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public abstract class BotCommand implements Runnable{

    SlashCommandInteractionEvent event;
    @Override
    public void run(){
        ExecuteCommand(event);
    }

    abstract void ExecuteCommand(SlashCommandInteractionEvent event);
}
