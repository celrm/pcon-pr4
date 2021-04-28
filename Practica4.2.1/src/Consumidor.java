

public class Consumidor extends Thread {
	Almacen al;
    Consumidor(Almacen al) {
    	this.al = al;
    }

    public void run() {
    	while (true){
    		try {
				al.extraer();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
}
