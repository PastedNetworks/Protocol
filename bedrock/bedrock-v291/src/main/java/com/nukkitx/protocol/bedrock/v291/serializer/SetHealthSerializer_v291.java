package com.nukkitx.protocol.bedrock.v291.serializer;

import com.nukkitx.network.VarInts;
import com.nukkitx.protocol.bedrock.packet.SetHealthPacket;
import com.nukkitx.protocol.serializer.PacketSerializer;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SetHealthSerializer_v291 implements PacketSerializer<SetHealthPacket> {
    public static final SetHealthSerializer_v291 INSTANCE = new SetHealthSerializer_v291();


    @Override
    public void serialize(ByteBuf buffer, SetHealthPacket packet) {
        VarInts.writeInt(buffer, packet.getHealth());
    }

    @Override
    public void deserialize(ByteBuf buffer, SetHealthPacket packet) {
        packet.setHealth(VarInts.readInt(buffer));
    }
}
