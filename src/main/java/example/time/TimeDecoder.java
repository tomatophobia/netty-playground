package example.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

// ByteToMessageDecoder는 ChannelInboundHandlerAdapter를 상속한다. 그니까 그냥 추가 기능이 있는 핸들러다.
public class TimeDecoder extends ByteToMessageDecoder {
    // message를 받을 때마다 실행되나 봄. 그 때까지 안 읽으면 버퍼에 메시지가 계속 쌓이는 듯
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }
        out.add(in.readBytes(4));
    }
}

// 이런 구현도 가능하다. 아마 ReplayingDecoder는 in.readBytes가 성공할 때까지 반복하나보다.
//public class TimeDecoder extends ReplayingDecoder<Void> {
//    @Override
//    protected void decode(
//            ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
//        out.add(in.readBytes(4));
//    }
//}
