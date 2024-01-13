package test.sscom;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriterExample {
    public static void main(String[] args) {
        String csvFile = "F:/test/test.csv"; // 指定保存的CSV文件路径
        String[] data = {"John", "Doe", "30"}; // 输入数据

        try (FileWriter fileWriter = new FileWriter(csvFile);
             CSVPrinter csvPrinter = new CSVPrinter(fileWriter,
                     CSVFormat.DEFAULT.withHeader("First Name", "Last Name", "Age"))) {
            csvPrinter.printRecord(data); // 写入数据
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
