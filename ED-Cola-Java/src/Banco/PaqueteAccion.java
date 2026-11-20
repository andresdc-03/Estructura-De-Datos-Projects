package Banco;

public class PaqueteAccion {
	
	// Atributos
	private int Nacciones; // Numero de acciones
	private String fechaCompra; // Mes
	private int precioAccionCompra; // Precio una unidad
	
	// Metodo constructor 
	public PaqueteAccion(int Nacciones, String fechaCompra, int precioAccion) {
		this.Nacciones=Nacciones;
		this.fechaCompra=fechaCompra;
		this.precioAccionCompra=precioAccion;
	}
	
/* 
 ********************************
 * 
 *      Getters and Setters
 *  
 ********************************
 */
	public int getNacciones() {
		return Nacciones;
	}
	public void setNacciones(int Nacciones) {
		this.Nacciones=Nacciones;
	}
	
	//getters y setters fechaComrpa
	public String getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra=fechaCompra;
	}
	
	//getters y setters precioAccion
	public int getPrecioAccion() {
		return precioAccionCompra;
	}
	public void setPrecioAccion(int precioAccion) {
		this.precioAccionCompra=precioAccion;
	}

	// Para imprimir todos los datos el lenguaje legible
	@Override
	public String toString() {
		return "Numero de acciones: " + Nacciones +
			", Fecha de compra: " + fechaCompra +
			", Precio por accion: " + precioAccionCompra + " euros";
	}

}