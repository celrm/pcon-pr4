public class main {
	static Monitor n;
	public static void main(String[] args) {
		int M = 200;
		int N = 1000;
		n = new Monitor();
		Decrementar[] dt = new Decrementar[M];
		Incrementar[] it = new Incrementar[M];
		for (int i = 0; i < M; ++i){
			it[i] = new Incrementar(n,N,2*(i+1));
			dt[i] = new Decrementar(n,N,2*(i+1)-1);
			it[i].start();
			dt[i].start();
		}
		for (int i = 0; i < M; ++i){
			try {
				dt[i].join();
				it[i].join();
			} catch (InterruptedException e) {}
		}
		System.out.println(n.value());
	}
}
