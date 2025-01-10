package design.threadClass;


public class PrintSequenceUsingThreads 
{
	private static final int N = 10; 
	private static int counter = 1; 
	private static final Object lock = new Object(); 
	
    public static void main( String[] args )
    {
        Runnable printTask1 = new PrintTask(1,"First thread"); 
        Runnable printTask2 = new PrintTask(2,"Second thread"); 
        Runnable printTask3 = new PrintTask(0,"Third thread");
        
        Thread t1 = new Thread(printTask1);
        Thread t2 = new Thread(printTask2);
        Thread t3 = new Thread(printTask3);
        
        t1.start();
        t2.start();
        t3.start();
        
    }
    
    static class PrintTask implements Runnable {

    	private final int threadId; 
    	private final String threadName; 
    	
    	public PrintTask(int threadId,String threadName) {
    		this.threadId = threadId;
    		this.threadName = threadName;
    	}
    	
    	@Override
    	public void run() {
    		while(true) {
    			synchronized(lock) {
    				if(counter>N) {
    					break; 
    				}
    				if(counter%3==threadId) {
    					System.out.println(threadName + " : " + counter);
    					counter++;
    					lock.notifyAll();
    				} else {
    					try {
    						lock.wait();
    					} catch (InterruptedException e) {
    						Thread.currentThread().interrupt();
    					}
    				}
    			}
    		}
    		
    	}
    }
    	
    
}

