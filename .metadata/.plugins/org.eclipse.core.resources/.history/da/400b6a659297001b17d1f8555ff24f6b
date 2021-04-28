

public class Consumidor extends Thread {
	Almacen al;
    Consumidor(Almacen al) {
    	this.al = al;
    }

    public void run() {
    	while (true){
    		al.extraer();
    	}
    }
}
