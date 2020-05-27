package Model;

public class BuilderPrenda {
	TipoPrenda tipo;
	Material material;
	Color colorPrincipal;
	Color colorSecundario;
	Trama trama;
	int temperaturaMaximaDeUso;
	
	public void setTipo(TipoPrenda tipo) {
		this.tipo = tipo;
	}
	
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public void setColorPrincipal(Color colorPrincipal) {
		this.colorPrincipal = colorPrincipal;
	}
	
	public void setColorSecundario(Color colorSecundario) {
		this.colorSecundario = colorSecundario;
	}
	
	public void setTrama(Trama trama) {
		this.trama = trama;
	}
	
	public void setTemperaturaMaximaDeUso(int temperaturaMaximaDeUso){
		this.temperaturaMaximaDeUso = temperaturaMaximaDeUso;
	}
	
	public Prenda crearPrenda() {
		ValidadorDeTipo validadorDeTipos = new ValidadorDeTipo();

		validadorDeTipos.validar(this.tipo);
		setearTramaPorDefecto();
		
		return new Prenda(tipo,material,colorPrincipal,colorSecundario,trama,temperaturaMaximaDeUso);
	}

	public void setearTramaPorDefecto() {
		if(this.trama == null)
			trama = Trama.LISA;
	}
	
	
}
