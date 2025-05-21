// ModToolParts.java
package com.slurmpy.thermaltinkersmod.registry;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.library.materials.stats.MaterialStatsId;
import slimeknights.tconstruct.library.tools.part.ToolPartItem;
import com.slurmpy.thermaltinkersmod.ThermalTinkersMod;

public class ModToolParts {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ThermalTinkersMod.MODID);

    public static final RegistryObject<ToolPartItem> CANTEEN_BODY = ITEMS.register("canteen_body",
            () -> new ToolPartItem(new Item.Properties(), new MaterialStatsId("head")));

    public static final RegistryObject<ToolPartItem> CANTEEN_CAP = ITEMS.register("canteen_cap",
            () -> new ToolPartItem(new Item.Properties(), new MaterialStatsId("binding")));
}
