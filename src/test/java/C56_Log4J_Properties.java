import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

public class C56_Log4J_Properties {


    @Test
    public void log4jTest(){

        PropertyConfigurator.configure("log4j.properties");// Kullanılacak properties dosyası belirtilir

        Logger logger = LogManager.getLogger(C56_Log4J_Properties.class.getName());

        logger.fatal("Fatal Message"); // --> Default olarak ayarlama gerektirmeden yazdırılır
        logger.error("Error Mesage");// --> Default olarak ayarlama gerektirmeden yazdırılır
        logger.warn("Warn Message");//Yazdırılması için ayarlama yapılması lazım
        logger.info("Info Message");//Yazdırılması için ayarlama yapılması lazım
        logger.debug("Debug Message");//Yazdırılması için ayarlama yapılması lazım
        logger.trace("Trace Message");//Yazdırılması için ayarlama yapılması lazım


    }

}
