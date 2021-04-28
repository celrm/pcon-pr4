
import java.util.concurrent.Semaphore;

public class AlmacenSem implements Almacen{
	Producto buff;
	Semaphore empty;
	Semaphore full;
	
	AlmacenSem(){
		this.empty = new Semaphore(1);
		this.full = new Semaphore(0);
	}
	public void almacenar(Producto producto) throws Exception {
		try {
			empty.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(buff != null) throw new Exception("NOT CONSUMED");
		this.buff = producto;
		
		full.release();
		
	}

	public Producto extraer() throws Exception {
		try {
			full.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Producto p = buff;
		if(p == null) throw new Exception("NULL");
		if(p.consumido) throw new Exception("TWICE");
		p.consumido = true;
		buff = null;
		
		empty.release();
		return p;
	}

}
