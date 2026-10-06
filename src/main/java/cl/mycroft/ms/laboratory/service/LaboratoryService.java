package cl.mycroft.ms.laboratory.service;

import cl.mycroft.ms.laboratory.bean.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;

@Slf4j
@Service
public class LaboratoryService {

    /**
     * Example method, this recieve string param and return the same with Hello World message
     * @param name String input param
     * @return String message with Hello World more the input string param
     */
    public String example(String name) {
        if (!StringUtils.isNotEmpty(name)) {
            throw new IllegalArgumentException("Propiedad name está vacia");
        }

        name = switch (name) {
            case "consumer", "Consumer", "CONSUMER", "consumir" -> addNameToListAndPrintCustomers(name);
            case "lista", "Lista", "LISTA" -> addNameToListCustomerToJson(name);
            case "function", "Function", "FUNCTION" -> calculaNameConFunction(name).toString();
            case "A", "B" -> "primeras 2 letras";
            case "C", "D" -> "segundas 2 letras";
            case "SQL" -> """
                        SELECT * FROM example
                        """;
            case "JSON" -> """
                        {
                         "code": 200,
                         "mensaje": "mensaje de respuesta"
                        }
                        """;
            case "HTML" -> """
                    <html>
                      <body>
                        <h2>EXAMPLE HTML</h2>
                      </body>
                    </html>
                    """;
            default -> name;
        };

        return String.format("Hello World %s", name);
    }

    private Integer calculaNameConFunction(String name) {
        String entrada = "Esto es un ejemplo de entrada y que junto al valor de name es %s";
        ToIntFunction<String> resultado = String::length;
        return resultado.applyAsInt(String.format(entrada, name));
    }

    private String addNameToListCustomerToJson(String name) {
        List<String> names = List.of("A", "B", "C", "D", "SQL", "JSON", "HTML", name);
        List<Customer> customers = names.stream().map(Customer::new).toList();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(customers);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private String addNameToListAndPrintCustomers(String name) {
        List<String> names = List.of("A", "B", "C", "D", "SQL", "JSON", "HTML", name);
        Consumer<String> customName = log::info;
        names.forEach(customName);
        return "Mira el LOG";
    }
}
