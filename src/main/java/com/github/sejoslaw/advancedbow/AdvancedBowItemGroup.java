package com.github.sejoslaw.advancedbow;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class AdvancedBowItemGroup {
    public static ItemGroup ITEM_GROUP = new ItemGroup(AdvancedBow.MODID) {
        public ItemStack createIcon() {
            return new ItemStack(ItemAdvancedBow.ITEM);
        }
    };
}
