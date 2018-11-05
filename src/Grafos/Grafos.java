package Grafos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.Vector;
import javax.swing.JOptionPane;

public class Grafos {

    private String vecAux[];
    private String vec[];
    public int mat[][];
    public Stack pila2 = new Stack();
    public Vector posMenor = new Vector();
    public Stack pila1 = new Stack();
    public int pos = 0;

    public int menor() {
        return pos;
    }

    public Stack getpila() {
        return pila2;
    }

    //Esto se encarga de buscar un String en un vector
    public int buscar(String a) {
        int cont = 0;
        for (int i = 0; i < vec.length; i++) {
            if (a.equals(vec[i])) {
                cont = i;
            }
        }
        return cont;
    }

    /*Este metodo crea el vector de vertices a partir de una de una hilera que obtenida 
    desde todo el archivo de texto, este vector que se crea es el vector de vertices    */
    public String[] vertices(String e) {
        Vector copia = new Vector();
        String aux = "";
        int contador2 = 0;
        int contador = 0;
        for (int i = 0; i < e.length(); i++) {
            if (Character.isLetter(e.charAt(i))) {
                aux = aux + e.charAt(i);
                contador2 = 0;
            } else if (!Character.isLetter(e.charAt(i)) && contador2 < 1) {
                copia.add(aux);
                contador = contador + 1;
                aux = "";
                contador2 = contador2 + 1;
            }

        }
        vecAux = new String[copia.size()];
        for (int i = 0; i < copia.size(); i++) {
            vecAux[i] = (String) copia.get(i);
        }
        return vecAux;
    }

    /*Este metodo organiza el vector con los vertices que entrarán en el grafo, como hay palabras
    que necesitan hacer mas de un cambio en una sola operación, no es posible llegar a la palabra final,
    por tanto se desechan estas palabras */
    public void desPalabras(int tamaño, int posIni) {
        int contador = 0;
        for (int i = 0; i < vecAux.length; i++) {
            if (numLetrasDife(vecAux[posIni], vecAux[i]) > tamaño) {
                vecAux[i] = "";
                contador++;
            }
        }
        int tamVector = vecAux.length - contador;
        vec = new String[tamVector];
        int cont = 0;
        for (int i = 0; i < vecAux.length; i++) {
            if (!vecAux[i].equals("") && cont < tamVector) {
                vec[cont] = vecAux[i];
                cont++;
            }
        }
    }

    /*Este metodo compara el numero de letras distintas entre ambas palabras que ingresan
    por parametro y retornará un entero con el cual se compara el numero de cambios que 
    se tiene que realizar en la palabra inicial para llegar a la otra*/
    public int numLetrasDife(String a, String b) {
        String c, d;
        if (a.length() > b.length()) {
            c = a;
            d = b;
        } else {
            c = b;
            d = a;
        }

        int diferencia = c.length() - d.length();
        int cont = 0;
        if (diferencia >= 1) {
            int i = 0, j = 0;
            int conta2 = 0;
            while (i < c.length() && j < d.length()) {
                if (c.charAt(i) == d.charAt(j)) {
                    i = i + 1;
                    j = j + 1;
                    conta2++;
                } else {
                    i++;
                    cont = cont + 1;
                }
            }
            if (conta2 > 1) {
                cont = cont + 1;
            }

        } else if (diferencia == 0) {
            for (int i = 0; i < c.length(); i++) {
                if (c.charAt(i) != d.charAt(i)) {
                    cont = cont + 1;
                }
            }
        }

        if (cont > 1) {
            return cont;
        } else {
            return cont;
        }
    }

    /*Este metodo se encarga de crear la matriz que se mostrará por medio del graphviz*/
    public void crearMatriz() {
        mat = new int[vec.length][vec.length];
        for (int i = 0; i < mat.length; i++) { //Ciclo para llenar la matriz de ceros             
            for (int j = 0; j < mat.length; j++) {
                mat[i][j] = 0;
            }
        }
        int i = 0;
        int cont = 0;
        while (i < vec.length) {// ciclo que recorre el vector de vertices y según los cambios que se hayan hecho
            //hace la matriz
            for (int j = 0; j < vec.length; j++) {
                if ((numLetrasDife(vec[i], vec[j]) == 1) && (i != j)) {
                    mat[i][j] = 1;
                    cont++;
                }
            }
            if (cont == 0 && i == 0) {
                mat = null;
                return;
            }
            i++;
        }
        mostrarMatriz();
        crearArchivo(mat);
    }
    public void mostrarMatriz(){
        for (int i = 0; i <mat.length; i++) {
            System.out.print(vec[i]);
            for (int j = 0; j < mat.length; j++) {
                System.out.print(" "+mat[i][j]);
            }
            System.out.println(" ");
        }
    }

    /*Crea un archivo de texto con los con el codigo a mostrar por Graphviz  
    y que depende de la matriz de adyacencia que entra como parametro*/
    public void crearArchivo(int a[][]) {
        String texto = "";
        File f;
        FileWriter escrito;
        try {
            f = new File("C:\\Users\\Public\\Grafos.txt");
            escrito = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(escrito);
            PrintWriter salida = new PrintWriter(bw);

            texto = "graph G {" + "\n" + "node [shape=circle];\n" + " node [style=filled];\n"
                    + " node [fillcolor=\"#EEEEEE\"];\n" + " edge [color=\"#31CEF0\"];";
            //Se recorre el ciclo con de fin de ir creando en el archivo cada uno de los vertices que contendra la imagen y sus lados 
            for (int i = 0; i < a.length; i++) {
                for (int j = i; j < a.length; j++) {
                    if (a[i][j] == 1 || a[i][j] == 1) {
                        texto = texto + vec[i] + "--" + vec[j] + "[label=" + "\"\"" + "];" + "\n";
                    }
                }
            }
            texto = texto + "\n" + "}";//modifique aqui
            salida.write(texto);
            salida.close();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
        }
        gener(a);
    }

    //Este metodo se encarga de generar la imagen del grafo correspondiente a cada hilera
    //entran como parametro la matriz con los vertices a mostrar
    public void gener(int i[][]) {
        try {

            String dotPath = "C:\\Graphviz2.38\\bin\\dot.exe";

            String fileInputPath = "C:\\Users\\Public\\Grafos.txt";
            String fileOutputPath = "C:\\Users\\Public\\Grafos.jpg";

            String tParam = "-Tjpg";
            String tOParam = "-o";//aqui tambien quite

            String[] cmd = new String[5];

            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }

    //halla los caminos, en los parametros entra un entero que seran los vertices de inicio y final del recorrido
    public void caminos(int orig, int fin) {

        pila1.push(orig);
        if (orig == fin) //pregunta si los vertices son iguales (se acerca al caso base)
        {
            Stack aux = (Stack) pila1.clone();
            pila2.push(aux);
            pila1.pop();
            return;
        }
        for (int i = 0; i < mat.length; i++) {
            if (!pila1.contains(i))// Se ejecuta si la i no se encuetra alamacenada en pila
            {
                if (mat[orig][i] != 0) {
                    caminos(i, fin);
                }
            }
        }
        pila1.pop();
    }

    // Se crea un vector que contiene los datos del camino, entra como parametro un pila.
    public String[] mostrarCaminos(Stack m) {  // se crearon las variables suficientes para trabajar
        String vector[] = new String[m.size()];
        String auxi = "";
        String supra = "";
        int c = m.size();
        int menor = 30;
        for (int i = 0; i < c; i++) {
            Stack pila5 = (Stack) m.pop();
            Stack aux = new Stack();
            int b = pila5.size();
            //Almacena el tamaño de la hilera obtenido y lo organiza de igual forma      
            for (int k = 0; k < b - 1; k++) {
                aux.push(pila5.pop());
            }
            auxi = vec[(int) pila5.pop()];
            supra = auxi;
            int conta = 0;
            for (int j = 0; j < b - 1; j++) {
                conta++;
                String k = vec[(int) aux.pop()];
                supra += " -> " + k;
                vector[i] = supra; //Almacena el camino recorrido (posiciones del vector) y los organiza de igual forma.
            }
            if (menor >= conta) {
                menor = conta;
                posMenor.addElement(vector[i]);
            }
        }
        return vector;
    }

    // Muestra el o los menores caminos entre dos vertices
    public String menorCamino() {
        String mostrar = "";
        int menor = 60;
        for (int i = 0; i < posMenor.size(); i++) {
            if ((posMenor.get(i).toString().length()) < menor) {
                menor = posMenor.get(i).toString().length();
            }
        }
        for (int i = 0; i < posMenor.size(); i++) {
            if ((posMenor.get(i).toString().length()) == menor) {
                mostrar = mostrar + " ֍ " + posMenor.get(i) + "\n";
            }
        }
        return mostrar;
    }
}
