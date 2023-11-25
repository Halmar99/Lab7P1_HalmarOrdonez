//Fila 1, Silla 7
package lab7p1_halmarordonez;

import java.util.Scanner;
import java.util.Random;

public class Lab7P1_HalmarOrdonez {

    static Scanner read = new Scanner(System.in);
    static Random rng = new Random();

    public static void main(String[] args) {
        char syn = 's';
        while (syn == 's' || syn == 'S') {
            System.out.println("-----Menu-----");
            System.out.println("1. Tres en raya");
            System.out.println("2. Puntos de silla");
            System.out.println("3. Salir del programa");
            System.out.print("Ingrese su opcion: ");
            int opc = read.nextInt();

            switch (opc) {
                case 1 -> {
                    char cont = 's';
                    while (cont == 's' || cont == 'S') {
                        boolean wlt = false;
                        int ct=1;
                        System.out.println("---Bienvendido a tres en raya---");
                        System.out.println("Tablero actual: ");
                        char[][] matriz = new char[3][3];
                        matriz = generarTablero(matriz);
                        imprimirTablero(matriz);
                        int contador = 1, fila = 0, colu = 0;
                        while (wlt == false && ct<10) {
                            boolean tof = true;
                            if (contador % 2 != 0) {
                                System.out.println("Es el turno de X");
                                System.out.print("Ingrese la fila(0,1,2): ");
                                fila = read.nextInt();
                                System.out.print("Ingrese la columna(0,1,2): ");
                                colu = read.nextInt();
                                if(fila>=0 && fila<3 && colu>=0 && colu<3){
                                    System.out.println("El usuario a elegido la posicion: (" + fila + ", " + colu + ")");
                                    tof = verificarPosicionValida(matriz, fila, colu);
                                    if (tof == true) {
                                        matriz[fila][colu] = 'X';
                                        contador++;
                                        imprimirTablero(matriz);
                                        wlt = verificarVictoria(matriz, fila, colu);
                                        ct++;
                                    } else if (tof == false) {
                                        System.out.println("No se puede jugar, ingrese otra ubicacion");
                                        System.out.println();
                                    }
                                }
                                else{
                                    System.out.println();
                                    System.out.println("Ubicacion invalida, vuelvalor a intentar");
                                }

                            } else {
                                System.out.println("Es el turno de 0");
                                fila = rng.nextInt((2 - 0) + 1) + 0;
                                colu = rng.nextInt((2 - 0) + 1) + 0;
                                System.out.println("La maquina ha elegido la posicon: (" + fila + "," + colu + ")");
                                tof = verificarPosicionValida(matriz, fila, colu);
                                if (tof == true) {

                                    matriz[fila][colu] = '0';
                                    contador++;
                                    imprimirTablero(matriz);
                                    wlt = verificarVictoria(matriz, fila, colu);
                                    ct++;
                                } else if (tof == false) {
                                    System.out.println( );
                                    System.out.println("No se puede jugar, ingrese otra posicion");
                                }
                                
                            }

                        }
                        System.out.println();
                        if(ct>=10){
                            System.out.println("Empate!");
                        }else if(contador%2==0){
                            System.out.println("El ganador es X!!!");
                        }else{
                            System.out.println("El ganador es 0!!!");
                        }
                        System.out.println("");
                        System.out.print("Desea volver a jugar(s/n)?: ");
                        cont = read.next().charAt(0);

                    }

                }
                case 2 -> {
                    System.out.println("---Bienvenido a Puntos de silla---");
                    System.out.print("Ingrese numero de filas: ");
                    int fila = read.nextInt();
                    System.out.print("Ingrese numero de columnas: ");
                    int colu = read.nextInt();

                    System.out.println("Matriz generada: ");
                    int[][] matriz = rngfill(fila, colu);
                    imprimirint(matriz);
                    
                    
                    
                }
                case 3 -> {
                    System.out.println("Saliendo del programa...");
                }
                default -> {
                    System.out.println("Opcion invalida");
                }
            }
            if (opc != 3) {
                System.out.println();
                System.out.print("Desea regresar al menu inicial(s/n)?: ");
                syn = read.next().charAt(0);
            } else {
                syn = 'n';
            }
        }
    }

    public static char[][] generarTablero(char[][] matriz) {
        char space = ' ';
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = space;
            }
        }
        return matriz;
    }//FIN TABLERO

    public static void imprimirTablero(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("");
        }

    }//FIN TABLERO

    public static boolean verificarPosicionValida(char[][] matriz, int fila, int colu) {
        boolean temp = true;
        if (matriz[fila][colu] == ' ' && fila < 3 && colu < 3 && fila >= 0 && colu >= 0) {
            temp = true;

        } else {
            temp = false;
        }
        return temp;
    }//FIN VERIF VALIDA

    public static boolean verificarVictoria(char[][] matriz, int fila, int colu) {
        boolean temp = true;
        for (int i = 0; i < matriz.length; i++) {
            if ((matriz[i][0] == 'X' && matriz[i][1] == 'X' && matriz[i][2] == 'X') || (matriz[0][i] == 'X' && matriz[1][i] == 'X' && matriz[2][i] == 'X')) {
                temp = true;
                return temp;
            } else if ((matriz[0][0] == 'X' && matriz[1][1] == 'X' && matriz[2][2] == 'X') || (matriz[0][2] == 'X' && matriz[1][1] == 'X' && matriz[2][0] == 'X')) {
                temp = true;
                return temp;
            }else if((matriz[i][0] == '0' && matriz[i][1] == '0' && matriz[i][2] == '0') || (matriz[0][i] == '0' && matriz[1][i] == '0' && matriz[2][i] == '0')){
                temp=true;
                return temp;
            }else if((matriz[0][0] == 'X' && matriz[1][1] == 'X' && matriz[2][2] == 'X') || (matriz[0][2] == 'X' && matriz[1][1] == 'X' && matriz[2][0] == 'X')){
                temp=true;
                return temp;
            } 
            else{
                temp = false;
            }
        }
        return temp;
    }

    public static int[][] rngfill(int fila, int colu) {
        int[][] temp = new int[fila][colu];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < colu; j++) {
                temp[i][j] = rng.nextInt((99 - 0) + 1) + 0;
            }
        }
        return temp;
    }//FIN RNG

    public static int findpuntosilla(int[][] matriz) {
        int temp = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[0][j] > matriz[i][j]) {
                    temp = matriz[i][j];
                }
            }
        }
        return temp;
    }//FIN PUNTOS SILLA
    
    public static int menor(int[][]matriz,int colu){

    }

    public static void imprimirint(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println();
        }
    }//FIN IMPRIMIR
}
