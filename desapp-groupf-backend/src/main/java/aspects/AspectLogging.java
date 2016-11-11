package aspects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

public class AspectLogging {

	private static Logger log = Logger.getLogger(AspectLogging.class.getName());

	public AspectLogging() {

		PropertyConfigurator.configure("src/main/java/log4j.properties");
	}

	public Object tiempoPasado(ProceedingJoinPoint punto) throws Throwable {

		MethodSignature signature = (MethodSignature) punto.getSignature();
		String nameMethod = signature.getMethod().getName();
		log.info("*************** Start: " + nameMethod + " *************** ");
		this.printParameters(punto.getArgs());
		Long timeInitial = System.currentTimeMillis();
		Object response = punto.proceed();
		Long timeEnd = System.currentTimeMillis();
		log.info("***************  End: " + nameMethod + " *************** ");
		Long total = timeEnd - timeInitial;
		log.info("*************** Total time  milliseconds : " + total + " *************** ");
		return response;
	}

	public void printParameters(Object[] objects) {
		log.info("--------------------- Parameters -------------------------------");

		for (Object o : objects) {
			log.info(o.toString());
		}

		log.info("--------------------- Parameters -------------------------------");

	}

}
