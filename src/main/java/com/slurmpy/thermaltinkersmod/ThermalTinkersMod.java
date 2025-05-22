package com.slurmpy.thermaltinkersmod;

import com.mojang.logging.LogUtils;
import com.slurmpy.thermaltinkersmod.compat.ToughAsNailsCompat;
import com.slurmpy.thermaltinkersmod.registry.ModCreativeTabs;
import com.slurmpy.thermaltinkersmod.registry.ModItems;
import com.slurmpy.thermaltinkersmod.registry.ModModifiers;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

@Mod(ThermalTinkersMod.MODID)
public class ThermalTinkersMod {
    public static final String MODID = "thermaltinkersmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ThermalTinkersMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register content
        ModItems.register(modEventBus);
        ModModifiers.register(modEventBus);
        ModCreativeTabs.register(modEventBus);

        // Register Forge events
        MinecraftForge.EVENT_BUS.register(this);

        // Setup logic
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Common setup starting...");

        event.enqueueWork(() -> {
            if (ModList.get().isLoaded("toughasnails") && !FMLEnvironment.dist.isDedicatedServer()) {
                ToughAsNailsCompat.register();
            }
        });

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT);

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Server is starting...");
    }

    public static ResourceLocation modResource(String path) {
        return new ResourceLocation(MODID, path);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("Client setup running...");
            LOGGER.info("Current user: {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
