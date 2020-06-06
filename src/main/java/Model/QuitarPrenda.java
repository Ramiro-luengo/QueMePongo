package Model;

public class QuitarPrenda implements Proposicion{
	Prenda prenda;
	
	@Override
	public void aceptar(Guardarropas guardarropas) {
		guardarropas.removerPrenda(prenda);
	}

	@Override
	public void hacerInversa(Guardarropas guardarropas) {
		guardarropas.agregarPrenda(prenda);		
	}

}
