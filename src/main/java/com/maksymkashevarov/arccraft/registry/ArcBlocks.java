package com.maksymkashevarov.arccraft.registry;

import com.maksymkashevarov.arccraft.ArcCraft;
import com.maksymkashevarov.arccraft.world.block.ContractCoreBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ArcBlocks {

    private static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ArcCraft.MODID);

    public static final DeferredBlock<ContractCoreBlock> CONTRACT_CORE =
            BLOCKS.register(
                    "contract_core",
                    () -> new ContractCoreBlock(
                            BlockBehaviour.Properties.of()
                                    .strength(3.0f)
                    )
            );

    private ArcBlocks() {
    }

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}