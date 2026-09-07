package com.maksymkashevarov.arccraft.command;

import com.maksymkashevarov.arccraft.agent.AgentData;
import com.maksymkashevarov.arccraft.agent.AgentInfo;
import com.maksymkashevarov.arccraft.registry.ArcAttachments;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

public final class ArcCommands {

    private ArcCommands() {
    }

    public static void register(RegisterCommandsEvent event) {
        event.getDispatcher().register(
                Commands.literal("arc")
                        .then(Commands.literal("agent")
                                .executes(context -> showAgent(context.getSource())))
        );
    }

    private static int showAgent(CommandSourceStack source)
            throws CommandSyntaxException {

        ServerPlayer player = source.getPlayerOrException();

        AgentData data = player.getData(
                ArcAttachments.AGENT_DATA.get()
        );

        String result = AgentInfo.getInfo(data);

        source.sendSuccess(
                () -> {
                    return Component.literal(result);
                },
                false
        );

        return 1;
    }
}