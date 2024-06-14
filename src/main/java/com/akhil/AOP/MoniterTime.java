package com.akhil.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MoniterTime {

	private static final Logger LOGGER=LoggerFactory.getLogger(MoniterTime.class);
	
	@Around("execution(* com.akhil.service.GreetingsServiceImpl.*(..))")
	private Object moniteringTime(ProceedingJoinPoint jp) throws Throwable {
		
		Long start= System.currentTimeMillis();
		
		Object callingMethod = jp.proceed();
		
		Long end=System.currentTimeMillis();
		
		LOGGER.info("Time taken by method: "+jp.getSignature().getName()+" "+(end-start)+" ms");
		
		return callingMethod;
	}
}
