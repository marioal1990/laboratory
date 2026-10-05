package cl.mycroft.ms.laboratory.service;

import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.function.ToIntFunction;

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
}
