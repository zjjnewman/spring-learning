package aop_base_principle;

public class ZhangSan implements Speaker{

    @Override
    public void speak() {
        System.out.println("李四打人了");
    }

}