package documentation.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class TimeEncoder extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        UnixTime m = (UnixTime) msg;
        ByteBuf encoded = ctx.alloc().buffer(4);
        encoded.writeInt((int) m.value());
        ctx.write(encoded, promise);
    }
}

// 더 간단한 버전
//public class TimeEncoder extends MessageToByteEncoder<UnixTime> {
//    @Override
//    protected void encode(ChannelHandlerContext ctx, UnixTime msg, ByteBuf out) {
//        out.writeInt((int)msg.value());
//    }
//}
