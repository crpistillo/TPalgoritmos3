package unidades;
import juego.*;
import mapa.excepcionesMapa.*;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import mapa.*;
import edificios.*;
import excepciones.superaLimitePoblacional;


public class AldeanoTest {

	private Mapa mapa;
	private int filaDet;
	private int columnaDet;
	private Casillero celda;
	private Jugador jugador;
	Casillero casilleroMock = Mockito.mock(Casillero.class);
    Caja cajaMock = Mockito.mock(Caja.class);
    Mapa mapaMock =  Mockito.mock(Mapa.class);
    Jugador jugadorMock =  Mockito.mock(Jugador.class);
    


	public AldeanoTest() throws tamanioDeMapaInvalido {
		mapa = new Mapa(15, 15);
		filaDet = 3;
		columnaDet = 3;
		jugador = new Jugador();
	}


	@Test
	public void seCreoAldeanoConCoordenadas() throws casilleroEstaOcupado {

		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa);
		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seCreoAldeanoConCasillero() throws casilleroEstaOcupado {

		celda = mapa.obtenerCasillero(filaDet, columnaDet);
		Aldeano aldeano = new Aldeano(celda);
		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente1() throws casilleroEstaOcupado {

		// y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet + 1, columnaDet));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente2() throws casilleroEstaOcupado {

		// y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet - 1, columnaDet));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente3() throws casilleroEstaOcupado {

		// x+1
		celda = mapa.obtenerCasillero(filaDet, columnaDet + 1);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet, columnaDet + 1));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente4() throws casilleroEstaOcupado {

		// x-1
		celda = mapa.obtenerCasillero(filaDet, columnaDet - 1);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet, columnaDet - 1));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente5() throws casilleroEstaOcupado {

		// x-1 y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet - 1);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet - 1, columnaDet - 1));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente6() throws casilleroEstaOcupado {

		// x+1 y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet + 1);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet + 1, columnaDet + 1));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente7() throws casilleroEstaOcupado {

		// x+1 y-1
		celda = mapa.obtenerCasillero(filaDet - 1, columnaDet + 1);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet - 1, columnaDet + 1));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test
	public void seMueveCorrectamente8() throws casilleroEstaOcupado {

		// x-1 y+1
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet - 1);
		Aldeano aldeano = new Aldeano(filaDet, columnaDet, mapa);
		aldeano.mover(celda);

		Assert.assertEquals(aldeano, mapa.obtenerElemento(filaDet + 1, columnaDet - 1));
		Assert.assertNotSame(aldeano, mapa.obtenerElemento(filaDet, columnaDet));

	}

	@Test(expected = casilleroEstaOcupado.class)

	public void seCreaEnLugarOcupadoPorUnidadLanzaExcepcion() throws casilleroEstaOcupado {
		celda = mapa.obtenerCasillero(filaDet, columnaDet);
		Aldeano aldeano = new Aldeano(celda);
		Aldeano aldeanoBis = new Aldeano(celda);


	}

	@Test(expected = casilleroEstaOcupado.class)
	public void seMueveAUnLugarOcupadoPorUnidadLanzaExcepcion() throws casilleroEstaOcupado {
		celda = mapa.obtenerCasillero(filaDet + 1, columnaDet + 1);
		Casillero celdaBis = mapa.obtenerCasillero(filaDet, columnaDet);

		Aldeano aldeano = new Aldeano(celda);
		Aldeano aldeanoBis = new Aldeano(celdaBis);

		aldeanoBis.mover(celda);

	}

	@Test(expected = casilleroEstaOcupado.class)
	public void seCreaEnUnLugarOcupadoPorEdificioLanzaExcepcion() throws casilleroEstaOcupado,
			casilleroInvalido, cajaEstaOcupada, superaLimitePoblacional {
		//creo el edificio
		celda = mapa.obtenerCasillero(6, 6);
		Caja caja = mapa.asignarCajaACasillero(celda);
		Cuartel cuartel = new Cuartel(caja, this.mapa, this.jugador);

		// el edificio va a estar en 6,6 6,7 7,6 y 7,7
		Aldeano aldeano = new Aldeano(mapa.obtenerCasillero(6, 7));


	}

	@Test(expected = casilleroEstaOcupado.class)
	public void seMueveAUnLugarOcupadoPorEdificioLanzaExcepcion() throws casilleroEstaOcupado,
			casilleroInvalido, cajaEstaOcupada, superaLimitePoblacional {
		//creo el edificio
		celda = mapa.obtenerCasillero(6, 6);
		Caja caja = mapa.asignarCajaACasillero(celda);
		Cuartel cuartel = new Cuartel(caja, this.mapa, jugador);

		// el edificio va a estar en 6,6 6,7 7,6 y 7,7
		Aldeano aldeano = new Aldeano(mapa.obtenerCasillero(5, 5));
		aldeano.mover(celda);


	}

	@Test
	public void aldeanoComienzaAConstruirPlaza() throws casilleroEstaOcupado,casilleroInvalido,
															superaLimitePoblacional,cajaEstaOcupada
	{
		Aldeano aldeano = new Aldeano(this.casilleroMock);
		
		aldeano.construirPlazaCentral(this.cajaMock, this.mapaMock, this.jugadorMock);

		Assert.assertFalse(aldeano.obtenerEdificioEnConstruccion() == null);
	}

	@Test
    public void aldeanoConstruyendoEstaTrabajando() throws cajaEstaOcupada, superaLimitePoblacional, casilleroEstaOcupado
    {
		 
	     Aldeano aldeano = new Aldeano(this.casilleroMock);
	     
	     aldeano.construirPlazaCentral(this.cajaMock, this.mapaMock, this.jugadorMock);
	        
	     Assert.assertTrue(aldeano.trabajando == true);
    }
 
 @Test
    public void aldeanoConstruyendoNoProduceOro() throws casilleroInvalido, cajaEstaOcupada, superaLimitePoblacional
    {
        
        Aldeano aldeanoMock = Mockito.mock(Aldeano.class);
        aldeanoMock.construirPlazaCentral(this.cajaMock, this.mapaMock, this.jugadorMock);
        
        Mockito.verify(aldeanoMock, Mockito.times(0)).recolectarOro();
        
    }
}
