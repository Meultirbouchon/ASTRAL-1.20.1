package fr.astralteam.astral.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class PliersItem extends Item {
    public PliersItem(Properties pProperties) {
        super(pProperties.durability(16));
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return stack.getDamageValue() < this.getMaxDamage(stack);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack old = itemStack.copy();
        old.setDamageValue(old.getDamageValue()+1);
        return old;
    }
}
