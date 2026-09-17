package ActividadHerencia;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static void imprimirEmpleados(ArrayList<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
            System.out.println("Salario: " + empleado.calcularSalario());
        }
    }

    public static double calcularCosteTotal(ArrayList<Empleado> empleados) {
        double costeTotal = 0;
        for (Empleado empleado : empleados) {
            costeTotal += empleado.calcularSalario();
        }
        return costeTotal;
    }

    public static Empleado mayorSueldo(ArrayList<Empleado> empleados) {
        double sueldoMax = 0;
        int empleado = 0;
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).calcularSalario() > sueldoMax) {
                sueldoMax = empleados.get(i).calcularSalario();
                empleado = i;
            }
        }
        return empleados.get(empleado);
    }

    public static int contarEmpleados(ArrayList<Empleado> empleados, Nivel nivel) {
        int contador = 0;
        for (int i = 0; i < empleados.size(); i++) {
            if (((empleados.get(i)) instanceof Desarrollador) && ((Desarrollador)empleados.get(i)).getNivel().equals(nivel)){
                contador++;
            }
        }
        return contador;
    }

    public static void filtrarEmpleadosCantidad(ArrayList<Empleado> empleados, int cantidad) {
        for (Empleado empleado : empleados) {
            if (empleado.calcularSalario() > cantidad) {
                System.out.println(empleado);
            }
        }
        System.out.println();
    }

    public static void filtrarDesarrolladores(ArrayList<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            if (empleado instanceof Desarrollador) {
                System.out.println(empleado);
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList<>();

        //Creación de los empleados

        empleados.add(new Desarrollador("Pablo", "12345678A", 1500));
        ((Desarrollador)empleados.get(0)).setNivel(Nivel.JUNIOR);
        ((Desarrollador)empleados.get(0)).setLenguajePrincipal("Java");

        empleados.add(new Desarrollador("Pedro", "87654321Z", 1700));
        ((Desarrollador)empleados.get(1)).setNivel(Nivel.MID);
        ((Desarrollador)empleados.get(1)).setLenguajePrincipal("Python");

        empleados.add(new Desarrollador("Pepe", "12345678B", 2000));
        ((Desarrollador)empleados.get(2)).setNivel(Nivel.SENIOR);
        ((Desarrollador)empleados.get(2)).setLenguajePrincipal("C");

        empleados.add(new Comercial("Andrea", "55555555S", 1700));
        ((Comercial)empleados.get(3)).setVentasRealizadas(15000);
        ((Comercial)empleados.get(3)).setPorcentajeComision(10);

        empleados.add(new Comercial("Ana", "22222222Z", 1800));
        ((Comercial)empleados.get(4)).setVentasRealizadas(20000);
        ((Comercial)empleados.get(4)).setPorcentajeComision(12);

        empleados.add(new JefeProyecto("Alba", "88888888B", 2500));
        ((JefeProyecto)empleados.get(5)).setNumeroProyectos(3);

        //Pruebas
        imprimirEmpleados(empleados);
        System.out.println("Coste salarial total: " + calcularCosteTotal(empleados));
        System.out.println("Empleado con mayor sueldo: " + mayorSueldo(empleados).toString());
        System.out.println("Número de desarrolladores Junior: " +  contarEmpleados(empleados, Nivel.JUNIOR));
        System.out.println("Número de desarrolladores Mid: " +  contarEmpleados(empleados, Nivel.MID));
        System.out.println("Número de desarrolladores Senior: " +  contarEmpleados(empleados, Nivel.SENIOR) + "\n");

        //Ampliación 2
        System.out.println("Introduzca una cantidad:");
        int cantidad = sc.nextInt();
        System.out.println("Empleados cuyo salario supera la cantidad indicada: ");
        filtrarEmpleadosCantidad(empleados, cantidad);

        //Ampliación 3
        System.out.println("Desarrolladores: ");
        filtrarDesarrolladores(empleados);
    }


}
