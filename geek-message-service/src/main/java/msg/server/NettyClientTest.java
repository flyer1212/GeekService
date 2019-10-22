package msg.server;

import com.google.gson.Gson;
import msg.entity.MessagePacket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

//public class NettyClientTest {

//    public static void main(String[] args) throws IOException {
//
//        Socket socket = new Socket("localhost", 8000);
//        OutputStream outputStream = socket.getOutputStream();
//        PrintWriter printWriter = new PrintWriter(outputStream);
//
//        MessagePacket mrp = new MessagePacket();
//
//
//        mrp.setToUserId("12233");
//        mrp.setMessage("hello sdsw");
//
//        Gson gson = new Gson();
//        String msg = gson.toJson(mrp);
//
//        printWriter.write(msg);
//        printWriter.flush();
////        socket.shutdownOutput();
////        socket.close();
//    }
//}
