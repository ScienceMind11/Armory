package net.mercury.armory.skin;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Identifier;

public record WeaponSkin(Identifier guiModel, Identifier handModel) {

    public static final Codec<WeaponSkin> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Identifier.CODEC.fieldOf("gui_model").forGetter(WeaponSkin::guiModel),
            Identifier.CODEC.fieldOf("hand_model").forGetter(WeaponSkin::handModel)
    ).apply(instance, WeaponSkin::new));

    public WeaponSkin(Identifier guiModel) {
        this(guiModel, guiModel);
    }

    public Identifier handModel() {
        return handModel == null ? guiModel : handModel;
    }

}
