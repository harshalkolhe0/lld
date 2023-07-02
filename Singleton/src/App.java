/*
 * Ctrl+shift+p to create a new java project
 */
public class App {
    public static void main(String[] args) throws Exception {
        ThreadLogger logger1=new ThreadLogger();
        ThreadLogger logger2=new ThreadLogger();
        logger1.start();
        logger2.start();
        logger1.join();
        logger2.join();
    }
}
