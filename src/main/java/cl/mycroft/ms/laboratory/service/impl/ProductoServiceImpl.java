package cl.mycroft.ms.laboratory.service.impl;

import cl.mycroft.ms.laboratory.bean.rest.ControllerResponse;
import cl.mycroft.ms.laboratory.model.repository.ProductoRepository;
import cl.mycroft.ms.laboratory.service.ProductoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    /**
     * Obtener lista de Productos
     * @return
     */
    @Override
    public String getList() {
        try {
            return new ObjectMapper().writeValueAsString(this.productoRepository.findAll());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al cargar productos de la lista", e);
        }
    }

    /**
     * Método que busca producto por SKU
     * @param id El SKU del producto
     * @return
     */
    @Override
    public String getListById(String id) {
        try {
            return new ObjectMapper().writeValueAsString(this.productoRepository.getProductosBySku(id));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al cargar productos con el SKU: " + id, e);
        }
    }

    @Override
    public String getListByFilter(String filter) {
        return "";
    }

    @Override
    public String getListByFilter(String filter, int page, int pageSize) {
        return "";
    }

    @Override
    public String insert(String object) {
        return "";
    }

    @Override
    public String update(String object) {
        return "";
    }

    @Override
    public String delete(String id) {
        return "";
    }
}
