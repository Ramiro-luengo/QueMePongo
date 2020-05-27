package Model;

import java.util.List;
import java.util.Map;

public class GeneradorDeSugerenciasSegunPrecipitacion implements GeneradorDeSugerencias{
	AdapterDeClima adapterClima;
	
	public GeneradorDeSugerenciasSegunPrecipitacion(AdapterDeClima adapterClima) {
		this.adapterClima = adapterClima;
	}
	
	@Override
	public Atuendo generarSugerencia(String ciudad, List<Prenda> prendasDisponibles){
		
		return null;
	}

}
