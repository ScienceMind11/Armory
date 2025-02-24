package net.mercury.armory.skin;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.encoding.StringEncoding;
import net.minecraft.util.Identifier;

public record WeaponSkin(Identifier guiModel, Identifier handModel) {

    public static final Codec<WeaponSkin> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Identifier.CODEC.fieldOf("gui_model").forGetter(WeaponSkin::guiModel),
            Identifier.CODEC.fieldOf("hand_model").forGetter(WeaponSkin::handModel)
    ).apply(instance, WeaponSkin::new));

    public static final PacketCodec<ByteBuf, WeaponSkin> PACKET_CODEC = new PacketCodec<>() {
        @Override
        public WeaponSkin decode(ByteBuf buf) {
            Identifier guiModel = Identifier.of(StringEncoding.decode(buf, 256), StringEncoding.decode(buf, 256));
            Identifier handModel = Identifier.of(StringEncoding.decode(buf, 256), StringEncoding.decode(buf, 256));
            return new WeaponSkin(guiModel, handModel);
        }

        @Override
        public void encode(ByteBuf buf, WeaponSkin value) {
            StringEncoding.encode(buf, value.guiModel.getNamespace(), 256);
            StringEncoding.encode(buf, value.guiModel.getPath(), 256);
            StringEncoding.encode(buf, value.handModel.getNamespace(), 256);
            StringEncoding.encode(buf, value.handModel.getPath(), 256);
        }
    };

    public WeaponSkin(Identifier guiModel) {
        this(guiModel, guiModel);
    }

    public Identifier handModel() {
        return handModel == null ? guiModel : handModel;
    }

}
