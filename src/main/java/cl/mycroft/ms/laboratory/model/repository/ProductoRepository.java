package cl.mycroft.ms.laboratory.model.repository;

import cl.mycroft.ms.laboratory.model.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

    Producto getProductosBySku(String sku);
}
