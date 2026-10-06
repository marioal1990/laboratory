package cl.mycroft.ms.laboratory.service.impl;

import cl.mycroft.ms.laboratory.bean.Producto;
import cl.mycroft.ms.laboratory.bean.dto.ControllerResponse;
import cl.mycroft.ms.laboratory.bean.exception.ApiRestNotFoundException;
import cl.mycroft.ms.laboratory.service.ProductoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@Slf4j
@Service
public class ProductoServiceImpl implements ProductoService {

    @Value("${msproductos.url.host}")
    private String host;

    @Value("${msproductos.url.get.getList}")
    private String getList;

    @Override
    public List<Producto> getList() throws ApiRestNotFoundException {
        log.debug("ProductoService.getList()");

        log.info("Calling REST GET {}", host + getList);

        WebClient webClient = WebClient.create(host);
        String response;
        try {
            response = webClient.get()
                    .uri(getList)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ObjectMapper mapper = new ObjectMapper();
            ControllerResponse controllerResponse = mapper.readValue(response, ControllerResponse.class);
            return mapper.readValue(controllerResponse.message(), new  TypeReference<>() {});
        } catch (RuntimeException e) {
            log.error("No se pudo conectar al API GET {}{}", host, getList);
            throw new ApiRestNotFoundException(host, getList);
        } catch (JsonProcessingException e) {
            log.error("No se pudo mapear respuesta de API GET {}{} a JSON", host, getList);
            throw new ApiRestNotFoundException(host, getList);
        }
    }
}
