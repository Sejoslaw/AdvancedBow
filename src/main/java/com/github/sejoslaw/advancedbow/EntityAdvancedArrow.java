package com.github.sejoslaw.advancedbow;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityAdvancedArrow extends ArrowEntity {
    private ItemStack playerArrowsStack;

    public EntityAdvancedArrow(EntityType<? extends EntityAdvancedArrow> entityType, World world) {
        super(entityType, world);
    }

    public EntityAdvancedArrow setArrowStack(ItemStack playerArrowsStack) {
        this.playerArrowsStack = playerArrowsStack;
        return this;
    }

    protected void arrowHit(LivingEntity living) {
        super.arrowHit(living);

        // TODO: Add effects from Advanced Bow skills
    }
}
