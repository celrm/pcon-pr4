
import java.util.concurrent.Semaphore;

public class AlmacenSem implements Almacen{
	Producto buff;
	Semaphore empty;
	Semaphore full;
	
	AlmacenSem(){
		this.empty = new Semaphore(1);
		this.full = new Semaphore(0);
	}
	public void almacenar(Producto producto) {
		try {
			empty.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.buff = producto;
		
		full.release();
		
	}

	public Producto extraer() {
		try {
			full.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Producto p = buff;
		empty.release();
		return p;
	}

}
