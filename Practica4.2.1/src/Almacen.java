import java.util.List;

public interface Almacen {
	
/**
* Almacena (como ultimo) un producto en el almace ́n. Si no hay
* hueco el proceso que ejecute el me ́todo bloquear ́a hasta que lo haya.
 * @throws Exception 
*/
public void almacenar(List<Producto> productos,int num) throws Exception;




/**
* Extrae el primer producto disponible. Si no hay productos el
* proceso que ejecute el método bloqueará hasta que se almacene un dato.
 * @throws Exception 
*/
public List<Producto> extraer(int num) throws Exception;

}