package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guardarropas{
	List<Prenda> prendas = new ArrayList<Prenda>();
	List<Proposicion> proposiciones = new ArrayList<Proposicion>();
	List<Proposicion> proposicionesAceptadas = new ArrayList<Proposicion>();
	
	public Guardarropas(List<Prenda> listaDePrendas) {
		this.prendas = listaDePrendas;
	}
	
	public List<Prenda> getPrendas() {
		return prendas;
	}
	
	public void agregarPrenda(Prenda prenda) {
		prendas.add(prenda);
	}
	
	public List<Proposicion> proposiciones(){
		return this.proposiciones;
	}
	public void removerPrenda(Prenda prenda) {
		prendas.remove(prenda);
	}

	public void proponer(Proposicion proposicion) {
		proposiciones.add(proposicion);
	}
	
	public void aceptarProposicion(Proposicion proposicion,Guardarropas guardarropas){
		proposicion.aceptar(guardarropas);
		this.proposicionesAceptadas.add(proposicion);
		this.proposiciones.remove(proposicion);
	}
	
	public void rechazarProposicion(Proposicion proposicion){
		this.proposiciones.remove(proposicion);
	}
	
	public void deshacerProposicionAceptada(Proposicion proposicion){
		proposicionesAceptadas.stream().filter(p -> p == proposicion).collect(Collectors.toList()).get(0).hacerInversa(this);
		proposicionesAceptadas.remove(proposicion);
	}
		
}
