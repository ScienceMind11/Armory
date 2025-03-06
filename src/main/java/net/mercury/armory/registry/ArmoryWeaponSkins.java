package net.mercury.armory.registry;

import net.mercury.armory.Armory;
import net.mercury.armory.skin.WeaponSkin;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArmoryWeaponSkins {

    public static final HashMap<Item, ArrayList<WeaponSkin>> SKINS = new HashMap<>();
    public static final List<Identifier> MODELS = new ArrayList<>();

    public static final WeaponSkin DEFAULT_SCYTHE = new WeaponSkin(
        Armory.id("item/scythe"),
        Armory.id("item/hand/scythe")
    );

    public static final WeaponSkin DEVILSKNIFE = new WeaponSkin(
            Armory.id("item/skin/scythe/devilsknife/gui"),
            Armory.id("item/skin/scythe/devilsknife/hand")
    );

    public static final WeaponSkin CARMINE = new WeaponSkin(
            Armory.id("item/skin/scythe/carmine/gui"),
            Armory.id("item/skin/scythe/carmine/hand")
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

        // Register in reverse order from how you want them to cycle for... some reason
        registerSkin(ArmoryItems.SCYTHE, CARMINE);
        registerSkin(ArmoryItems.SCYTHE, DEVILSKNIFE);
        registerSkin(ArmoryItems.SCYTHE, DEFAULT_SCYTHE);

        registerSkin(ArmoryItems.GLAIVE, DEFAULT_GLAIVE);

        registerSkin(ArmoryItems.HALBERD, DEFAULT_HALBERD);

    }

    private static void registerSkin(Item item, WeaponSkin skin) {
        ArrayList<WeaponSkin> list = new ArrayList<>();
        list.add(skin);

        if(SKINS.containsKey(item)) list.addAll(SKINS.get(item));
        SKINS.put(item, list);

        MODELS.add(skin.guiModel());
        if(skin.guiModel() != skin.handModel()) MODELS.add(skin.handModel());
    }

}
