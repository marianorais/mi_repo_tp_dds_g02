package DatosDePersonas;

import lombok.Getter;
import lombok.Setter;

public class Calle {
    @Getter
    @Setter
    private String calle;

    public Calle(String calle) {
        this.calle =calle;
    }
}
