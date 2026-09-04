package cl.mycroft.ms.laboratory.service;

import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

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
}
