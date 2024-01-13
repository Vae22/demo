package test.sscom;

import java.io.*;
import java.net.Socket;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class ServerDataToExcel {
    public static void main(String[] args) {
        try {
            // 与服务器建立连接, 23, 26, 29, 32
            Socket socket = new Socket("172.16.32.2", 32);

            // 创建CSV文件写入器
            BufferedWriter writer = new BufferedWriter(new FileWriter("文件路径.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

            // 获取输入流，用于接收服务器数据
            InputStream inputStream = socket.getInputStream();

            // 逐行读取服务器数据并写入CSV文件
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            int dataCount = 0;
            int fileCount = 1;
            while ((line = reader.readLine()) != null) {
                // 达到一定的数据条数时，生成下一个CSV文件
                if (dataCount >= 10) {
                    csvPrinter.flush();
                    System.out.println("数据写入CSV格式的Excel成功！");
                    csvPrinter.close();

                    // 重置计数器和写入器
                    dataCount = 0;
                    fileCount++;
                    writer = new BufferedWriter(new FileWriter("F:/test/test" + fileCount + ".csv"));
                    csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
                }

                String[] rowData = line.split(",");
                csvPrinter.printRecord((Object[]) rowData);

                dataCount++;
            }

            // 关闭写入器和连接
            csvPrinter.flush();
            csvPrinter.close();
            socket.close();

            System.out.println("数据写入CSV格式的Excel成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
