package Model;

public class AgregarPrenda implements Proposicion{
	Prenda prenda;
	
	@Override
	public void aceptar(Guardarropas guardarropas) {
		guardarropas.agregarPrenda(prenda);
	}

	@Override
	public void hacerInversa(Guardarropas guardarropas) {
		guardarropas.removerPrenda(prenda);
	}

}
