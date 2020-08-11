import com.atguigu.aop.MathCalculator;
import com.atguigu.config.MainConfigOfAOP;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTestAOP {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        MathCalculator bean = applicationContext.getBean(MathCalculator.class);
        int a = bean.div(1, 1);
    }
}
