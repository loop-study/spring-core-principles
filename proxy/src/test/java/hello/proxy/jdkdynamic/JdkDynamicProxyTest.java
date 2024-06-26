package hello.proxy.jdkdynamic;

import hello.proxy.jdkdynamic.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {

    @Test
    void dynamicProxyA() {
        AInterface target = new AImpl();
        TimeInvocationHandler handle = new TimeInvocationHandler(target);

        // 1. 클래스 로더 지정
        // 2. 인터페이스 지정
        // 3. 프록시가 실행할 로직
        AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handle);

        proxy.call();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }
    @Test
    void dynamicProxyB() {
        BInterface target = new BImpl();
        TimeInvocationHandler handle = new TimeInvocationHandler(target);

        // 1. 클래스 로더 지정
        // 2. 인터페이스 지정
        // 3. 프록시가 실행할 로직
        BInterface proxy = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(), new Class[]{BInterface.class}, handle);

        proxy.call();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }
}
