import java.util.concurrent.Semaphore;

public class Decrementar extends Thread {
    WrapInt n;
    int N;
    int id;
    Semaphore l;
    Decrementar(WrapInt n,int N,int id,Semaphore l2) {
    	this.n = n;
        this.N = N;
        this.id = id;
        this.l = l2;
    }

    public void run() {
        for (int i = 0; i < N; ++i){
        	try 
            {
                l.acquire();
            	
            	--n.value;
              
                
            } catch (InterruptedException exc) {
                    System.out.println(exc);
                }
            	l.release();

        }
    }


}
