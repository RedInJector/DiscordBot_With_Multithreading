package org.RedInJector.BotManagement.Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.jetbrains.annotations.NotNull;

public class Command1Executor extends BotCommand{


    public Command1Executor(SlashCommandInteractionEvent event) {
        this.event = event;
    }
    @Override
    void ExecuteCommand(@NotNull SlashCommandInteractionEvent event) {
        event.getHook().sendMessage("Reply 1").queue();
    }
}
