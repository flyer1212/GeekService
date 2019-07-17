package msg.init_netty;

import msg.server.NettyServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class InitNettyServer implements CommandLineRunner {


//    @Resource
//    private NettyServer nettyServer;

    @Override
    public void run(String... args) throws Exception {
        //nettyServer.run(8000);
        new NettyServer().run(8000);
    }
}
