package com.github.sejoslaw.advancedbow;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AdvancedBowItemGroup {
    public static ItemGroup ITEM_GROUP = new ItemGroup(AdvancedBow.MODID) {
        public ItemStack createIcon() {
            return new ItemStack(ItemAdvancedBow.ITEM);
        }

        @OnlyIn(Dist.CLIENT)
        public void fill(NonNullList<ItemStack> items) { // TODO: Add items
            // Normal Advanced Bow
            items.add(new ItemStack(ItemAdvancedBow.ITEM));

            // Bows with skills

            // Bow with all the skills

            // Bow with skills and high values
        }
    };
}
