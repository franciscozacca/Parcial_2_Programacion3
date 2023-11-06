/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app1;

import java.util.Scanner;

/**
 *
 * @author 54261
 */
public class APP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {



        String[][] mutantDna = {//define la matriz mutantDna que contiene la muesta de ADN
            {"G","A", "C", "T", "C","G"},
            {"T","C", "T", "A", "A","C"},
            {"A","A", "C", "T", "T","G"},
            {"A","A", "G", "A", "C","G"},
            {"G","C", "G", "A", "A","G"},
            {"T","T", "G", "G", "A","A"}
        };

       

        boolean isMutant = isMutant(mutantDna); //LLAMA A LA FUNCION isMutant Y ALMACENA SU RESULTADO EN LA VARIABLE isMutant

        System.out.println("Mutante: " + isMutant);//IMPRIME EN LA CONSOLA SI EL HUMANO REPRESENTADO POR mutantDna ES UN MUTANTE O NO.
    }

    public static boolean isMutant(String[][] dna) {//COMIENZA LA DEFINICION DEL METODO isMutant, QUE TOMA UNA MATRIZ DE ADN COMOA RGUMENTO Y DEVUELVE EL VALOR BOOLEANO
        int n = dna.length;// OBTIENE EL TAMAÑO DE LA MATRIZ, ASUMIENDO QUE ES UNA MATRIZ CUADRADA 6X6
        int count = 0;//LLEVA EL CONTEO DE SECUENCIAS DE ADN REPETIDAS

        for (int i = 0; i < n; i++) {//INICIA UN BUCLE INTERNO PARA ITERAR A TRAVES DE LAS FILAS DE LA MATRIZ
            for (int j = 0; j < n; j++) {//INICIA UN BUCLE EXTERNO PARA ITERAR A TRAVES DE COLUMNAS DE LA MATRIZ
                // Verificar horizontalmente
                if (j + 3 < n) {//COMPRUEBA SI ES POSIBLE VERIFICAR UNA SECUENCIA DE 4 BASES EN DIRECCION HORIZONTAL SIN EXCEDER LOS LIMITES DE LA MATRIZ
                    if (dna[i][j].equals(dna[i][j + 1])//COMPRUEBA SI ES POSIBLE VERIFICAR UNA SECUENCIA DE 4 BASES EN DIRECCION HORIZONTAL SIN EXCEDER LOS LIMITES DE LA MATRIZ
                            && dna[i][j].equals(dna[i][j + 2])
                            && dna[i][j].equals(dna[i][j + 3])) {
                        count++;// VERIFICA SI LAS BASES EN LA DIRECCION HORIZONTAL SON IGUALES EN 4 POSICIONES CONSECUTIVAS. SI ESTO SE CUMPLE AUMENTA EL CONTADOR
                    }
                }
                // Verificar verticalmente
                if (i + 3 < n) {// Comprueba si es posible verificar una secuencia de 4 bases en dirección vertical sin exceder los límites de la matriz.
                    if (dna[i][j].equals(dna[i + 1][j])
                            && dna[i][j].equals(dna[i + 2][j])
                            && dna[i][j].equals(dna[i + 3][j])) {
                        count++;//Verifica si las bases en la dirección vertical son iguales en 4 posiciones consecutivas. Si esto se cumple, aumenta el contador count.
                    }
                }
                // Verificar en diagonal hacia la derecha
                if (i + 3 < n && j + 3 < n) {//Comprueba si es posible verificar una secuencia de 4 bases en diagonal hacia la derecha sin exceder los límites de la matriz.
                    if (dna[i][j].equals(dna[i + 1][j + 1])
                            && dna[i][j].equals(dna[i + 2][j + 2])
                            && dna[i][j].equals(dna[i + 3][j + 3])) {
                        count++; //Verifica si las bases en la diagonal hacia la derecha son iguales en 4 posiciones consecutivas. Si esto se cumple, aumenta el contador count.
                    }
                }
                // Verificar en diagonal hacia la izquierda
                if (i + 3 < n && j - 3 >= 0) {//Comprueba si es posible verificar una secuencia de 4 bases en diagonal hacia la izquierda sin exceder los límites de la matriz.
                    if (dna[i][j].equals(dna[i + 1][j - 1])
                            && dna[i][j].equals(dna[i + 2][j - 2])
                            && dna[i][j].equals(dna[i + 3][j - 3])) {
                        count++;// Verifica si las bases en la diagonal hacia la izquierda son iguales en 4 posiciones consecutivas. Si esto se cumple, aumenta el contador count.
                    }
                }
            }
        }

        return count > 1; // Si se encuentran más de una secuencia, el humano es mutante.
    }
}
