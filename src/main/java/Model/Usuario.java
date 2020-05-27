package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Usuario {
	String ciudad;
	List<Prenda> guardarropa = new ArrayList<>();
	
	
	public List<Prenda> getGuardarropa() {
		return guardarropa;
	}

	public Atuendo sugerirAtuendo(AdapterDeClima adapter){
		GeneradorDeSugerenciasSegunTemperatura generadorDeSugerencias = new GeneradorDeSugerenciasSegunTemperatura(adapter);
		
		return generadorDeSugerencias.generarSugerencia(this.ciudad,this.guardarropa);
	}
	
	public Usuario(String ciudad,List<Prenda> guardarropa) {
		this.ciudad = ciudad;
		this.guardarropa = guardarropa;
	}
}
