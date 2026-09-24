package cl.mycroft.ms.laboratory.bean.exception;

import org.springframework.http.HttpStatus;

public class ApiRestNotFoundException extends ApiException {

    public ApiRestNotFoundException(String host, String getList) {
        super(String.format("No se pudo conectar al API GET %s%s", host, getList), HttpStatus.NOT_FOUND);
    }
}