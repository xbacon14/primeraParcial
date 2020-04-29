package py.edu.facitec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.edu.facitec.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
