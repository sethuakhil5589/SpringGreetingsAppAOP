package com.akhil.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class LoggingAspect {
	private static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);
	
	//return-type, class-name, method-name(args)
	
	@Before("execution(* com.akhil.service.GreetingsServiceImpl.*(..))")
	public void logMethodCall(JoinPoint jp) {
		LOGGER.info("Method called Before :"+jp.getSignature().getName());
	}
	
	@After("execution(* com.akhil.service.GreetingsServiceImpl.*(..))")
	public void logMethodCallAfter(JoinPoint jp) {
		LOGGER.info("Method called After :"+jp.getSignature().getName());
	}
	
	@AfterThrowing("execution(* com.akhil.service.GreetingsServiceImpl.*(..))")
	public void logMethodCallAfterThrowing(JoinPoint jp) {
		LOGGER.info("Method has some Problem :"+jp.getSignature().getName());
	}
	
	@AfterReturning("execution(* com.akhil.service.GreetingsServiceImpl.*(..))")
	public void logMethodCallAfterReturning(JoinPoint jp) {
		LOGGER.info("Method has some Problem :"+jp.getSignature().getName());
	}
	
	
}
