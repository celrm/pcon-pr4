import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiBuffer implements Almacen{
	private Producto [] buff;
	private int ini;
	private int N;
	private int prods;
	MultiBuffer(int N){
		this.buff = new Producto[N];
		for(int i = 0; i < N; ++i)
			buff[i] = null;
		
		this.ini = 0;
		this.N = N;
		this.prods=0;
	}
	public synchronized void almacenar(List<Producto> productos,int num) throws Exception {
		while(prods+num > N) 
			wait();
		Iterator<Producto> it = productos.iterator();
		for(int i = 0; i < num; ++i) {
			int fin = (ini+prods+i) % N;
			if(buff[fin] != null) 
				throw new Exception("NOT CONSUMED");
	
			buff[fin] = it.next();
		}
		prods = prods + num;
		notify();
	}

	public synchronized List<Producto> extraer(int num) throws Exception {
		while(prods < num) 
			wait();
		List<Producto> productos = new ArrayList<Producto>();
		for(int i = 0; i < num; ++i) {
			int nxt = (ini+i) % N;
			Producto p = buff[nxt];
			if(p == null) throw new Exception("NULL");
			if(p.consumido) throw new Exception("TWICE");
			p.consumido = true;
			buff[nxt] = null;
			productos.add(p);
		}
		
		ini = (ini + num) % N;
		prods = prods - num;
		notify();

		return productos;
	}

}
