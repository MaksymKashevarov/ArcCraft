package com.maksymkashevarov.arccraft;

import com.maksymkashevarov.arccraft.registry.ArcAttachments;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import com.maksymkashevarov.arccraft.command.ArcCommands;
import net.neoforged.neoforge.common.NeoForge;

@Mod(ArcCraft.MODID)
public class ArcCraft {

    public static final String MODID = "arccraft";

    public ArcCraft(IEventBus modEventBus) {
        ArcAttachments.register(modEventBus);
        NeoForge.EVENT_BUS.addListener(ArcCommands::register);
    }
}