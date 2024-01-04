package test.sscom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 设备连接
 */
public class DeviceConnection {

    private String ipAddress; // 设备的IP地址
    private int port; // 设备的端口号
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public static void main(String[] args) {
        DeviceConnection deviceConnection = new DeviceConnection();
        // 23, 26, 29, 32
        deviceConnection.connect("172.16.32.2", 32); // 设置设备的IP地址和端口号
    }

    public void connect(String ip, int serverPort) {
        ipAddress = ip;
        port = serverPort;
        try {
            socket = new Socket(ipAddress, port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while (true) {
                // 创建Socket并连接设备

//                System.out.println("Connected to device at " + ipAddress + ":" + port);

                // 获取输入输出流
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // 发送数据到设备
//            out.println("Hello, device!");

                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
//                System.out.println(dateFormat.format(date));
                // 接收设备返回的数据
                String response = in.readLine();
                System.out.println(dateFormat.format(date) + " 数据: " + response);
            }
            // 在这里可以对接收到的数据进行处理

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
