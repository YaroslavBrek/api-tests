package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Waiter {

    private static final Logger logger = LogManager
            .getLogger(Waiter.class);

    public static void waitFor(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            logger.error("Interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
