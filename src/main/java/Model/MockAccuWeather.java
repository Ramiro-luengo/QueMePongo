package Model;

public class MockAccuWeather implements AdapterDeClima {

	@Override
	public int getTemperaturaActual(String ciudad) {
		return 57;
	}

	@Override
	public float getProbabilidadDePrecipitacion(String Ciudad) {
		return 0;
	}

}
