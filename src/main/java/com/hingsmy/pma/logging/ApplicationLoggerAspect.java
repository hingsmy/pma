package com.hingsmy.pma.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.hingsmy.pma.controllers..*)" + "|| within(com.hingsmy.pma.dao..*)")
    public void definePackagePointcuts() {
        // 空方法，只是用来定义切点
    }

    @Before("definePackagePointcuts()")
    public void log1() {
        log.debug("--------------------------------------------");
    }

    @After("definePackagePointcuts()")
    public void log2() {
        log.debug("--------------------------------------------");
    }
}
