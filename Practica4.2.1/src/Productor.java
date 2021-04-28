import java.util.ArrayList;
import java.util.List;

public class Productor extends Thread {
	Almacen al;
    Productor(Almacen al) {
    	this.al = al;
    }

    public void run() {
		try {
	    	int num = 1;
	    	while (true){
	    		List<Producto> productos = new ArrayList<>();
	    		for(int i=0;i<num;++i)
	    			productos.add(new Producto());
				al.almacenar(productos,num);
	    		num = (num % 4) + 1;
	    	}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
