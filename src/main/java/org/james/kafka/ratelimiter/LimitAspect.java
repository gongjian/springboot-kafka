package org.james.kafka.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LimitAspect {
    private static Logger logger = LoggerFactory.getLogger(LimitAspect.class);

    // 每秒10个令牌
    private static RateLimiter rateLimiter = RateLimiter.create(2.0);

    @Pointcut("@annotation(org.james.kafka.ratelimiter.ServiceLimit)")
    public void ServiceAspect() {
    }

    @Around("ServiceAspect()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Boolean flag = rateLimiter.tryAcquire();

        Object obj = null;
        try {
            if (flag) {
                obj = joinPoint.proceed();
            } else {
                logger.warn("Request limited.");
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return obj;
    }
}
