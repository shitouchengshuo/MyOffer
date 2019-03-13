package qiqi.test;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class LongConnTest {

    String host = "localhost";
    int port = 10005;

    public void testLongConn() throws Exception {
        System.out.println("+++++++++++++++++strat+++++++++++");
        final Socket socket = new Socket();
        socket.connect(new InetSocketAddress(host, port));
        Scanner scanner = new Scanner(System.in);
        new Thread(() -> {
            while (true) {
                try {
                    byte[] input = new byte[64];
                    int readByte = socket.getInputStream().read(input);
                    System.out.println("+++++++++++++++++readByte："+readByte+"+++++++++++");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        int code;
        while (true) {
            code = scanner.nextInt();
            System.out.println("+++++++++++++++++input code:"+code+"+++++++++++");
            byte[] content = ("77777888899991111222233334444").getBytes();
            ByteBuffer byteBuffer = ByteBuffer.allocate(content.length);//创建HeapByteBuffer
            byteBuffer.put((byte) 2);
            byteBuffer.putInt(content.length);
            byteBuffer.put(content);
            socket.getOutputStream().write(byteBuffer.array());
            System.out.println("+++++++++++++++++发送数据"+content+"完成+++++数据长度"+content.length+"++++++");
            socket.close();
        }
    }

    // 因为Junit不支持用户输入,所以用main的方式来执行用例
    public static void main(String[] args) throws Exception {
        new LongConnTest().testLongConn();
    }
}
