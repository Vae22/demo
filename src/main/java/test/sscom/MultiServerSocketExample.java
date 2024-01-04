package test.sscom;

/**
 * @author liminghao.
 * @date 2023/12/28
 * @time 17:28
 */
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class MultiServerSocketExample {
    public static void main(String[] args) {
        String[] serverIPs = {"172.16.32.2", "172.16.32.2", "172.16.32.2", "172.16.32.2"}; // 需要连接的服务器IP地址
        int[] serverPorts = {23, 26, 29, 32}; // 需要连接的服务器端口号

        for (int i = 0; i < serverIPs.length; i++) {
            final String serverIP = serverIPs[i];
            final int serverPort = serverPorts[i];

            Thread clientThread = new Thread(() -> {
                try {
                    Socket socket = new Socket(serverIP, serverPort);
                    System.out.println("连接到服务器：" + serverIP + ":" + serverPort);

                    InputStream inputStream = socket.getInputStream();
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = inputStream.read(buffer)) != -1) {
                        String data = new String(buffer, 0, length);
                        System.out.print("从服务器 " + serverIP + ":" + serverPort + " 收到数据：" + data);
//                        System.out.print("当前线程 "+Thread.currentThread().getName());
                    }
                    socket.close();
                    System.out.println("与服务器 " + serverIP + ":" + serverPort + " 的连接已关闭");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            clientThread.start();
        }
    }
}
