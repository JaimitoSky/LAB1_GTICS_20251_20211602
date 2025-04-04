package modelos.lab1_2025_1_20211602.Entity;

public class Resultado {
    private String nombreGanador;
    private boolean gano;
    private double montoFinal;

    public Resultado(String nombreGanador, boolean gano, double montoFinal) {
        this.nombreGanador = nombreGanador;
        this.gano = gano;
        this.montoFinal = montoFinal;
    }

    public String getNombreGanador() { return nombreGanador; }
    public boolean isGano() { return gano; }
    public double getMontoFinal() { return montoFinal; }
}
