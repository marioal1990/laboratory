package cl.mycroft.ms.laboratory.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ControllerRequest implements Serializable {

    private String name;
}
