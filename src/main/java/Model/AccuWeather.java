package Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccuWeather implements AdapterDeClima{
	
	public float getProbabilidadDePrecipitacion(String Ciudad){
		AccuWeatherAPI apiClima = new AccuWeatherAPI();
		
		List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather(Ciudad);
		
		float probabilidadDePrecipitacion = (float) condicionesClimaticas.get(0).get("PrecipitationProbability");
		
		return probabilidadDePrecipitacion;
	}
	
	public int getTemperaturaActual(String Ciudad) {
		AccuWeatherAPI apiClima = new AccuWeatherAPI();
		
		List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather(Ciudad);
		
		HashMap<String,Object> temperaturaActual =  (HashMap<String, Object>) condicionesClimaticas.get(0).get("Temperature");
		
		return (int)temperaturaActual.get("Value") - 32;//convierto la temperatura a Celcius
	}
}
