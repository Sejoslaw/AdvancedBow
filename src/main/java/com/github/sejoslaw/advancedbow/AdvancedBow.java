package com.github.sejoslaw.advancedbow;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(AdvancedBow.MODID)
public class AdvancedBow {
    public static final String MODID = "advancedbow";

    public AdvancedBow() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new ItemAdvancedBow());

            GameRegistry.findRegistry(EntityType.class).register(EntityType.Builder.create(EntityAdvancedArrow::new, EntityClassification.MISC).size(0.5F, 0.5F).build("advancedarrow"));
        }
    }
}