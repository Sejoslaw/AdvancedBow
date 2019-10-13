package com.github.sejoslaw.advancedbow;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nullable;
import java.util.List;

public class ItemAdvancedBow extends BowItem {
    @ObjectHolder("advancedbow:advancedbow")
    public static ItemAdvancedBow ITEM;

    public static final String STATS_LEVEL = "AdvancedBow_Level";
    public static final String STATS_STRENGTH = "AdvancedBow_Strength";
    public static final String STATS_ARROW_VELOCITY = "AdvancedBow_ArrowVelocity";
    public static final String STATS_EXP = "AdvancedBow_Exp";
    public static final String STATS_EXP_MAX = "AdvancedBow_Exp_Max";

    public static final String SKILL_BURNING_ARROW = "AdvancedBow_Skill_BurningArrow"; // Level: 25
    public static final String SKILL_INFINITY = "AdvancedBow_Skill_Infinity"; // Level: 50
    public static final String SKILL_EXPLODING_ARROW = "AdvancedBow_Skill_ExplodingArrow"; // Level: 75

    public ItemAdvancedBow() {
        super(GetAdvancedBowProperties());
        this.setRegistryName(AdvancedBow.MODID);
    }

    @OnlyIn(Dist.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    public void onCreated(ItemStack stack, World world, PlayerEntity player) {
        CompoundNBT tag = stack.getOrCreateTag();

        tag.putInt(STATS_LEVEL, 1);
        tag.putFloat(STATS_STRENGTH, 1.0F);
        tag.putFloat(STATS_ARROW_VELOCITY, 1.0F);
        tag.putInt(STATS_EXP, 0);
        tag.putInt(STATS_EXP_MAX, 100);
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        CompoundNBT tag = stack.getOrCreateTag();

        tooltip.add(new StringTextComponent(""));
        tooltip.add(this.buildHeader("Details:"));
        tooltip.add(this.buildDetailsRow("   Level:", tag.getInt(STATS_STRENGTH)));

        tooltip.add(new StringTextComponent(
                getFormattedDetailsText("   Exp: ").getFormattedText() +
                        getFormattedValueText(tag.getInt(STATS_EXP)).getFormattedText() +
                        getFormattedDetailsText(" / ").getFormattedText() +
                        getFormattedValueText(tag.getInt(STATS_EXP_MAX)).getFormattedText()
        ));

        tooltip.add(this.buildDetailsRow("   Strength:", tag.getFloat(STATS_STRENGTH)));
        tooltip.add(this.buildDetailsRow("   Arrow Velocity:", tag.getFloat(STATS_ARROW_VELOCITY)));

        tooltip.add(new StringTextComponent(""));
        tooltip.add(this.buildHeader("Skills:"));
    }

    private ITextComponent buildHeader(String text) {
        return new StringTextComponent(text)
                .setStyle(new Style()
                        .setColor(TextFormatting.AQUA)
                        .setBold(true));
    }

    private ITextComponent buildDetailsRow(String text, Object value) {
        ITextComponent textComponent = getFormattedDetailsText(text);
        ITextComponent valueComponent = getFormattedValueText(value);
        return new StringTextComponent(textComponent.getFormattedText() + " " + valueComponent.getFormattedText());
    }

    private ITextComponent getFormattedDetailsText(String text) {
        return new StringTextComponent(text).setStyle(new Style().setColor(TextFormatting.GREEN));
    }

    private ITextComponent getFormattedValueText(Object value) {
        return new StringTextComponent(value.toString()).setStyle(new Style().setColor(TextFormatting.YELLOW));
    }

    private static Properties GetAdvancedBowProperties() {
        Properties properties = new Properties()
                .maxStackSize(1);
        return properties;
    }
}
