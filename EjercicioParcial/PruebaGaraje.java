
package EjercicioParcial;

public class PruebaGaraje {
    public static void main(String[] args) {
        // Crear un garaje con capacidad para 10 vehículos
        Garaje garaje = new Garaje(10);

        // Alquilar algunos vehículos
        System.out.println("Alquilando vehículos:");
        garaje.alquilarEspacio(new Moto("MOTO123"));
        garaje.alquilarEspacio(new Auto("AUTO456"));
        garaje.alquilarEspacio(new Camioneta("CAMIONETA789", Camioneta.TipoServicio.SUV));
        garaje.alquilarEspacio(new Camioneta("CAMIONETA101", Camioneta.TipoServicio.Pickup));
        garaje.alquilarEspacio(new Moto("MOTO234"));
        System.out.println();

        // Buscar un vehículo
        System.out.println("Buscando vehículo con matrícula 'AUTO456':");
        int posicion = garaje.buscarVehiculo("AUTO456");
        if (posicion != -99) {
            System.out.println("Vehículo encontrado en la posición: " + posicion);
        } else {
            System.out.println("Vehículo no encontrado.");
        }
        System.out.println();

        // Contar vehículos por tipo
        System.out.println("Contando vehículos:");
        System.out.println("Cantidad de Motos: " + garaje.contarVehiculosPorTipo(Moto.class));
        System.out.println("Cantidad de Autos: " + garaje.contarVehiculosPorTipo(Auto.class));
        System.out.println("Cantidad de Camionetas: " + garaje.contarVehiculosPorTipo(Camioneta.class));
        System.out.println();

        // Calcular proporción de vehículos
        System.out.println("Calculando proporción de vehículos:");
        garaje.calcularProporcion();
        System.out.println();

        // Informar camionetas por tipo
        System.out.println("Informando camionetas por tipo:");
        garaje.informarCamionetasPorTipo();
        System.out.println();

        // Intentar alquilar más vehículos para probar las restricciones
        System.out.println("Intentando alquilar más vehículos:");
        garaje.alquilarEspacio(new Camioneta("CAMIONETA111", Camioneta.TipoServicio.Carga));
        garaje.alquilarEspacio(new Moto("MOTO345")); // Esto puede fallar si ya se alcanzó el 30% de motos
        System.out.println();

        // Mostrar el menú para más interacciones
        System.out.println("Iniciando menú interactivo:");
        garaje.mostrarMenu();
    }
}