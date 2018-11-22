package mapa;

import unidades.Entidad;

public class Casillero extends Mapeable
{
    private boolean estaLibre;
    private Entidad contenido;
    private int fila,columna;

    //Constructor con casillero vacio
    public Casillero ()
    {
        this.estaLibre = true;

    }

    //Constructor con casillero con Entidad
    public Casillero (Entidad entidad)
    {
        this.contenido = entidad;
        this.estaLibre = false;
    }


    public Entidad obtenerElemento()
    {
        return this.contenido;
    }

    public boolean estaLibre ()
    {
        return this.estaLibre;
    }

    public boolean estaOcupado()
    {
        return !this.estaLibre();
    }

    public void vaciar () {
    	
    	this.contenido = null;
    	this.estaLibre = true;
    	
    }
    public void cambiarContenido(Entidad contenido)
    {
        this.contenido = contenido;
        this.estaLibre = false;
    }

    public Fila obtenerFila(Mapa mapa)
    {
        return mapa.obtenerFila(this);
    }

    public Columna obtenerColumna(Mapa mapa)
    {
        return mapa.obtenerColumna(this);
    }
    public int getFila() {
    	return fila;
    }
    
    public int getColumna() {
    	return columna;
    }

	public void setFila(int fila) {
		this.fila = fila;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}
    
    
}
