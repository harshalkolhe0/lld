import java.util.concurrent.locks.ReentrantLock;
public class Logger {
    public static int cnt=0;
    public static Logger logger=null;
    public static ReentrantLock reentrantLock = new ReentrantLock();
    private Logger(){
        cnt++;
        System.out.println("Count :"+cnt);
    }
    public static Logger getLogger(){
        if(logger==null){
            reentrantLock.lock();
            if(logger!=null)return logger;
            logger=new Logger();
            reentrantLock.unlock();
        }
        return logger;
    }
    public void log(String message){
        System.out.println(message);
    }
}
