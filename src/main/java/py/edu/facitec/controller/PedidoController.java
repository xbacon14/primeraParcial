package py.edu.facitec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Pedido;
import py.edu.facitec.repository.PedidoRepository;

@RestController
@CrossOrigin
@RequestMapping({ "/pedido" })

public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public List<Pedido> getPedidos() {
		List<Pedido> lista = pedidoRepository.findAll();
		return lista;
	}

	@PostMapping("/guardar")
	public ResponseEntity<Pedido> guardar(@RequestBody Pedido pedido) {
		pedido = pedidoRepository.save(pedido);
		return ResponseEntity.ok(pedido);
	}
	
	@PutMapping("/actualizar")
	public Pedido updatePedido(@RequestBody Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.DELETE)
	public ResponseEntity<Long> delete(@RequestParam long id) {
		pedidoRepository.deleteById(id);
		return ResponseEntity.ok(id);
	}

}
