package grafos;

public class Dijkstra {
    public static String vertices[]={"a","b","c","d","e","f"};
    public static int[][] pesos= {
            {0,4,2,99,99,99},
            {4,0,1,5,99,99},
            {2,1,0,8,10,99},
            {99,5,8,0,2,6},
            {99,99,10,2,0,2},
            {99,99,99,6,2,0}};

    public static void main(String[] args){
        Grafo grafo = new Grafo(vertices, pesos);

        grafo.imprimir();

        grafo.calcularDijkstra(5);
    }
}
