
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class AlmacenLock implements Almacen{
	private Producto [] buff;
	private int ini;
	private int fin;
	private int N;
	private final ReentrantLock l;
	private final Condition conda;
	private final Condition conde;
	
	AlmacenLock(int N){
		this.l = new ReentrantLock(true);
		this.conda = l.newCondition();
		this.conde = l.newCondition();
		this.buff = new Producto[N];
		for(int i = 0; i < N; ++i)
			buff[i] = null;
		
		this.ini = 0;
		this.fin = 0;
		this.N = N;
	}
	public void almacenar(Producto producto) throws Exception {
		l.lock();
		while(buff[fin] != null) conda.await();
		if(buff[fin] != null) throw new Exception("NOT CONSUMED");

		buff[fin] = producto;
		
		fin = (fin+1) % N;
		conde.signal();
		l.unlock();
		
	}

	public Producto extraer() throws Exception {

		l.lock();
		while(buff[ini] == null) conde.await();
		Producto p = buff[ini];
		if(p == null) throw new Exception("NULL");
		if(p.consumido) throw new Exception("TWICE");
		p.consumido = true;
		buff[ini] = null;
		
		ini = (ini + 1) % N;
		conda.signal();
		l.unlock();
		return p;
	}

}
