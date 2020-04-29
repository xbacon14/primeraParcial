package py.edu.facitec.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PEDIDOS")
public class Pedido extends General {

	private Integer numero;

	private String vendedor;

	@OneToMany(mappedBy = "pedido")
	@JsonManagedReference(value = "pp")
	private List<Producto> productos;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Pedido [numero=" + numero + ", vendedor=" + vendedor + ", productos=" + productos + "]";
	}

}
