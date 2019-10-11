package com.github.sejoslaw.advancedbow;

import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ObjectHolder;

public class ItemAdvancedBow extends BowItem {
    @ObjectHolder("advancedbow:advancedbow")
    public static ItemAdvancedBow ITEM;

    public ItemAdvancedBow() {
        super(GetAdvancedBowProperties());
        this.setRegistryName(AdvancedBow.MODID);
    }

    @OnlyIn(Dist.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    private static Properties GetAdvancedBowProperties() {
        Properties properties = new Properties()
                .group(AdvancedBowItemGroup.ITEM_GROUP)
                .maxStackSize(1);
        return properties;
    }
}
