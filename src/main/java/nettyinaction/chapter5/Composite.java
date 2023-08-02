package nettyinaction.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

public class Composite {
    public static void main(String[] args) {
        CompositeByteBuf messageBuf = Unpooled.compositeBuffer();
        ByteBuf headerBuf = Unpooled.buffer();
        ByteBuf bodyBuf = Unpooled.directBuffer();
        messageBuf.addComponents(headerBuf, bodyBuf);

        int length = messageBuf.readableBytes();
        byte[] array = new byte[length];
        messageBuf.getBytes(messageBuf.readerIndex(), array);
        // handleArray(array, 0, array.length);
    }
}
