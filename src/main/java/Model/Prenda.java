package Model;

public class Prenda{
	TipoPrenda tipo;
	Material material;
	Color colorPrincipal;
	Color colorSecundario;
	Trama trama;
	int temperaturaMaximaDeUso;
	
	
	 public Prenda(TipoPrenda tipo, Material material, Color colorPrincipal, Color colorSecundario,Trama trama, int temperaturaMaximaDeUso) {
		this.tipo = tipo;
		this.material = material;
		this.colorPrincipal = colorPrincipal;
		this.colorSecundario = colorSecundario;
		this.trama = trama;
		this.temperaturaMaximaDeUso = temperaturaMaximaDeUso;
	}
	 
	 public Categoria getCategoria() {
		 return this.tipo.getCategoria();
	 }

}
