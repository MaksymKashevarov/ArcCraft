package com.maksymkashevarov.arccraft.command;

import com.maksymkashevarov.arccraft.agent.AgentData;
import com.maksymkashevarov.arccraft.agent.AgentInfo;
import com.maksymkashevarov.arccraft.registry.ArcAttachments;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import com.mojang.brigadier.arguments.BoolArgumentType;

public final class ArcCommands {

    private ArcCommands() {
    }

    public static void register(RegisterCommandsEvent event) {
        event.getDispatcher().register(
                Commands.literal("arc")
                        .then(registerAgent())
                        .then(registerAuth())
        );
    }

    private static LiteralArgumentBuilder<CommandSourceStack> registerAgent() {
        return Commands.literal("agent")
                .executes(context -> showAgent(context.getSource()));
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

private static LiteralArgumentBuilder<CommandSourceStack> registerAuth() {
    return Commands.literal("auth")
            .requires(source -> source.hasPermission(2))
            .then(Commands.argument("authorized", BoolArgumentType.bool())
                    .executes(context -> executeAuth(
                            context.getSource(),
                            BoolArgumentType.getBool(context, "authorized")
                    )));
}

    private static int executeAuth(CommandSourceStack source, boolean authorized)
            throws CommandSyntaxException {

        ServerPlayer player = source.getPlayerOrException();

        AgentData data = player.getData(
                ArcAttachments.AGENT_DATA.get()
        );

        data.setAuthorized(authorized);

        player.setData(ArcAttachments.AGENT_DATA.get(), data);

        source.sendSuccess(
                () -> Component.literal("Authorized: " + data.isAuthorized()),
                false
        );

        return 1;
    }
}