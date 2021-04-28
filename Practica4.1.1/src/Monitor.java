
public class Monitor {
	private WrapInt v = new WrapInt();
	private boolean locked = false;
	
	synchronized void resta() {
		try {
			while(locked)
				wait();
		} catch (InterruptedException e) {}
		locked=true;
		v.value--;
		locked=false;
		notify();
	}
	
	synchronized void suma() {
		try {
			while(locked)
				wait();
		} catch (InterruptedException e) {}
		locked=true;
		v.value++;
		locked=false;
		notify();
	}
	
	synchronized int value() {
		int sol = v.value;
		return sol;
	}
}
