package py.edu.facitec.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "PRODUCTOS")
public class Producto extends General {

	private String descripcion;
	private Double precio;

	@ManyToOne
	@JsonBackReference(value = "pp")
	@JoinColumn(name = "pedidos_id")
	private Pedido pedido;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "Producto [descripcion=" + descripcion + ", precio=" + precio + ", pedido=" + pedido + "]";
	}

}
