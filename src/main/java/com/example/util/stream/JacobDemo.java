package com.example.util.stream;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
/**
 * @author liminghao.
 * @date 2023/4/2
 * @time 21:49
 */
public class JacobDemo {
    public static void main(String[] args) {
        String source = "F:\\Test111.docx";
        String target = "F:\\1122.pdf";
        System.out.println("Word转PDF开始启动...");
        ActiveXComponent app = null;
        try {
            //            调用window中的程序
            app = new ActiveXComponent("Word.Application");
            //            调用的时候不显示窗口
            app.setProperty("Visible", false);
            // 获得所有打开的文档
            Dispatch docs = app.getProperty("Documents").toDispatch();
            Dispatch doc = Dispatch.call(docs, "Open", source).toDispatch();
            System.out.println("转换文档到PDF：" + target);
            // 另存为，将文档保存为pdf，其中Word保存为pdf的格式宏的值是17
            Dispatch.call(doc, "SaveAs", target, 17);
            Dispatch.call(doc, "Close");
        } catch (Exception e) {
            System.out.println("Word转PDF出错：" + e.getMessage());
        } finally {
            // 关闭office
            if (app != null) {
                app.invoke("Quit", 0);
            }
        }
    }
}
