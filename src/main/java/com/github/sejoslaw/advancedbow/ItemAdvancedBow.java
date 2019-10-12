package com.github.sejoslaw.advancedbow;

import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
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

    // Advanced Bow Properties
    private int strength = 1;
    private float arrowVelocity = 1;

    public ItemAdvancedBow() {
        super(GetAdvancedBowProperties());
        this.setRegistryName(AdvancedBow.MODID);
    }

    @OnlyIn(Dist.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        // TODO: Add Advanced Bow details and skills

        // General informations
        tooltip.add(new StringTextComponent(""));
        tooltip.add(this.buildHeader("Details:"));
        tooltip.add(this.buildDetailsRow("  Strength:", this.strength));
        tooltip.add(this.buildDetailsRow("  Arrow Velocity:", this.arrowVelocity));

        // Skills
    }

    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);

        // TODO: Add modifiers

        return multimap;
    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
//    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
//    }

    /**
     * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
     * {@link #onItemUse}.
     */
//    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
//    }

    private ITextComponent buildHeader(String text) {
        return new StringTextComponent(text)
                .setStyle(new Style()
                        .setColor(TextFormatting.AQUA)
                        .setBold(true));
    }

    private ITextComponent buildDetailsRow(String text, Object value) {
        ITextComponent textComponent = new StringTextComponent(text).setStyle(new Style().setColor(TextFormatting.GREEN));
        ITextComponent valueComponent = new StringTextComponent(value.toString()).setStyle(new Style().setColor(TextFormatting.YELLOW));
        return new StringTextComponent(textComponent.getFormattedText() + " " + valueComponent.getFormattedText());
    }

    private static Properties GetAdvancedBowProperties() {
        Properties properties = new Properties()
                .maxStackSize(1);
        return properties;
    }
}
