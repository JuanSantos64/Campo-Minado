
package javaapplication2;


import java.util.Random;
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
        
        System.out.println("Digite o número de bombas: ");
        int bomba = entrada.nextInt(); // Numero de bombas*/
        
        if(linha>0 && coluna > 0 && bomba > 0){
        Random random = new Random();
        
        
        int[][] campoMinado = new int[linha][coluna]; // Campo minado que vai conter os números e a verificação da bomba
        
        
        String[][] campoMinadoUsuario = new String[linha][coluna]; // Campo minado que vai ser mostrado ao usuário
        
        for (int i = 0; i < linha; i++) { // Coloca _ em todos os elementos do Campo minado do usuário
            for (int j = 0; j < coluna; j++) {
                campoMinadoUsuario[i][j] = "_ ";
            }
        }
      int chance;
       int contaBomba = bomba;
       int verificacao = 0;
         do{
         for (int i = 0; i < linha; i++) {
             for (int j = 0; j < coluna; j++) { 
                     chance = random.nextInt(0, 2);    
                 campoMinado[i][j] = chance;
                 if (chance == 1){
                     contaBomba--;  
                 }
             }
              verificacao = montarCampoMinado(campoMinado, bomba);
             
             }
         
         }while(verificacao != bomba);
         
        
        /* for (int i = 0; i < linha; i++) {
             for (int j = 0; j < coluna; j++) {
                 System.out.println(campoMinado[i][j]);
             }
         }
*/
        int pontos = 0;
        for (int i = 0; i < (campoMinado.length * campoMinado[0].length) - bomba; i++) {
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
            
            System.out.printf("Digite a linha do chute entre 0 e %d: ", linha-1);
            int linhaChute = entrada.nextInt(); // Chute da linha
        
            System.out.printf("Digite a coluna do chute entre 0 e %d: ", coluna-1);
            int colunaChute = entrada.nextInt(); // Chute da coluna
                
        int valor = campoMinado[linhaChute][colunaChute]; // Chute pra usar na nossa matriz
        if(campoMinadoUsuario[linhaChute][colunaChute] == "X "){
            System.out.println("Você não me engana, você tentou digitar o mesmo número pra acumular pontos, agora você perdeu...");
                    System.out.println("Game Over");
                    break;
        }
        
        if (valor == 0){
            System.out.println("Tá vivo");
       if (colunaChute < (campoMinado[0].length -1) && campoMinado[linhaChute][colunaChute+1] == 1) { // Verificação do lado direito
                    System.out.format("Tem bomba próximo\n");
                }
       else if (colunaChute > 0 && campoMinado[linhaChute][colunaChute-1] == 1) { // Verificação do lado esquerdo
                    System.out.format("Tem bomba próximo\n");                }
       else if (linhaChute > 0 && linhaChute < campoMinado.length && campoMinado[linhaChute-1][colunaChute] == 1) { // Verificação do lado superior
                     System.out.format("Tem bomba próximo\n");
                }
       else if (linhaChute < campoMinado.length -1  && campoMinado[linhaChute+1][colunaChute] == 1) { // Verificação do lado inferior
                     System.out.format("Tem bomba próximo\n");
                }
       else if (linhaChute < campoMinado.length-1 && colunaChute < campoMinado[0].length - 1 && campoMinado[linhaChute+1][colunaChute+1] == 1) { // Verificação do lado inferior direito
                     System.out.format("Tem bomba próximo\n");
                }
       else if (colunaChute > 0 && linhaChute < campoMinado.length-1 && linhaChute < campoMinado.length - 1&& campoMinado[linhaChute+1][colunaChute-1] == 1) { // Verificação do lado inferior esquerdo
                     System.out.format("Tem bomba próximo\n");
                }
       else if (linhaChute > 0 && colunaChute < campoMinado[0].length - 1 && campoMinado[linhaChute-1][colunaChute+1] == 1) { // Verificação do lado superior direito
                     System.out.format("Tem bomba próximo\n");
                }
       else if (linhaChute > 0 && colunaChute > 0 && campoMinado[linhaChute-1][colunaChute-1] == 1) { // Verificação do lado superior esquerdo
                     System.out.format("Tem bomba próximo\n");
                }
        pontos++;
        campoMinadoUsuario[linhaChute][colunaChute] = "X ";
        }
        else {
            System.out.println("Game Over");
            break;
        }
        
        }
        
         System.out.println("Pontos: " + pontos);
         System.out.println("Número de bombas: " + bomba);
         System.out.println("Campo Minado: ");
         for (int i = 0; i < linha; i++) {
             for (int j = 0; j < coluna; j++) {
                 if(campoMinado[i][j] == 1)
                     campoMinadoUsuario[i][j] = "B ";
             }
         }
         int contadorA = 0;
                 for (int a = 0; a < linha; a++) { // Printa o campo minado pro usuário
            for (int b = 0; b < coluna; b++) {
                System.out.print(campoMinadoUsuario[a][b]);
                contadorA++;
                if (contadorA == coluna) {
                    System.out.format("\n");
                    contadorA = 0;
                }
            }
        }
         
    }
     }
     public static int montarCampoMinado(int [][]a, int b){
         int contador = 0;
         for (int i = 0; i < a.length; i++) {
             for (int j = 0; j < a[i].length; j++) {
                 if(a[i][j] == 1)
                     contador++;
             }
         }
         return contador;
     }

}


