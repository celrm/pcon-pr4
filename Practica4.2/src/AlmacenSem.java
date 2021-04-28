
import java.util.concurrent.Semaphore;

public class AlmacenSem implements Almacen{
	Producto [] buff;
	Semaphore empty;
	Semaphore full;
	Semaphore mutexP;
	Semaphore mutexC;
	int ini;
	int fin;
	int N;
	AlmacenSem(int N){
		this.buff = new Producto[N];
		for(int i = 0; i < N; ++i)
			buff[i] = null;
		
		this.empty = new Semaphore(N);
		this.full = new Semaphore(0);
		this.mutexP = new Semaphore(1);
		this.mutexC = new Semaphore(1);
		this.ini = 0;
		this.fin = 0;
		this.N = N;
	}
	public void almacenar(Producto producto) throws Exception {
		try {
			empty.acquire();
			mutexP.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if(buff[fin] != null) throw new Exception("NOT CONSUMED");

		buff[fin] = producto;
		
		fin = (fin+1) % N;
		
		mutexP.release();
		full.release();
		
	}

	public Producto extraer() throws Exception {
		try {
			full.acquire();
			mutexC.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Producto p = buff[ini];
		if(p == null) throw new Exception("NULL");
		if(p.consumido) throw new Exception("TWICE");
		p.consumido = true;
		buff[ini] = null;
		
		ini = (ini + 1) % N;
		mutexC.release();
		empty.release();
		return p;
	}

}
