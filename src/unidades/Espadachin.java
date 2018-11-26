package unidades;

import excepciones.SuperaLimitePoblacional;
import jugador.Jugador;
import mapa.Casillero;
import mapa.Mapa;
import mapa.excepcionesMapa.casilleroEstaOcupado;

public class Espadachin extends Militar {

	
	public Espadachin (int fila, int columna, Mapa mapa) throws casilleroEstaOcupado {
		
		super (fila, columna, mapa);
		this.costo = 50;
        this.vida = 100;
        this.danioAUnidades = 25;
        this.danioAEdificios = 15;
        this.radioAtaque = 1;	
}

	public Espadachin (int fila, int columna, Mapa mapa, Jugador jugador) throws casilleroEstaOcupado, SuperaLimitePoblacional {
		
		super (fila, columna, mapa);
		this.costo = 50;
        this.vida = 100;
        this.danioAUnidades = 25;
        this.danioAEdificios = 15;
        this.radioAtaque = 1;
        this.jugador = jugador;
        this.jugador.aumentarPoblacion(1);
	}
	
	public Espadachin (Casillero casillero) throws casilleroEstaOcupado
	{
	
		super (casillero);
		this.costo = 50;
        this.vida = 100;
        this.danioAUnidades = 25;
        this.danioAEdificios = 15;
        this.radioAtaque = 1;
		
}
	
	
	
	public void atacar() {
		System.out.println("Ataca a una unidad o edificio");
	}

	
}
