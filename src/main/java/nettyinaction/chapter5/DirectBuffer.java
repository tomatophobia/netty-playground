package nettyinaction.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class DirectBuffer {
    public static void main(String[] args) {
        ByteBuf directBuf = Unpooled.directBuffer();
        if (!directBuf.hasArray()) {
            int length = directBuf.readableBytes();
            byte[] array = new byte[length];
            directBuf.getBytes(directBuf.readerIndex(), array);
            // handleArray(array, 0, length);
        }
    }
}
