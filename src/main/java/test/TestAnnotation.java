package test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 测试自定义注解
 * @author liminghao.
 * @date 2022/4/4
 * @time 19:42
 */
public class TestAnnotation {

    @MyAnnotation2(name = "路明非", age = 18)
    public void test() {

    }
}


@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    // 注解的参数：参数类型 + 参数名();
    String name() default "";
    int age() default 0;

    String[] schools() default {"卡塞尔学院"};
}

