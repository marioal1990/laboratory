package cl.mycroft.ms.laboratory.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    private Long id;
    private String sku;
    private String nombre;
    private int stock;
    private Double precio;
}
