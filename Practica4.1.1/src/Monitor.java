
public class Monitor {
	private WrapInt v = new WrapInt();
	
	synchronized void resta() {
		v.value--;
	}
	
	synchronized void suma() {
		v.value++;
	}
	
	synchronized int value() {
		int sol = v.value;
		return sol;
	}
}
