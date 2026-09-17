package ActividadHerencia;

public class Comercial extends Empleado {
    private double ventasRealizadas;
    private double porcentajeComision;

    public Comercial(String nombre, String dni, double salarioBase) {
        super(nombre, dni, salarioBase);
    }

    public double getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(int ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public double calcularSalario() {
        return super.getSalarioBase() + (ventasRealizadas * (porcentajeComision / 100));
    }

    @Override
    public String toString() {
        return "(" + super.getDni() + ") " + super.getNombre() + ", comercial.";
    }
}
