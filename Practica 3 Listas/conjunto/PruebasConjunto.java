package conjunto;

public class PruebasConjunto {

    public static void main(String[] args) {
        Conjunto conjunto = new Conjunto();

        conjunto.insertar(4);
        conjunto.insertar(6);
        conjunto.insertar(2);
        conjunto.insertar(4);
        conjunto.insertar(-2);

        System.out.println();

        conjunto.mostrar();

        System.out.println();
        System.out.println("---------- Prueba Metodo toArray ----------");

        int[] array = conjunto.toArray();

        System.out.print("El array contiene: ");

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("---------- Prueba Metodo mayor ----------");

        System.out.println("El mayor elemento es: " + conjunto.mayor());

        System.out.println();
        System.out.println("---------- Prueba Metodo subconjunto ----------");

        Conjunto conjuntoPrueba = conjunto.subconjunto(3,6);

        conjuntoPrueba.mostrar();

        System.out.println();
        System.out.println("---------- Prueba Metodo equals ----------");

        conjuntoPrueba = new Conjunto();

        conjuntoPrueba.insertar(2);
        conjuntoPrueba.insertar(4);

        System.out.print("Un Conjunto es: ");
        conjuntoPrueba.mostrar();

        System.out.println("Es igual que el conjunto de trabajo? " + conjuntoPrueba.equals(conjunto));
        conjuntoPrueba.insertar(6);

        System.out.print("Un Conjunto es: ");
        conjuntoPrueba.mostrar();

        System.out.println("Es igual que el conjunto de trabajo? " + conjuntoPrueba.equals(conjunto));


        System.out.println();
        System.out.println("---------- Prueba Clase Algoritmos ----------");

        conjuntoPrueba = new Conjunto();

        conjuntoPrueba.insertar(4);
        conjuntoPrueba.insertar(5);

        Algoritmos algoritmo = new Algoritmos();

        Conjunto algoritmoResul = algoritmo.interseccion(conjunto,conjuntoPrueba);

        System.out.print("La interseccion de ");
        conjunto.mostrar();
        System.out.println(" con el de trabajo es: ");

        algoritmoResul.mostrar();
    }
}
