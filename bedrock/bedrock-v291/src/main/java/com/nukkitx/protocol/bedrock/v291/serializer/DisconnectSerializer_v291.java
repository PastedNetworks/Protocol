package com.nukkitx.protocol.bedrock.v291.serializer;

import com.nukkitx.protocol.bedrock.packet.DisconnectPacket;
import com.nukkitx.protocol.bedrock.v291.BedrockUtils;
import com.nukkitx.protocol.serializer.PacketSerializer;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DisconnectSerializer_v291 implements PacketSerializer<DisconnectPacket> {
    public static final DisconnectSerializer_v291 INSTANCE = new DisconnectSerializer_v291();


    @Override
    public void serialize(ByteBuf buffer, DisconnectPacket packet) {
        buffer.writeBoolean(packet.isDisconnectScreenHidden());
        if (!packet.isDisconnectScreenHidden()) {
            BedrockUtils.writeString(buffer, packet.getKickMessage());
        }
    }

    @Override
    public void deserialize(ByteBuf buffer, DisconnectPacket packet) {
        packet.setDisconnectScreenHidden(buffer.readBoolean());
        if (!packet.isDisconnectScreenHidden()) {
            packet.setKickMessage(BedrockUtils.readString(buffer));
        }
    }
}
