package com.university.event_service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    /**
     * Pointcut for all methods in the service layer
     */
    @Pointcut("within(com.university.eventservice.service..*)")
    public void serviceLayerPointcut() {
        // Method is empty as it's used for pointcut definition
    }

    /**
     * Pointcut for all methods in the repository layer
     */
    @Pointcut("within(com.university.eventservice.repository..*)")
    public void repositoryLayerPointcut() {
        // Method is empty as it's used for pointcut definition
    }

    /**
     * Around advice to log method entry, exit, and performance
     * @param joinPoint The join point representing the method execution
     * @return The result of the method execution
     * @throws Throwable If an error occurs during method execution
     */
    @Around("serviceLayerPointcut() || repositoryLayerPointcut()")
    public Object logMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

        // Log method entry with arguments
        logger.info("Enter: {}.{}() with argument[s] = {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));

        // Track start time
        long start = System.currentTimeMillis();

        // Proceed with method execution
        Object result = joinPoint.proceed();

        // Calculate execution time
        long executionTime = System.currentTimeMillis() - start;

        // Log method exit and execution time
        logger.info("Exit: {}.{}() with result = {}, Execution time = {} ms",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                result,
                executionTime);

        return result;
    }

    /**
     * After throwing advice to log exceptions in service and repository layers
     * @param joinPoint The join point representing the method execution
     * @param e The exception thrown
     */
    @AfterThrowing(pointcut = "serviceLayerPointcut() || repositoryLayerPointcut()", throwing = "e")
    public void logException(JoinPoint joinPoint, Throwable e) {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

        logger.error("Exception in {}.{}() with cause = {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                e.getCause() != null ? e.getCause() : "NULL",
                e);
    }
}