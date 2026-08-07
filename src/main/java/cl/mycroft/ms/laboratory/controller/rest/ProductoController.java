package cl.mycroft.ms.laboratory.controller.rest;

import cl.mycroft.ms.laboratory.bean.rest.ControllerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {

    @GetMapping(value = "/productos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ControllerResponse> getProductos() {
        log.info("GET productos");
        ControllerResponse controllerResponse = new ControllerResponse();
        try {
            String response = "";
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
