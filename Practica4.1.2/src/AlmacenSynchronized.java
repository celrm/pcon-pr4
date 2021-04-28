


public class AlmacenSynchronized implements Almacen{
	private Producto [] buff;
	private int ini;
	private int fin;
	private int N;
	AlmacenSynchronized(int N){
		this.buff = new Producto[N];
		for(int i = 0; i < N; ++i)
			buff[i] = null;
		this.ini = 0;
		this.fin = 0;
		this.N = N;
	}
	public synchronized void almacenar(Producto producto) throws Exception {
		while (buff[ini] != null) wait();

		if(buff[fin] != null) throw new Exception("NOT CONSUMED");

		buff[fin] = producto;
		
		fin = (fin+1) % N;
		notify();
		
	}

	public synchronized Producto extraer() throws Exception {

		while (buff[ini] == null) wait();
		Producto p = buff[ini];
		if(p == null) throw new Exception("NULL");
		if(p.consumido) throw new Exception("TWICE");
		p.consumido = true;
		buff[ini] = null;
		
		ini = (ini + 1) % N;
		notify();
		return p;
	}

}
