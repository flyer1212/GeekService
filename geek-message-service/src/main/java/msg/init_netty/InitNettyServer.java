package msg.init_netty;


import msg.server.NettyServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class InitNettyServer implements CommandLineRunner {


    @Value("${netty.port}")
    private Integer netty_port;

    @Override
    public void run(String... args) throws Exception {
        //nettyServer.run(8000);
        new NettyServer().run(netty_port);
    }
}
