package nettyinaction.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.StandardCharsets;

public class GetSetReadWrite {
    public static void main(String[] args) {
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", StandardCharsets.UTF_8);
        System.out.println((char)buf.getByte(0));
        int readerIndex = buf.readerIndex();
        int writerIndex = buf.writerIndex();
        buf.setByte(0, (byte)'B');
        System.out.println((char)buf.getByte(0));
        assert readerIndex == buf.readerIndex();
        assert writerIndex == buf.writerIndex();

        ByteBuf buf2 = Unpooled.copiedBuffer("Netty in Action rocks!", StandardCharsets.UTF_8);
        System.out.println((char)buf2.readByte());
        readerIndex = buf2.readerIndex();
        writerIndex = buf2.writerIndex();
        buf2.writeByte((byte)'?');
        assert readerIndex == buf2.readerIndex();
        assert writerIndex != buf2.writerIndex();
    }
}
