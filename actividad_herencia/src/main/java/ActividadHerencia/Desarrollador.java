package ActividadHerencia;

public class Desarrollador extends Empleado {
    private String lenguajePrincipal;
    private Nivel nivel;

    public Desarrollador(String nombre, String dni, double salarioBase) {
        super(nombre, dni, salarioBase);
    }

    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    public void setLenguajePrincipal(String lenguajePrincipal) {
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    @Override
    public double calcularSalario() {
        double salario;
        switch (nivel){
            case JUNIOR -> salario = super.getSalarioBase();
            case MID -> salario = super.getSalarioBase() + (super.getSalarioBase() * 0.1);
            default -> salario = super.getSalarioBase() +  (super.getSalarioBase() * 0.25);
            }
            return salario;
    }

    @Override
    public String toString() {
        return "(" + super.getDni() + ") " + super.getNombre() + ", desarrollador " + this.getLenguajePrincipal() + ".";
    }
}
