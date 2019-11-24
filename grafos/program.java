package grafos;

public class program {
    public static void main(String[] args) {
        String[] vertices = {"a","b","c","d","e","f","g","h","i","j"};
        Grafo g = new Grafo(vertices);

        g.conectar("a", "b", 2);
        g.conectar("a", "c", 4);
        g.conectar("a", "d", 3);

        g.conectar("b", "e", 7);
        g.conectar("b", "f", 4);
        g.conectar("b", "g", 6);

        g.conectar("c", "e", 3);
        g.conectar("c", "f", 2);
        g.conectar("c", "g", 4);

        g.conectar("d", "e", 4);
        g.conectar("d", "f", 1);
        g.conectar("d", "g", 5);

        g.conectar("e", "h", 1);
        g.conectar("e", "i", 4);

        g.conectar("f", "h", 6);
        g.conectar("f", "i", 3);

        g.conectar("g", "h", 3);
        g.conectar("g", "i", 3);

        g.conectar("h", "j", 3);

        g.conectar("i", "j", 4);
        System.out.println("---------------------------");
        g.imprimir();
        System.out.println("---------------------------");
        g.calcularDijkstra(0);
    }
}
