package Model;
import Exceptions.PrendaSinTipoException;

public class ValidadorDeTipo implements Validador {

	@Override
	public void validar(TipoPrenda tipo) {
		if(tipo == null)
			throw new PrendaSinTipoException();
	}

}
