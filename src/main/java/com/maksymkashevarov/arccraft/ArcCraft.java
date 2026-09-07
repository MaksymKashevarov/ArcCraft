package com.maksymkashevarov.arccraft;

import com.maksymkashevarov.arccraft.registry.ArcAttachments;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(ArcCraft.MODID)
public class ArcCraft {

    public static final String MODID = "arccraft";

    public ArcCraft(IEventBus modEventBus) {
        ArcAttachments.register(modEventBus);
    }
}