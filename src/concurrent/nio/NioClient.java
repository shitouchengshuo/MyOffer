package concurrent.nio;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @author qiqi.zhao
 * @date 2019/10/14
 */
public class NioClient {

    public static void client(){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(true);
            socketChannel.connect(new InetSocketAddress("127.0.0.1",8083));
            if(socketChannel.finishConnect())
            {
                int i=0;
                while(true)
                {
                    TimeUnit.SECONDS.sleep(1);
                    String info = "I'm "+i+++"-th information from client";
                    buffer.clear();
                    buffer.put(info.getBytes());
                    buffer.flip();
                    while(buffer.hasRemaining()){
                        System.out.println(buffer);
                        socketChannel.write(buffer);
                        System.out.println("send data :  " + i);
                    }
                }
            }
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
        finally{
            try{
                if(socketChannel!=null){
                    socketChannel.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void bioclient1() {
        DataOutputStream dataOutputStream = null;
        try {
            Socket socket = new Socket("127.0.0.1",8083);
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            int i = 0;
            while (true){
                TimeUnit.SECONDS.sleep(1);
                dataOutputStream.writeUTF(" data: " +i);
                dataOutputStream.flush();
                System.out.println(" send data: " + i );
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }

    }

    public static void main(String[] args) {
        //
        // for (int i = 0; i < 10; i++){
        //     new Thread(()->bioclient1() ).start();
        // }
        bioclient1();
    }
}
