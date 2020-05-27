import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Model.*;
import Exceptions.*;



public class TestDeAtuendo {
	private BuilderPrenda builderPrenda;
	private Prenda prendaNueva;
	private Atuendo atuendo;
	private BuilderAtuendo builderAtuendo;
	private Usuario user;
	List<Prenda> listaDePrendas = new ArrayList<>();
	
	
	@Before
	public void init() {
		builderPrenda = new BuilderPrenda();
		builderAtuendo = new BuilderAtuendo();
		listaDePrendas.add(new Prenda(TipoPrenda.ZAPATO,Material.LAICRA,new Color(255,20,20),null,Trama.CUADROS,30));
		listaDePrendas.add(new Prenda(TipoPrenda.ANTEOJOS,Material.NEOPRENE,new Color(255,22,20),null,Trama.CUADROS,40));
		listaDePrendas.add(new Prenda(TipoPrenda.REMERA,Material.ALGODON,new Color(255,20,30),null,Trama.LISA,20));
		listaDePrendas.add(new Prenda(TipoPrenda.REMERA,Material.NEOPRENE,new Color(255,20,30),null,Trama.LISA,30));
		listaDePrendas.add(new Prenda(TipoPrenda.PANTALON,Material.LAICRA,new Color(255,25,20),new Color(20,100,40),Trama.RAYADA,28));
		user = new Usuario("Buenos Aires, Argentina", listaDePrendas);
		
		builderAtuendo.agregarPrenda(new Prenda(TipoPrenda.ZAPATO,null,null,null,null,0));//por defecto tiene un zapato
	}
	
	@Test(expected = PrendaDeEsaCategoriaYaExisteException.class)
	public void noSePuedeAgregarUnaPrendaDeLaMismaCategoria() {
		
		builderPrenda.setTipo(TipoPrenda.ZAPATO);
		builderPrenda.setColorPrincipal(new Color(20,20,20));
		builderPrenda.setMaterial(Material.LAICRA);
		builderPrenda.setTrama(Trama.CUADROS);
		prendaNueva = builderPrenda.crearPrenda();
		
		builderAtuendo.agregarPrenda(prendaNueva);
	}
	@Test(expected = PrendaIncompletaException.class)
	public void noTieneDeTodasLasCategoriasAntesDeCrearse() {
		builderAtuendo.crearAtuendo();
	}
	
	@Test
	public void usuarioPideSugerenciaDePrendas() {
		List<Prenda> cloned_list = new ArrayList<Prenda>(user.getGuardarropa());
		cloned_list.remove(2);//remuevo la prenda que no deberia ser sugerida
		
		Assert.assertEquals(cloned_list, user.sugerirAtuendo(new MockAccuWeather()).getPrendas());
	}
	
}
