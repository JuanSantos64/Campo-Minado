package javaapplication2;

import java.util.Scanner;

/**
 *
 * @author juans
 */
public class CampoMinado {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Digite o número de linhas: ");
        int linha = entrada.nextInt(); // Numero de linhas 
        
        System.out.println("Digite o número de colunas: ");
        int coluna = entrada.nextInt(); // Numeros de colunas
        
    /*    System.out.println("Digite o número de bombas: ");
        int bomba = entrada.nextInt(); // Numero de bombas*/
        
        
        
        int[][] campoMinado = new int[linha][coluna]; // Campo minado que vai conter os números e a verificação da bomba
        
        
        String[][] campoMinadoUsuario = new String[linha][coluna]; // Campo minado que vai ser mostrado ao usuário
        
        for (int i = 0; i < linha; i++) { // Coloca _ em todos os elementos do Campo minado do usuário
            for (int j = 0; j < coluna; j++) {
                campoMinadoUsuario[i][j] = "_ ";
            }
        }
        campoMinado[2][2] = 1;
        
        for (int i = 0; i < campoMinado.length * campoMinado[0].length; i++) {
        int contadorB = 0;
        for (int a = 0; a < linha; a++) { // Printa o campo minado pro usuário
            for (int b = 0; b < coluna; b++) {
                System.out.print(campoMinadoUsuario[a][b]);
                contadorB++;
                if (contadorB == coluna) {
                    System.out.format("\n");
                    contadorB = 0;
                }
            }
        }
            
            System.out.println("Digite a linha do chute: ");
            int linhaChute = entrada.nextInt(); // Chute da linha
        
            System.out.println("Digite a coluna do chute: ");
            int colunaChute = entrada.nextInt(); // Chute da coluna
                
        int valor = campoMinado[linhaChute][colunaChute]; // Chute pra usar na nossa matriz
        
        if (valor == 1){
            System.out.println("Tá vivo");
       if (colunaChute < (campoMinado[0].length -1) && campoMinado[linhaChute][colunaChute+1] == 0) { // Verificação do lado direito
                    System.out.format("Tem bomba próximo em [%d][%d]\n", linhaChute, colunaChute+1);
                }
        if (colunaChute > 0 && campoMinado[linhaChute][colunaChute-1] == 0) { // Verificação do lado esquerdo
                    System.out.format("Tem bomba próximo em [%d][%d]\n", linhaChute, colunaChute-1);
                }
        if (linhaChute > 0 && linhaChute < campoMinado.length && campoMinado[linhaChute-1][colunaChute] == 0) { // Verificação do lado superior
                    System.out.format("Tem bomba próximo em [%d][%d]\n", linhaChute-1, colunaChute);
                }
        if (linhaChute < campoMinado.length -1  && campoMinado[linhaChute+1][colunaChute] == 0) { // Verificação do lado inferior
                    System.out.format("Tem bomba próximo em [%d][%d]\n", linhaChute+1, colunaChute);
                }
        if (linhaChute < campoMinado.length-1 && colunaChute < campoMinado[0].length - 1 && campoMinado[linhaChute+1][colunaChute+1] == 0) { // Verificação do lado inferior direito
                    System.out.format("Tem bomba próximo em [%d][%d]\n", linhaChute+1, colunaChute+1);
                }
        if (colunaChute > 0 && linhaChute < campoMinado.length-1 && linhaChute < campoMinado.length - 1&& campoMinado[linhaChute+1][colunaChute-1] == 0) { // Verificação do lado inferior esquerdo
                    System.out.format("Tem bomba próximo em [%d][%d]\n", linhaChute+1, colunaChute-1);
                }
        if (linhaChute > 0 && colunaChute < campoMinado[0].length - 1 && campoMinado[linhaChute-1][colunaChute+1] == 0) { // Verificação do lado superior direito
                    System.out.format("Tem bomba próximo em [%d][%d]\n", linhaChute-1, colunaChute+1);
                }
        if (linhaChute > 0 && colunaChute > 0 && campoMinado[linhaChute-1][colunaChute-1] == 0) { // Verificação do lado superior esquerdo
                    System.out.format("Tem bomba próximo em [%d][%d]\n", linhaChute-1, colunaChute-1);
                }
        }
        else {
            System.out.println("Game Over");
            break;
        }
        
        }

    }

}
