package nettyinaction.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class BackingArray {
    public static void main(String[] args) {
        ByteBuf heapbuf = Unpooled.buffer();
        if (heapbuf.hasArray()) {
            byte[] array = heapbuf.array();
            int offset = heapbuf.arrayOffset() + heapbuf.readerIndex();
            int length = heapbuf.readableBytes();
            // handleArray(array, offset, length);
        }
    }
}
