package ActividadHerencia;

public class JefeProyecto extends Empleado{
    private int numeroProyectos;

    public JefeProyecto(String nombre, String dni, double salarioBase) {
        super(nombre, dni, salarioBase);
    }

    public int getNumeroProyectos() {
        return numeroProyectos;
    }

    public void setNumeroProyectos(int numeroProyectos) {
        this.numeroProyectos = numeroProyectos;
    }

    @Override
    public double calcularSalario() {
        return super.getSalarioBase() + 300 * numeroProyectos;
    }

    @Override
    public String toString() {
        return "(" + super.getDni() + ") " + super.getNombre() + ", jefe de " + this.getNumeroProyectos() + " proyectos.";
    }
}
