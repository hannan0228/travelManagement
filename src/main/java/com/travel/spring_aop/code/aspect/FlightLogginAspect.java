package com.travel.spring_aop.code.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.travel.spring_aop.code.common.Constants;
import com.travel.spring_aop.code.common.Utility;

@Aspect
@Component
public class FlightLogginAspect {

	public static final Logger LOGGER = LogManager.getLogger(FlightLogginAspect.class.getName());

	/*
	 * -------------------------------------------------------------------------
	 * ---------------------- Before Section
	 * -------------------------------------------------------------------------
	 */
	@Before("execution(* com.travel.spring_aop.code.controller.ApiController.getFlights())")
	public void beforeGetFlights() {
		LOGGER.info("+++++ getFlights - before +++++");
		Utility.logAction(Constants.FLIGHT, Constants.SEARCH);
	}
	
	@Before("execution(* com.travel.spring_aop.code.controller.ApiController.saveFlight())")
	public void beforeSaveFlight() {
		LOGGER.info("+++++ saveFlight - before +++++");
		Utility.logAction(Constants.FLIGHT, Constants.NEW);
	}

	/*
	 * -------------------------------------------------------------------------
	 * ---------------------- After Section
	 * -------------------------------------------------------------------------
	 */
	@After("execution(* com.travel.spring_aop.code.controller.ApiController.getFlights())")
	public void afterGetFlights() {
		LOGGER.info(":::::: getFlights - after ::::::");
	}
	
	@After("execution(* com.travel.spring_aop.code.controller.ApiController.saveFlight())")
	public void afterSaveFlight(JoinPoint joinPoint) {
		LOGGER.info(":::::: saveFlight - after ::::::");
	}

	/*
	 * -------------------------------------------------------------------------
	 * ---------------------- After Return Section
	 * -------------------------------------------------------------------------
	 */
	@AfterReturning(pointcut = "execution(* com.travel.spring_aop.code.controller.ApiController.getFlights())", returning = "result")
	public void afterReturnGetFlights(JoinPoint joinPoint, Object result) {
		LOGGER.info("###### getFlights - afterReturn = " + result.toString() + " ######");
	}
	
	@AfterReturning(pointcut="execution(* com.travel.spring_aop.code.controller.ApiController.saveFlight())", returning="result")
	public void afterReturnSaveFlight(JoinPoint joinPoint, Object result) {
		LOGGER.info("###### saveFlight - afterReturn = " + result.toString() + "  ######");
	}
}
