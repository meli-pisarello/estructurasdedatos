package grafos;

public class Grafo {

    int[][] matrizPesos;
    String[] vertices;
    int[] distancias;

    public Grafo(String[] vertices) {
        this.vertices = vertices;
        matrizPesos = new int[vertices.length][vertices.length];
        this.distancias = new int[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                if (i == j)
                    matrizPesos[i][j] = 0;
                else
                    matrizPesos[i][j] = 99;
            }
        }
    }

    public Grafo(String[] vertices, int[][] pesos) {
        this.vertices = vertices;
        matrizPesos = pesos;
        this.distancias = new int[vertices.length];
    }

    public void conectar(String v1, String v2, int peso) {
        int index1 = busquedaIndex(v1);
        int index2 = busquedaIndex(v2);
        if (index1 != -1 && index2 != -1) {
            matrizPesos[index1][index2] = peso;
            matrizPesos[index2][index1] = peso;
        }
    }

    public void imprimir() {
        for (int i = 0; i < matrizPesos.length; i++) {
            for (int j = 0; j < matrizPesos.length; j++) {
                System.out.printf("%2d ", matrizPesos[i][j]);
            }
            System.out.println();
        }
    }

    private int busquedaIndex(String v) {
        int resultado = -1;

        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(v)) {
                resultado = i;
                break;
            }
        }

        return resultado;
    }

    public void calcularDijkstra(int o){
        int flag[] = new int[vertices.length];
        int i, minpos=o, k, c, minimo;

        // lo llenamos al vector distancia con la fila de la matriz correspondiente al indice recibido
        // entonces esto indica que estoy en el estado inicial y tengo todas las distancias directas desde ese punto

        for(i=0 ;i<vertices.length;i++){
            flag[i]=0;
            this.distancias[i]=this.matrizPesos[o][i]; // tomamos como estado inicial a la fila de la posición recibida
        }
        flag[o]=1; // marcamos la posición de origin como visitada
        c=1;

        while(c<=vertices.length){

            minimo=99; // hv

            // recorremos todas las posiciones buscando la de menor peso que aún no ha sido visitada
            for(k=0;k<vertices.length;k++){
                if(this.distancias[k]<minimo && flag[k]!=1) {
                    // guardamos el valor del menor
                    minimo=this.distancias[k];
                    // guardamos donde está la posición del menor
                    minpos=k;
                }
            }
            // marcamos la posición visitada
            flag[minpos]=1;

            for(k=0;k<vertices.length;k++){
                // verificamos si se encontró un camino más corto que no había sido visitado
                if(this.distancias[minpos]+this.matrizPesos[minpos][k] <  this.distancias[k] && flag[k]!=1 )
                   // actualizamos nuestro array de distancias
                    this.distancias[k]=this.distancias[minpos]+this.matrizPesos[minpos][k];
            }

            c++;
        }

        System.out.println("Distancias desde el nodo origen "+vertices[o]);
        for (i=0;i<distancias.length;i++){
            System.out.print(vertices[i]+": "+distancias[i]+", ");
        }

        return;
    }
}

