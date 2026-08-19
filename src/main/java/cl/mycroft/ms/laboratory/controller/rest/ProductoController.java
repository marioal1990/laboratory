package cl.mycroft.ms.laboratory.controller.rest;

import cl.mycroft.ms.laboratory.bean.rest.ControllerResponse;
import cl.mycroft.ms.laboratory.model.entity.Producto;
import cl.mycroft.ms.laboratory.service.ProductoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping(value = "/productos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ControllerResponse> getProductos() {
        log.info("GET productos");
        ControllerResponse controllerResponse = new ControllerResponse();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Producto> lista = this.productoService.getList();
            String response = objectMapper.writeValueAsString(lista);
            controllerResponse.setCode(HttpStatus.OK.value());
            controllerResponse.setMessage(response);
        } catch (Exception e) {
            controllerResponse = new ControllerResponse();
            controllerResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            controllerResponse.setMessage(e.getMessage());
        }
        return new ResponseEntity<>(controllerResponse, HttpStatus.valueOf(controllerResponse.getCode()));
    }


}
