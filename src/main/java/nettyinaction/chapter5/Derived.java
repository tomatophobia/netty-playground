package nettyinaction.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.StandardCharsets;

public class Derived {
    public static void main(String[] args) {
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks", StandardCharsets.UTF_8);
        ByteBuf sliced = buf.slice(0, 14);
        System.out.println(sliced.toString(StandardCharsets.UTF_8));
        buf.setByte(0, (byte)'J');
        assert buf.getByte(0) == sliced.getByte(0);

        ByteBuf buf2 = Unpooled.copiedBuffer("Netty in Action rocks", StandardCharsets.UTF_8);
        ByteBuf copy = buf2.slice(0, 14);
        System.out.println(copy.toString(StandardCharsets.UTF_8));
        buf2.setByte(0, (byte)'J');
        assert buf2.getByte(0) != copy.getByte(0);
    }
}
