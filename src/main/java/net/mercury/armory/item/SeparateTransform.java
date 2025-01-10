package net.mercury.armory.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.List;

public interface SeparateTransform {

    List<ModelTransformationMode> INVENTORY = List.of(
        ModelTransformationMode.GUI,
        ModelTransformationMode.GROUND
    );

    // Implement this method, unless you reimplement `getTransformedModel()`
    default Identifier getHeldModelIdentifier() {
        return null;
    }

    @Environment(EnvType.CLIENT)
    default Identifier getTransformedModel(ModelTransformationMode mode, ItemStack stack) {
        return INVENTORY.contains(mode) ? null : getHeldModelIdentifier();
    }

}
