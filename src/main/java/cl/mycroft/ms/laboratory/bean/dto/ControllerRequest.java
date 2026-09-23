package cl.mycroft.ms.laboratory.bean.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ControllerRequest(String name) {

}
