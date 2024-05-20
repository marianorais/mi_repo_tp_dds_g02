package Colaboradores;

public class Colaboraciones {
    private Integer pesosDonados;
    private Integer viandasDistribuidas;
    private Integer viandasDonadas;
    private Integer tarjetasRepartidas;
    private Integer cantidadHeladerasActivas;
    private Integer mesesActivas;
    private Double coefPesosDonados;
    private Double coefViandasDistribuidas;
    private Double coefViandasDonadas;
    private Double coefTarjetasRepartidas;
    private Double coefCantiadHeladerasActivas;
    private Double puntosCanjeados;

    public double calcularPuntajeTotal(){
        return (pesosDonados *coefPesosDonados)+
                (viandasDistribuidas * coefViandasDistribuidas)+
                (viandasDonadas * coefViandasDonadas)+
                (tarjetasRepartidas * coefTarjetasRepartidas)+
                (cantidadHeladerasActivas * mesesActivas * coefCantiadHeladerasActivas)-
                puntosCanjeados;
    }

    public void setCoefPesosDonados(Double coefPesosDonados) {
        this.coefPesosDonados = coefPesosDonados;
    }

    public void setCoefCantiadHeladerasActivas(Double coefCantiadHeladerasActivas) {
        this.coefCantiadHeladerasActivas = coefCantiadHeladerasActivas;
    }

    public void setCoefTarjetasRepartidas(Double coefTarjetasRepartidas) {
        this.coefTarjetasRepartidas = coefTarjetasRepartidas;
    }

    public void setCoefViandasDonadas(Double coefViandasDonadas) {
        this.coefViandasDonadas = coefViandasDonadas;
    }

    public void setCoefViandasDistribuidas(Double coefViandasDistribuidas) {
        this.coefViandasDistribuidas = coefViandasDistribuidas;
    }

    public void setPuntosCanjeados(Double puntosCanjeados) {
        this.puntosCanjeados = puntosCanjeados;
    }
}
