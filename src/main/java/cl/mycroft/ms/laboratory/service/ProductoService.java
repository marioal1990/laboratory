package cl.mycroft.ms.laboratory.service;

import cl.mycroft.ms.laboratory.model.entity.Producto;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> getList();

    Optional<Producto> getById(String id);

    Optional<Producto> getByFilter(String filter);
    Optional<Producto> getByFilter(String filter, int page, int pageSize);

    Optional<Producto> insert(String object) throws JsonProcessingException;
    Optional<Producto> update(String object);
    void delete(String id);
}
