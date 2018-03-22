/**
 * 
 */
package com.zhy.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

import java.util.Date;

/**
 * @author zhailiang
 *
 */
//@Aspect
//@Component
public class TimeAspect {
	
	@Around("execution(* com.imooc.web.controller.UserController.*(..))")// UserController.*  指UserController里任何一个方法，这个方法包含任何一个参数
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("time aspect start");
		
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			System.out.println("arg is "+arg);
		}
		
		long start = new Date().getTime();
		
		Object object = pjp.proceed();  //开始调用controller中的方法
		
		System.out.println("time aspect 耗时:"+ (new Date().getTime() - start));
		
		System.out.println("time aspect end");
		
		return object;
	}

}
