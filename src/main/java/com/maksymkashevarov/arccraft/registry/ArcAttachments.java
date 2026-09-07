package com.maksymkashevarov.arccraft.registry;

import com.maksymkashevarov.arccraft.ArcCraft;
import com.maksymkashevarov.arccraft.agent.AgentData;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public final class ArcAttachments {

    private static final DeferredRegister<AttachmentType<?>> ATTACHMENTS =
            DeferredRegister.create(
                    NeoForgeRegistries.ATTACHMENT_TYPES,
                    ArcCraft.MODID
            );

    public static final Supplier<AttachmentType<AgentData>> AGENT_DATA =
            ATTACHMENTS.register(
                    "agent_data",
                    () -> AttachmentType.builder(AgentData::new).build()
            );

    private ArcAttachments() {
    }

    public static void register(IEventBus modEventBus) {
        ATTACHMENTS.register(modEventBus);
    }
}