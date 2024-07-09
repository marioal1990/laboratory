package cl.mycroft.ms.laboratory.controller;

import cl.mycroft.ms.laboratory.bean.ControllerRequest;
import cl.mycroft.ms.laboratory.bean.ControllerResponse;
import cl.mycroft.ms.laboratory.service.LaboratoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/main")
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
    @RequestMapping(value = "/example", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ControllerResponse> example(@RequestBody @Valid ControllerRequest request) {
        log.info("requests: {}", request.toString());
        ControllerResponse controllerResponse;
        try {
            String response = laboratoryService.example(request.getName());
            controllerResponse = new ControllerResponse();
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
