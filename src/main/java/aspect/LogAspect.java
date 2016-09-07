package aspect;

import annotation.LogAnnotation;
import model.User;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by z673413 on 2016/9/6.
 */
@Aspect
public class LogAspect {
    @Pointcut("execution(* controller.LoginController.*(..)) && @annotation(la)")
    public void controllerPointcut(LogAnnotation la) {
    }

    @Pointcut("execution(* controller.LoginController.logout(..))")
    public void logoutPointcut() {
    }

    @Before("controllerPointcut(la)")
    public void addControllerRecord(JoinPoint joinPoint, LogAnnotation la) {
        Logger logger = Logger.getLogger(joinPoint.getTarget().getClass());
        logger.info("function " + joinPoint.getSignature().getName() + " is called!");
    }

    @Before("logoutPointcut()")
    public void addLogoutRecord(JoinPoint joinPoint) {
        Logger logger = Logger.getLogger(joinPoint.getTarget().getClass());
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        User user = (User) request.getSession().getAttribute("loginUser");
        logger.info(user.getId() + " logout!");
    }
}
