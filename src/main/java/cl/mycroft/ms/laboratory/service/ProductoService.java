package cl.mycroft.ms.laboratory.service;

import cl.mycroft.ms.laboratory.bean.Producto;
import cl.mycroft.ms.laboratory.bean.exception.ApiRestNotFoundException;

import java.util.List;

public interface ProductoService {

    List<Producto> getList() throws ApiRestNotFoundException;
}
