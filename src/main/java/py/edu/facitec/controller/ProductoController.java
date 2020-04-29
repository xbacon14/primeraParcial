package py.edu.facitec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Producto;
import py.edu.facitec.repository.ProductoRepository;

@RestController
@CrossOrigin
@RequestMapping({ "/producto" })

public class ProductoController {

	@Autowired
	private ProductoRepository productoRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Producto> getProductos() {
		List<Producto> lista = productoRepository.findAll();
		return lista;
	}

	@PostMapping("/guardar")
	public ResponseEntity<Producto> guardar(@RequestBody Producto producto) {
		producto = productoRepository.save(producto);
		return ResponseEntity.ok(producto);
	}
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.DELETE)
	public ResponseEntity<Long> delete(@RequestParam long id) {
		productoRepository.deleteById(id);
		return ResponseEntity.ok(id);
	}

}
