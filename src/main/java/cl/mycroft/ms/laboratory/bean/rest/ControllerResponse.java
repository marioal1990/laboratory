package cl.mycroft.ms.laboratory.bean.rest;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
public class ControllerResponse implements Serializable {

    private int code;
    private String message;
}
