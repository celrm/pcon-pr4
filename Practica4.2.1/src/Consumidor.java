

public class Consumidor extends Thread {
	Almacen al;
    Consumidor(Almacen al) {
    	this.al = al;
    }

    public void run() {
    	int num = 1;
    	while (true){
    		try {
				al.extraer(num);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		num = (num % 4) + 1;
    	}
    }
}
