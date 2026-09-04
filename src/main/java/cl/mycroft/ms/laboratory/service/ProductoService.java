package cl.mycroft.ms.laboratory.service;

import cl.mycroft.ms.laboratory.bean.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> getList() throws Exception;
}
