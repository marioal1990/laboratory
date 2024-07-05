package cl.mycroft.ms.laboratory.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LaboratoryServiceTest {

    @InjectMocks
    private LaboratoryService laboratoryService;

    @Test
    void example() {
        String input = "mami dika";
        String esperado = "Hello World mami dika";
        String resultado = laboratoryService.example(input);
        assertEquals(esperado, resultado);
    }

    @Test
    void exampleIllegalArgumentException() {
        String messageException = "Propiedad name está vacia";
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> laboratoryService.example(""), "Propiedad name está vacia");
        assertTrue(exception.getMessage().contains(messageException));
    }
}