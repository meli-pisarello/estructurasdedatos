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
                    matrizPesos[i][j] = 999;
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
                System.out.print(matrizPesos[i][j] + " ");
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

    public void calcularDijkstra(){
        int flag[] = new int[vertices.length];
        int i,minpos=1,k,c,minimo;

        //lo llenamos al vector distancia con la primer fila de la matriz
        //entonces esto indica que estoy parada en el estado inicial y tengo todas las distancias desde ese punto

        for(i=0 ;i<vertices.length;i++){
            flag[i]=0;
            this.distancias[i]=this.matrizPesos[0][i]; // tomando como el estado inicial al nodo ubicado el 0
        } // this.distancias[] = [0, 2, 4, 3, 999, 999, 999, 999, 999, 999]

        c=2;

        while(c<=vertices.length){

            minimo=99; // hv

            //se arranca en 1 suponiendo que el 0 es el estado inicial
            for(k=1;k<vertices.length;k++){
                if(this.distancias[k]<minimo && flag[k]!=1) { // primer vuelva: 2 < 99? si && 0 != 1? si
                    // guardamos el valor del menor
                    minimo=this.distancias[k]; // minimo = 2
                    // guardamos donde esta la posicion del menor
                    minpos=k; // minpos = 1
                }
                // c2: minimo = 2, minpos = 1
                // c3: minimo = 3, minpos = 3
                // c4: minimo = 4, minpos = 2
            }
            // marcamos esta posición como visitada
            flag[minpos]=1;
            c++;
            // this.distancias[] = [0, 2, 4, 3, 999, 999, 999, 999, 999, 999]
            // flag[] = [0,1,1,1,0,0,0,0,0,0]
            for(k=1;k<vertices.length;k++){
                // c2 (k=1): 2 + 0 < 2? no && flag != 1? no
                // c2 (k=2): 2 + 999 < 4? no && flag != 1? si
                // c2 (k=3): 2 + 999 < 3? no && flag != 1? si
                // c2 (k=4): 2 + 7 < 0? no && flag != 1? si
                // c3 (k=1): 3 + 999 < 2? no && flag != 1? no
                // c3 (k=2): 3 + 999 < 4? no && flag != 1? si
                // c3 (k=3): 3 + 0 < 3? no && flag != 1? no
                // c3 (k=4): 3 + 4 < 999? si && flag != 1? si <---- entra
                // c3 (k=5): 3 + 1 < 999? si && flag != 1? si <---- entra
                // c3 (k=6): 3 + 5 < 999? si && flag != 1? si <---- entra
                // c4 (k=1): 4 + 999 < 4? no && flag != 1? no
                // c4 (k=2): 4 + 0 < 4? no && flag != 1? no
                // c4 (k=3): 4 + 999 < 999? no && flag != 1? no
                // c4 (k=4): 4 + 3 < 999? si && flag != 1? si <---- entra
                if(this.distancias[minpos]+this.matrizPesos[minpos][k] <  this.distancias[k] && flag[k]!=1 )
                    this.distancias[k]=this.distancias[minpos]+this.matrizPesos[minpos][k];
                // this.distancias[4] = this.distancias[3] + this.matrizPesos[3][4]
                // this.distancias[4] = 3 + 4 = 7
                // this.distancias[4] = [0, 2, 4, 3, 7, 999, 999, 999, 999, 999]

                // this.distancias[5] = this.distancias[3] + this.matrizPesos[3][5]
                // this.distancias[5] = 3 + 1 = 4
                // this.distancias[5] = [0, 2, 4, 3, 7, 4, 999, 999, 999, 999]

                // this.distancias[6] = this.distancias[3] + this.matrizPesos[3][6]
                // this.distancias[6] = 3 + 5 = 8
                // this.distancias[6] = [0, 2, 4, 3, 7, 4, 8, 999, 999, 999]

                // this.distancias[4] = this.distancias[2] + this.matrizPesos[2][4]
                // this.distancias[4] = 4 + 3 = 7
                // this.distancias[4] = [0, 2, 4, 3, 7, 4, 8, 999, 999, 999]
            }

        }

        for (i=0;i<distancias.length;i++){
            System.out.print(distancias[i]+" ");
        }


        return;



    }
}

