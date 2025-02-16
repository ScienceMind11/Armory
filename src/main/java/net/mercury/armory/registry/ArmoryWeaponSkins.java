package net.mercury.armory.registry;

import net.mercury.armory.Armory;
import net.mercury.armory.skin.WeaponSkin;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArmoryWeaponSkins {

    public static final HashMap<Item, List<WeaponSkin>> SKINS = new HashMap<>();
    public static final List<Identifier> MODELS = new ArrayList<>();

    public static final WeaponSkin DEFAULT_SCYTHE = new WeaponSkin(
        Armory.id("item/scythe"),
        Armory.id("item/hand/scythe")
    );

    public static final WeaponSkin DEFAULT_GLAIVE = new WeaponSkin(
            Armory.id("item/glaive"),
            Armory.id("item/hand/glaive")
    );

    public static final WeaponSkin DEFAULT_HALBERD = new WeaponSkin(
            Armory.id("item/halberd"),
            Armory.id("item/hand/halberd")
    );

    public static void register() {
        registerSkin(ArmoryItems.SCYTHE, DEFAULT_SCYTHE);
        registerSkin(ArmoryItems.GLAIVE, DEFAULT_GLAIVE);
        registerSkin(ArmoryItems.HALBERD, DEFAULT_HALBERD);
    }

    private static void registerSkin(Item item, WeaponSkin skin) {
        if(!SKINS.containsKey(item)) {
            SKINS.put(item, List.of(skin));
        } else {
            SKINS.get(item).add(skin);
        }
        MODELS.add(skin.guiModel());
        if(skin.guiModel() != skin.handModel()) MODELS.add(skin.handModel());
    }

}
