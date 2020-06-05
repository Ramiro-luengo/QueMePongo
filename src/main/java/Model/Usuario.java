package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Usuario {
	String ciudad;
	Guardarropas guardarropas;
	List<Proposicion> proposiciones = new ArrayList<Proposicion>();
	List<Proposicion> proposicionesAceptadas = new ArrayList<Proposicion>();
	
	public Usuario(String ciudad, Guardarropas guardarropas) {
		this.ciudad = ciudad;
		this.guardarropas = guardarropas;
	}
	
	public Guardarropas getGuardarropa() {
		return guardarropas;
	}

	public Atuendo sugerirAtuendo(AdapterDeClima adapter){
		GeneradorDeSugerenciasSegunTemperatura generadorDeSugerencias = new GeneradorDeSugerenciasSegunTemperatura(adapter);
		
		return generadorDeSugerencias.generarSugerencia(this.ciudad,this.guardarropas.getPrendas());
	}
	
	public void enviarProposicion(Usuario usuario, Proposicion proposicion) {
		usuario.recibirProposicion(proposicion);
	}

	public void recibirProposicion(Proposicion proposicion) {
		proposiciones.add(proposicion);
	}
	
	public void aceptarProposicion(Proposicion proposicion){
		proposicionesAceptadas.add(proposicion);
		proposicion.aceptar(guardarropas);
	}
	
	public void rechazarProposicion(Proposicion proposicion){
		proposicion.rechazar();
	}
	
	public void deshacerProposicionAceptada(Proposicion proposicion){
		proposicion.hacerInversa(guardarropas);
	}
		
}
