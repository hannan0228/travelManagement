package com.travel.spring_aop.code.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.travel.spring_aop.code.common.Constants;
import com.travel.spring_aop.code.common.Utility;

@Aspect
@Component
public class UserLogginAspect {
	public static final Logger LOGGER = LogManager.getLogger(UserLogginAspect.class.getName());

	/*
	 * -------------------------------------------------------------------------
	 * ---------------------- Before Section
	 * -------------------------------------------------------------------------
	 */

	@Before("execution(* com.travel.spring_aop.code.controller.ApiController.getUsers())")
	public void beforeGetUsers() {
		LOGGER.info("+++++ getUsers - before +++++");
		Utility.logAction(Constants.USER, Constants.SEARCH);
	}

	@Before("execution(* com.travel.spring_aop.code.controller.ApiController.editUserCreditLimit(String))")
	public void beforeEditUserCreditLimit() {
		LOGGER.info("+++++ editUserCreditLimit - before +++++");
		Utility.logAction(Constants.USER, Constants.EDIT);
	}

	/*
	 * -------------------------------------------------------------------------
	 * ---------------------- After Section
	 * -------------------------------------------------------------------------
	 */
	@After("execution(* com.travel.spring_aop.code.controller.ApiController.getUsers())")
	public void afterGetUsers() {
		LOGGER.info(":::::: getUsers - after ::::::");
	}

	@After("execution(* com.travel.spring_aop.code.controller.ApiController.editUserCreditLimit(String))")
	public void afterEditUserCreditLimit() {
		LOGGER.info(":::::: editUserCreditLimit - after ::::::");
	}

	/*
	 * -------------------------------------------------------------------------
	 * ---------------------- After Return Section
	 * -------------------------------------------------------------------------
	 */
	@AfterReturning(pointcut = "execution(* com.travel.spring_aop.code.controller.ApiController.getUsers())", returning = "result")
	public void afterReturnGetUsers(JoinPoint joinPoint, Object result) {
		LOGGER.info("###### getUsers - afterReturn " + result.toString() + " ######");
	}

	@AfterReturning(pointcut = "execution(* com.travel.spring_aop.code.controller.ApiController.editUserCreditLimit(String))", returning = "result")
	public void afterReturnEditUserCreditLimit(JoinPoint joinPoint, Object result) {
		LOGGER.info("###### editUserCreditLimit - afterReturn " + result.toString() + " ######");
	}

	/*
	 * -------------------------------------------------------------------------
	 * ---------------------- After Throwing Exception Section
	 * -------------------------------------------------------------------------
	 */
	@AfterThrowing(pointcut = "execution(* com.travel.spring_aop.code.controller.ApiController.editUserCreditLimit(..))", throwing = "ex")
	public void afterThrowingEditUserCreditLimit(JoinPoint joinPoint, Throwable ex) {
		LOGGER.info("====== Exception Cought on editUserCreditLimit : " + ex.getMessage() + " ======");
	}
}
