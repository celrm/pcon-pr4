

public class Productor extends Thread {
	Almacen al;
    Productor(Almacen al) {
    	this.al = al;
    }

    public void run() {
    	while (true){
    		Producto p = new Producto();
    		try {
				al.almacenar(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
}
