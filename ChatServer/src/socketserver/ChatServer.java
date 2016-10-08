package socketserver;
import  java.io.*;
import  java.net.*;
import  java.applet.Applet;
import java.nio.channels.SocketChannel;


/**
 * Created by LiuToTo.365ime on 16/9/22.
 */
public class ChatServer {
    public  static  ChatServer instance;
    public  static  ChatServer shareChatServer(){
        instance = new ChatServer();
        return instance;
    }

    public void connectServer(){
        try {
            ServerSocket server = null;
            SocketChannel
            try {
                // 创建一个Socket服务监听8080端口
                server = new ServerSocket(4700);
            }catch (Exception e){
                System.out.print("创建Socket监听服务失败！Error："+e);
            }

            Socket socket = null;
            try{
                // server 阻塞等待客户端请求，请求到来时候返回一个socket对象
                socket = server.accept();
            }catch (Exception e){
                System.out.print("server 异常，Error："+e);
            }
            String clinetMessage;
            // 获取输入流
            BufferedReader serverReader = new BufferedReader (new InputStreamReader(socket.getInputStream()));

            // 获取输出流
            PrintWriter serverWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            // /由系统标准输入设备构造BufferedReader对象
            BufferedReader deviceReader = new BufferedReader(new InputStreamReader(System.in));

            // 获取客户端消息
            clinetMessage = serverReader.readLine();

            System.out.print("Client:"+clinetMessage);

            while (!clinetMessage.equals("over")){
                serverWriter.println(clinetMessage);
                serverWriter.flush();;
                System.out.print("Server:"+clinetMessage);

                clinetMessage = null;
                clinetMessage = serverReader.readLine()+"\n";
                System.out.print("Client:"+clinetMessage);
            }
            serverReader.close();
            serverWriter.close();
            socket.close();;
            server.close();;
        }catch (Exception e){
            System.out.print("服务异常，Error:"+e);
        }
    }

}
