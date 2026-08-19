package cl.mycroft.ms.laboratory.service.impl;

import cl.mycroft.ms.laboratory.model.entity.Producto;
import cl.mycroft.ms.laboratory.model.repository.ProductoRepository;
import cl.mycroft.ms.laboratory.service.ProductoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> getList() {
        return (List<Producto>) this.productoRepository.findAll();
    }

    @Override
    public Optional<Producto> getById(String id) {
        return this.productoRepository.findBySku(id);
    }

    @Override
    public Optional<Producto> getByFilter(String filter) {
        return Optional.empty();
    }

    @Override
    public Optional<Producto> getByFilter(String filter, int page, int pageSize) {
        return Optional.empty();
    }

    @Override
    public Optional<Producto> insert(String object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Producto producto = mapper.readValue(object, Producto.class);
        return Optional.of(this.productoRepository.save(producto));
    }

    @Override
    public Optional<Producto> update(String object) {
        return Optional.empty();
    }

    @Override
    public void delete(String id) {
        log.info("delete");
    }
}
