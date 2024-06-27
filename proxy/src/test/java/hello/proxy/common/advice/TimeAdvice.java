package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {
    // target을 넣어두는 행위를 안해도 됨.
//    private final Object target;
//
//    public TimeAdvice(Object target) {
//        this.target = target;
//    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("TimeProxy 실행");
        Long startTime = System.currentTimeMillis();

        // method.invoke(target, args); 이전과 다르게 target 등의 정보가 MethodInvocation 안에 다 포함되어있음.
        Object result = invocation.proceed();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("TimeProxy 종료 resultTime = {}", resultTime);
        return result;
    }
}
