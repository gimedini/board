package goottgirls.web.board.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private static final Logger logger = 
			LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* goottgirls.web.board.service.CustomerServiceImple.*Customer(..))")
	// *Customer(..) : CustomerServiceImple 클래스 내에 Customer 이름이 뒤에 붙는 메소드에 적용
	public void beforeAdvice(JoinPoint jp) {
		logger.info("===== beforeAdvice");
		logger.info("target : " + jp.getTarget());
		logger.info("signature : " + jp.getSignature());
	}
	
	@After("execution(* goottgirls.web.board.service.*ServiceImple.create*(..))")
	public void afterAdvice() {
		logger.info("===== afterAdvice");
	}
		
	
}












