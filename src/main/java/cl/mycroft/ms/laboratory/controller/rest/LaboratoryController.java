package cl.mycroft.ms.laboratory.controller.rest;

import cl.mycroft.ms.laboratory.bean.dto.ControllerRequest;
import cl.mycroft.ms.laboratory.bean.dto.ControllerResponse;
import cl.mycroft.ms.laboratory.service.LaboratoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/laboratory")
public class LaboratoryController {

    private final LaboratoryService laboratoryService;

    @Autowired
    public LaboratoryController(final LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    /**
     * Example controller method that get string message with input param names 'name'
     * @param request Object that obtain the value called "name"
     * @return Object String with the message 'Hello World {"name"}'
     */
    @PostMapping(value = "/example",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ControllerResponse> example(@RequestBody @Valid ControllerRequest request) {
        log.info("requests: {}", request.toString());
        ControllerResponse controllerResponse;
        try {
            String response = laboratoryService.example(request.name());
            controllerResponse = new ControllerResponse(HttpStatus.OK.value(), response);
        } catch (Exception e) {
            controllerResponse = new ControllerResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        }
        return new ResponseEntity<>(controllerResponse, HttpStatus.valueOf(controllerResponse.code()));
    }
}
