package test;

/**
 * @author liminghao.
 * @date 2023/6/25
 * @time 15:18
 */
public class TestTry {
    public static void main(String[] args) {
        TestTry.ok2();
    }

    public static void ok2() {
        try {
            int i = 1/0;
            System.out.println("进入try代码块");
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        } finally {
            System.out.println("进入finally代码块");
            return;
        }
//        return;
    }
}
