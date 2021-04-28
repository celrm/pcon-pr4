public class Decrementar extends Thread {
    Monitor n;
    int N;
    int id;
    Decrementar(Monitor n,int N,int id) {
    	this.n = n;
        this.N = N;
        this.id = id;
    }

    public void run() {
        for (int i = 0; i < N; ++i){
            n.resta();
        }
    }


}
