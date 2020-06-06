package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Usuario {
	String ciudad;
	List<Guardarropas> guardarropas;
	
	public Usuario(String ciudad, List<Guardarropas> guardarropas) {
		this.ciudad = ciudad;
		this.guardarropas = guardarropas;
	}
	public void agregarGuardarropas(Guardarropas guardarropas) {
		this.guardarropas.add(guardarropas);
	}
	
	public List<Guardarropas> getGuardarropas() {
		return guardarropas;
	}

	public Atuendo sugerirAtuendo(AdapterDeClima adapter){
		GeneradorDeSugerenciasSegunTemperatura generadorDeSugerencias = new GeneradorDeSugerenciasSegunTemperatura(adapter);
		
		return generadorDeSugerencias.generarSugerencia(this.ciudad,this.guardarropas.get(0).getPrendas());
	}
	
	public void enviarProposicion(Guardarropas guardarropas, Proposicion proposicion){
		guardarropas.proponer(proposicion);
	}

}
