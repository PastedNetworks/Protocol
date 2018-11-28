package com.nukkitx.protocol.bedrock.v291.serializer;

import com.nukkitx.network.VarInts;
import com.nukkitx.protocol.bedrock.packet.PlayerHotbarPacket;
import com.nukkitx.protocol.serializer.PacketSerializer;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlayerHotbarSerializer_v291 implements PacketSerializer<PlayerHotbarPacket> {
    public static final PlayerHotbarSerializer_v291 INSTANCE = new PlayerHotbarSerializer_v291();


    @Override
    public void serialize(ByteBuf buffer, PlayerHotbarPacket packet) {
        VarInts.writeUnsignedInt(buffer, packet.getSelectedHotbarSlot());
        buffer.writeByte(packet.getWindowId());
        buffer.writeBoolean(packet.isSelectHotbarSlot());
    }

    @Override
    public void deserialize(ByteBuf buffer, PlayerHotbarPacket packet) {
        packet.setSelectedHotbarSlot(VarInts.readUnsignedInt(buffer));
        packet.setWindowId(buffer.readByte());
        packet.setSelectHotbarSlot(buffer.readBoolean());
    }
}
