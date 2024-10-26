public class Prueba {
        public static void main(String[] args) {
                // productos frescos creados
                ProductosFrescos productoFresco1 = new ProductosFrescos("2024-12-31", "LF123", "2024-10-01", "España");
                ProductosFrescos productoFresco2 = new ProductosFrescos("2024-11-30", "LF124", "2024-10-05", "Francia");

                // productos refrigerados creados
                ProductosRefrigerados productoRefrigerado1 = new ProductosRefrigerados("2025-01-15", "LR123", "CS123",
                                "2024-10-10", 4.0, "Italia");
                ProductosRefrigerados productoRefrigerado2 = new ProductosRefrigerados("2025-02-20", "LR124", "CS124",
                                "2024-10-12", 3.0, "Alemania");
                ProductosRefrigerados productoRefrigerado3 = new ProductosRefrigerados("2025-03-25", "LR125", "CS125",
                                "2024-10-15", 2.5, "Portugal");

                // productos congelados creados
                ProductosCongeladosAgua productoCongeladoAgua1 = new ProductosCongeladosAgua("2025-04-10", "CA123",
                                "2024-10-20", "México", -18.0, 35.0);
                ProductosCongeladosAgua productoCongeladoAgua2 = new ProductosCongeladosAgua("2025-05-15", "CA124",
                                "2024-10-22", "Chile", -20.0, 30.0);

                ProductosCongeladosAire productoCongeladoAire1 = new ProductosCongeladosAire("2025-06-01", "CA125",
                                "2024-10-25", "Argentina", -18.0, 78.0, 21.0, 0.03, 0.01);
                ProductosCongeladosAire productoCongeladoAire2 = new ProductosCongeladosAire("2025-06-15", "CA126",
                                "2024-10-27", "Brasil", -19.0, 75.0, 20.0, 0.04, 0.01);

                ProductosCongeladosNitrogeno productoCongeladoNitrogeno1 = new ProductosCongeladosNitrogeno(
                                "2025-07-01",
                                "CA127", "2024-10-30", "Colombia", -196.0, "Método rápido", 10);

                // mostrar la informacion
                System.out.println(productoFresco1);
                System.out.println(productoFresco2);
                System.out.println(productoRefrigerado1);
                System.out.println(productoRefrigerado2);
                System.out.println(productoRefrigerado3);
                System.out.println(productoCongeladoAgua1);
                System.out.println(productoCongeladoAgua2);
                System.out.println(productoCongeladoAire1);
                System.out.println(productoCongeladoAire2);
                System.out.println(productoCongeladoNitrogeno1);
        }
}
