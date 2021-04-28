public class Incrementar extends Thread {
    Monitor n;
    int N;
    int id;
    Incrementar(Monitor n,int N,int id) {
    	this.n = n;
        this.N = N;
        this.id = id;
    }

    public void run() {
        for (int i = 0; i < N; ++i){
            n.suma();
        }
    }


}

