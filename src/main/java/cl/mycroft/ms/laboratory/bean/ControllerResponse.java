package cl.mycroft.ms.laboratory.bean;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
public class ControllerResponse implements Serializable {

    private int code;
    private String message;
}
