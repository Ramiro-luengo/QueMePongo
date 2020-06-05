/*
@startuml

class AccuWeatherAPI [[java:Model.AccuWeatherAPI]] {
	+List<Map<String,Object>> getWeather(String ciudad)
}
interface Proposicion [[java:Model.Proposicion]] {
	void aceptar(Guardarropas guardarropas)
	void rechazar()
	void hacerInversa(Guardarropas guardarropas)
}
class Usuario [[java:Model.Usuario]] {
	~String ciudad
	+Usuario(String ciudad, Guardarropas guardarropas)
	+Guardarropas getGuardarropa()
	+Atuendo sugerirAtuendo(AdapterDeClima adapter)
	+void enviarProposicion(Usuario usuario, Proposicion proposicion)
	+void recibirProposicion(Proposicion proposicion)
	+void aceptarProposicion(Proposicion proposicion)
	+void rechazarProposicion(Proposicion proposicion)
	+void deshacerProposicionAceptada(Proposicion proposicion)
}
class Guardarropas [[java:Model.Guardarropas]] {
}
Usuario --> "1" Guardarropas : guardarropas
class Proposicion [[java:Model.Proposicion]] {
}
Usuario --> "*" Proposicion : proposiciones
class Proposicion [[java:Model.Proposicion]] {
}
Usuario --> "*" Proposicion : proposicionesAceptadas
class Prenda [[java:Model.Prenda]] {
	~int temperaturaMaximaDeUso
	+Prenda(TipoPrenda tipo, Material material, Color colorPrincipal, Color colorSecundario, Trama trama, int temperaturaMaximaDeUso)
	+Categoria getCategoria()
}
class TipoPrenda [[java:Model.TipoPrenda]] {
}
Prenda --> "1" TipoPrenda : tipo
enum Material [[java:Model.Material]] {
}
Prenda --> "1" Material : material
class Color [[java:Model.Color]] {
}
Prenda --> "1" Color : colorPrincipal
class Color [[java:Model.Color]] {
}
Prenda --> "1" Color : colorSecundario
enum Trama [[java:Model.Trama]] {
}
Prenda --> "1" Trama : trama
class Color [[java:Model.Color]] {
	~int nivelVerde
	~int nivelAzul
	~int nivelRojo
	+Color(int i, int j, int k)
}
enum Trama [[java:Model.Trama]] {
	LISA
	RAYADA
	LUNARES
	CUADROS
	ESTAMPADO
}
class AccuWeather [[java:Model.AccuWeather]] {
	+float getProbabilidadDePrecipitacion(String Ciudad)
	+int getTemperaturaActual(String Ciudad)
}
interface AdapterDeClima [[java:Model.AdapterDeClima]] {
}
AdapterDeClima <|.. AccuWeather
interface Validador [[java:Model.Validador]] {
	void validar(TipoPrenda tipo)
}
enum Categoria [[java:Model.Categoria]] {
	PARTE_SUPERIOR
	PARTE_INFERIOR
	CALZADO
	ACCESORIO
}
class ValidadorDeTipo [[java:Model.ValidadorDeTipo]] {
	+void validar(TipoPrenda tipo)
}
interface Validador [[java:Model.Validador]] {
}
Validador <|.. ValidadorDeTipo
interface AdapterDeClima [[java:Model.AdapterDeClima]] {
	int getTemperaturaActual(String ciudad)
	float getProbabilidadDePrecipitacion(String Ciudad)
}
interface GeneradorDeSugerencias [[java:Model.GeneradorDeSugerencias]] {
	Atuendo generarSugerencia(String ciudad, List<Prenda> prendasDisponibles)
}
class AgregarPrenda [[java:Model.AgregarPrenda]] {
	+void aceptar(Guardarropas guardarropas)
	+void rechazar()
	+void hacerInversa(Guardarropas guardarropas)
}
class Prenda [[java:Model.Prenda]] {
}
AgregarPrenda --> "1" Prenda : prenda
interface Proposicion [[java:Model.Proposicion]] {
}
Proposicion <|.. AgregarPrenda
class MockAccuWeather [[java:Model.MockAccuWeather]] {
	+int getTemperaturaActual(String ciudad)
	+float getProbabilidadDePrecipitacion(String Ciudad)
}
interface AdapterDeClima [[java:Model.AdapterDeClima]] {
}
AdapterDeClima <|.. MockAccuWeather
class BuilderAtuendo [[java:Model.BuilderAtuendo]] {
	+void agregarPrenda(Prenda prenda)
	+void validarPrendaCompleta()
	+Atuendo crearAtuendo()
}
class Prenda [[java:Model.Prenda]] {
}
BuilderAtuendo --> "*" Prenda : prendas
class RopaDeViaje [[java:Model.RopaDeViaje]] {
	+RopaDeViaje(List<Prenda> listaDePrendas)
}
class Guardarropas [[java:Model.Guardarropas]] {
}
Guardarropas <|-- RopaDeViaje
class GeneradorDeSugerenciasSegunPrecipitacion [[java:Model.GeneradorDeSugerenciasSegunPrecipitacion]] {
	+GeneradorDeSugerenciasSegunPrecipitacion(AdapterDeClima adapterClima)
	+Atuendo generarSugerencia(String ciudad, List<Prenda> prendasDisponibles)
}
Interface AdapterDeClima [[java:Model.AdapterDeClima]] {
}
GeneradorDeSugerenciasSegunPrecipitacion --> "1" AdapterDeClima : adapterClima
interface GeneradorDeSugerencias [[java:Model.GeneradorDeSugerencias]] {
}
GeneradorDeSugerencias <|.. GeneradorDeSugerenciasSegunPrecipitacion
enum Material [[java:Model.Material]] {
	ALGODON
	LAICRA
	NEOPRENE
}
class QuitarPrenda [[java:Model.QuitarPrenda]] {
	+void aceptar(Guardarropas guardarropas)
	+void rechazar()
	+void hacerInversa(Guardarropas guardarropas)
}
class Prenda [[java:Model.Prenda]] {
}
QuitarPrenda --> "1" Prenda : prenda
interface Proposicion [[java:Model.Proposicion]] {
}
Proposicion <|.. QuitarPrenda
class GeneradorDeSugerenciasSegunTemperatura [[java:Model.GeneradorDeSugerenciasSegunTemperatura]] {
	+GeneradorDeSugerenciasSegunTemperatura(AdapterDeClima adapterDeClima)
	+Atuendo generarSugerencia(String ciudad, List<Prenda> prendasDisponibles)
	+Atuendo armarAtuendoASugerir(List<Prenda> sugerencia)
}
Interface AdapterDeClima [[java:Model.AdapterDeClima]] {
}
GeneradorDeSugerenciasSegunTemperatura --> "1" AdapterDeClima : adapterClima
interface GeneradorDeSugerencias [[java:Model.GeneradorDeSugerencias]] {
}
GeneradorDeSugerencias <|.. GeneradorDeSugerenciasSegunTemperatura
class Guardarropas [[java:Model.Guardarropas]] {
	+List<Prenda> getPrendas()
	+void agregarPrenda(Prenda prenda)
	+void removerPrenda(Prenda prenda)
	+Guardarropas(List<Prenda> listaDePrendas)
}
class Prenda [[java:Model.Prenda]] {
}
Guardarropas --> "*" Prenda : prendas
class BuilderPrenda [[java:Model.BuilderPrenda]] {
	~int temperaturaMaximaDeUso
	+void setTipo(TipoPrenda tipo)
	+void setMaterial(Material material)
	+void setColorPrincipal(Color colorPrincipal)
	+void setColorSecundario(Color colorSecundario)
	+void setTrama(Trama trama)
	+void setTemperaturaMaximaDeUso(int temperaturaMaximaDeUso)
	+Prenda crearPrenda()
	+void setearTramaPorDefecto()
}
class TipoPrenda [[java:Model.TipoPrenda]] {
}
BuilderPrenda --> "1" TipoPrenda : tipo
enum Material [[java:Model.Material]] {
}
BuilderPrenda --> "1" Material : material
class Color [[java:Model.Color]] {
}
BuilderPrenda --> "1" Color : colorPrincipal
class Color [[java:Model.Color]] {
}
BuilderPrenda --> "1" Color : colorSecundario
enum Trama [[java:Model.Trama]] {
}
BuilderPrenda --> "1" Trama : trama
enum TipoPrenda [[java:Model.TipoPrenda]] {
	ZAPATO
	ZAPATILLA
	CAMISA
	REMERA
	BLUSA
	POLLERA
	PANTALON
	SOMBRERO
	ANTEOJOS
	~TipoPrenda(Categoria categoria)
	+Categoria getCategoria()
}
enum Categoria [[java:Model.Categoria]] {
}
TipoPrenda --> "1" Categoria : categoria
class Atuendo [[java:Model.Atuendo]] {
	+List<Prenda> getPrendas()
	+Atuendo(List<Prenda> prendas)
}
class Prenda [[java:Model.Prenda]] {
}
Atuendo --> "*" Prenda : prendas
@enduml
*/