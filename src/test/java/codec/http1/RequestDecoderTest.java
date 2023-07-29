package codec.http1;

import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.LastHttpContent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestDecoderTest {
    @Test
    public void test1() {
        // 테스트할 byte array
        byte[] content = new byte[1];
        // EmbeddedChannel 만들기
        EmbeddedChannel channel = new EmbeddedChannel(new RequestDecoder());
        // 채널에 쓰기
        assertTrue(channel.writeInbound(Unpooled.copiedBuffer(content)));
        // 채널에서 디코딩 결과 읽기
        HttpRequest req = channel.readInbound();
        // req 제대로 생성되었는지 테스트
        assertNotNull(req);
        // 헤더 테스트
//        checkHeaders(req.headers());
        // 트레일러 테스트...?
//        LastHttpContent c = channel.readInbound();
//        assertEquals(CONTENT_LENGTH, c.content().readableBytes());
        // 컨텐츠 테스트
//        assertEquals(
//                Unpooled.wrappedBuffer(content, content.length - CONTENT_LENGTH, CONTENT_LENGTH),
//                c.content().readSlice(CONTENT_LENGTH));
        // 릴리즈
//        c.release();

        // 이건 잘 모름
        assertFalse(channel.finish());
        // 모든 데이터 다 읽고 더 이상 없는 것 확인
        assertNull(channel.readInbound());
    }
}