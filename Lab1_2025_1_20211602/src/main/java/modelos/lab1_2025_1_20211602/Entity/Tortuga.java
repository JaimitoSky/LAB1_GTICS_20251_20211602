package modelos.lab1_2025_1_20211602.Entity;

public class Tortuga {
    private String nombre;
    private double velocidad; // V
    private double resistencia; // R
    private double suerte; // S



    public Tortuga(String nombre, double velocidad, double resistencia, double suerte) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.resistencia = resistencia;
        this.suerte = suerte;
    }
    public void generarAtributosAleatorios() {
        this.velocidad = (int)(Math.random() * 5) + 1;
        this.resistencia = (int)(Math.random() * 5) + 1;
        this.suerte = (int)(Math.random() * 5) + 1;
    }


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getVelocidad() { return velocidad; }
    public void setVelocidad(double velocidad) { this.velocidad = velocidad; }
    public double getResistencia() { return resistencia; }
    public void setResistencia(double resistencia) { this.resistencia = resistencia; }
    public double getSuerte() { return suerte; }
    public void setSuerte(double suerte) { this.suerte = suerte; }

    public double calcularDesempeno() {
        return (velocidad * 1.5) + (resistencia * 1.2) + (Math.random() * suerte);
    }
}
