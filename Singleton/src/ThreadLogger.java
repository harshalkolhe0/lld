public class ThreadLogger extends Thread{
    
    @Override
    public void run() {
        Logger logger = Logger.getLogger();
        logger.log("from user");
    }


}
