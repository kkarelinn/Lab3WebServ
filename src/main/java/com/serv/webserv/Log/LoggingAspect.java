package com.example.lab2sushishop.Log;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.util.StopWatch;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Aspect

public class LoggingAspect {

    private final static Logger logger = LogManager.getLogger(LoggingAspect.class);


    @Around("@annotation(Loging)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch clock = new StopWatch();
        logger.info("\nLOG {} run... /{}, class - {}\n",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                joinPoint.getSignature().getName(),
                joinPoint.getTarget().getClass().toString());

        clock.start();
        Object object = joinPoint.proceed();
        clock.stop();
        logger.info(" - lead time {} milSec", clock.getLastTaskTimeMillis());
        return object;
    }

    }





