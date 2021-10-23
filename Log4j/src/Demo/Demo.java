package Demo;

import org.apache.logging.log4j.*;

public class Demo {
	
	private static Logger log = LogManager.getLogger(Demo.class.getName());

	public static void main(String[] args) {
		log.debug("1 print Debug log1");
		log.error(" 2 Print Error log1 : data not found");
		log.error(" 3 Print Error log 2");
		log.error(" 4 Print Error log1 : button is missing");
		log.error(" 5 Print Error log 2 : element not visible");
		log.info(" 6 print info log");

	}

}
