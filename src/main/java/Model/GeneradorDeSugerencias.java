package Model;

import java.util.List;

public interface GeneradorDeSugerencias {
	public Atuendo generarSugerencia(String ciudad,List<Prenda> prendasDisponibles); 
}
