package qiqi.test;
import java.net.*;
import java.io.*;

public class GreetingClient{
    public static void main(String [] args)
    {
        try
        {
            System.out.println("连接到主机：localhost ，端口号：6066");
            Socket client = new Socket("localhost",8883);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应： " + in.readUTF());
            client.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}