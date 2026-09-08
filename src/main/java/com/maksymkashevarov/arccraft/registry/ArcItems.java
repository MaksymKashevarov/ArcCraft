package com.maksymkashevarov.arccraft.registry;

import com.maksymkashevarov.arccraft.ArcCraft;
import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class ArcItems {

    private static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(ArcCraft.MODID);

    public static final Supplier<BlockItem> CONTRACT_CORE =
            ITEMS.registerSimpleBlockItem(
                    "contract_core",
                    ArcBlocks.CONTRACT_CORE
            );

    private ArcItems() {
    }

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}