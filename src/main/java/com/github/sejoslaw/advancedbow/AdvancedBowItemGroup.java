package com.github.sejoslaw.advancedbow;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.StringTextComponent;
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

            // Maxed Advanced Bow
            ItemStack bowWithSkills = new ItemStack(ItemAdvancedBow.ITEM);
            bowWithSkills.setDisplayName(new StringTextComponent("Maxed Advanced Bow"));

            CompoundNBT tag = bowWithSkills.getOrCreateTag();
            ItemAdvancedBow.setMaxStats(tag);

            items.add(bowWithSkills);
        }
    };
}
