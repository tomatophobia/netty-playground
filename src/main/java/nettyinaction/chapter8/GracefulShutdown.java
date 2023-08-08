package nettyinaction.chapter8;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.Future;

public class GracefulShutdown {
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        // something

        Future<?> future = group.shutdownGracefully();
        future.syncUninterruptibly();
    }
}
