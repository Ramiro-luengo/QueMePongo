package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GeneradorDeSugerenciasSegunTemperatura implements GeneradorDeSugerencias{
	AdapterDeClima adapterClima;
	
	public GeneradorDeSugerenciasSegunTemperatura(AdapterDeClima adapterDeClima) {
		this.adapterClima = adapterDeClima;
	}
	
	@Override
	public Atuendo generarSugerencia(String ciudad, List<Prenda> prendasDisponibles){ 
		int temperaturaActual = adapterClima.getTemperaturaActual(ciudad);
		
		List<Prenda> prendasSugeridas = new ArrayList<Prenda>();
		
		prendasSugeridas = prendasDisponibles.stream().filter(prenda -> prenda.temperaturaMaximaDeUso >= temperaturaActual).collect(Collectors.toList());
	
		return armarAtuendoASugerir(prendasSugeridas);
	}

	public Atuendo armarAtuendoASugerir(List<Prenda> sugerencia) {
		BuilderAtuendo builder = new BuilderAtuendo();
		
		sugerencia.stream().forEach(prenda -> builder.agregarPrenda(prenda));
		
		return builder.crearAtuendo();
	}

}
