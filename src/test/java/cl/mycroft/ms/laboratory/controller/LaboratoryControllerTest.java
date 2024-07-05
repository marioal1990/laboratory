package cl.mycroft.ms.laboratory.controller;

import cl.mycroft.ms.laboratory.bean.ControllerRequest;
import cl.mycroft.ms.laboratory.bean.ControllerResponse;
import cl.mycroft.ms.laboratory.service.LaboratoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LaboratoryControllerTest {

    @InjectMocks
    private LaboratoryController laboratoryController;

    @Mock
    private LaboratoryService laboratoryService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void exampleSucess() {
        ControllerRequest request = new ControllerRequest();
        request.setName("mami dika");
        when(laboratoryService.example(anyString())).thenReturn("Hello World mami dika");
        ResponseEntity<ControllerResponse> responseEntity = laboratoryController.example(request);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Hello World mami dika", Objects.requireNonNull(responseEntity.getBody()).getMessage());
    }

    @Test
    void exampleFailure() {
        ControllerRequest request = new ControllerRequest();
        request.setName("mami dika");
        when(laboratoryService.example(anyString())).thenThrow(new RuntimeException("Service Error"));
        ResponseEntity<ControllerResponse> responseEntity = laboratoryController.example(request);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("Service Error", Objects.requireNonNull(responseEntity.getBody()).getMessage());
    }
}