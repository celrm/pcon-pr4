public class main {
	public static void main(String[] args) {
		int M = 20;
		int K = 100;
		int N = 10;
		Productor[] prod = new Productor[M];
		Consumidor[] cons = new Consumidor[K];
		
		Almacen al = new MultiBuffer(N); 
		for (int i = 0; i < M; ++i){
			prod[i] = new Productor(al);
			prod[i].start();
		}
		for (int j = 0; j < K; ++j){
			cons[j] = new Consumidor(al);
			cons[j].start();
		}
	}
}
