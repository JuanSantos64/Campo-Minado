package javaapplication2;

// Imports utilizados no código:
import java.util.Random;
import java.util.Scanner;
// Fim dos imports

/**
 * Executa um jogo como um Campo Minado em tela preta (terminal) 
 * @author juans
 */
public class CampoMinadoFuncoes {

    public static void main(String[] args) {
        // Variaveis utilizadas no código: 
        int pontos = 0;
        int linha = lerDados();
        int coluna = lerDados();
        int bomba = lerDados();
        
        int[][] a = criarMatrizInt(linha,coluna);
        a = preencherMatriz(a, bomba);
        String[][] b = criarMatrizUsuario(linha, coluna);
        b = preencherMatrizUsuario(b);
      
        // Fim das variaveis

        // Objetos utilizados no código: 
        Random random = new Random();
        Scanner entrada = new Scanner(System.in);
        // Fim dos objetos


        if (linha > 0 && coluna > 0 && bomba > 0) { // Se os numeros obtidos acima forem mais que o necessário para continuar o jogo, o código continua



            for (int i = 0; i < (a.length * a[0].length) - bomba; i++) { // Começa a parte do jogo para o usuário
                mostrarMatrizUsuario(b);

                System.out.printf("Digite a linha do chute entre 0 e %d: ", linha - 1);
                int linhaChute = entrada.nextInt(); // Chute da linha

                System.out.printf("Digite a coluna do chute entre 0 e %d: ", coluna - 1);
                int colunaChute = entrada.nextInt(); // Chute da coluna

                if ("X ".equals(b[linhaChute][colunaChute])) { // Verifica se o usuário digitou a mesma posição que já digitou anteriormente
                    System.out.println("Você não me engana, você tentou digitar o mesmo número pra acumular pontos, agora você perdeu...");
                    System.out.println("Game Over");
                    break;
                }
                int valor = a[linhaChute][colunaChute]; // Chute pra usar na nossa matriz
                boolean verificado = verificar(a, b, colunaChute, linhaChute, valor);
                if(verificado == true){
                    pontos++;
                }
                else 
                    break;
            }
            atualizarMatrizUsuario(a, b);
            // Após o fim do jogo, é exibido a pontuação, número de bombas escolhidas e o campo minado com as posições de todas as bombas
            System.out.println("Pontos: " + pontos);
            System.out.println("Número de bombas: " + bomba);
            System.out.println("Campo Minado: ");
            mostrarMatrizUsuario(b);

        }
    }
    public static boolean verificar(int[][]campoMinado, String[][]campoMinadoUsuario, int colunaChute, int linhaChute, int valor){
        
        boolean verificar = false;
        if (valor == 0) { // Se a posição do chute não tiver bombas, executa a verificação se há alguma bomba próximo
            verificar = true;
                    System.out.println("Tá vivo");
                     if (colunaChute < (campoMinado[0].length - 1) && campoMinado[linhaChute][colunaChute + 1] == 1) { // Verificação do lado direito
                        System.out.format("Tem bomba próximo\n");
                    } else if (colunaChute > 0 && campoMinado[linhaChute][colunaChute - 1] == 1) { // Verificação do lado esquerdo
                        System.out.format("Tem bomba próximo\n");
                    } else if (linhaChute > 0 && linhaChute < campoMinado.length && campoMinado[linhaChute - 1][colunaChute] == 1) { // Verificação do lado superior
                        System.out.format("Tem bomba próximo\n");
                    } else if (linhaChute < campoMinado.length - 1 && campoMinado[linhaChute + 1][colunaChute] == 1) { // Verificação do lado inferior
                        System.out.format("Tem bomba próximo\n");
                    } else if (linhaChute < campoMinado.length - 1 && colunaChute < campoMinado[0].length - 1 && campoMinado[linhaChute + 1][colunaChute + 1] == 1) { // Verificação do lado inferior direito
                        System.out.format("Tem bomba próximo\n");
                    } else if (colunaChute > 0 && linhaChute < campoMinado.length - 1 && linhaChute < campoMinado.length - 1 && campoMinado[linhaChute + 1][colunaChute - 1] == 1) { // Verificação do lado inferior esquerdo
                        System.out.format("Tem bomba próximo\n");
                    } else if (linhaChute > 0 && colunaChute < campoMinado[0].length - 1 && campoMinado[linhaChute - 1][colunaChute + 1] == 1) { // Verificação do lado superior direito
                        System.out.format("Tem bomba próximo\n");
                    } else if (linhaChute > 0 && colunaChute > 0 && campoMinado[linhaChute - 1][colunaChute - 1] == 1) { // Verificação do lado superior esquerdo
                        System.out.format("Tem bomba próximo\n");
                    }
                    campoMinadoUsuario[linhaChute][colunaChute] = "X ";
                } else
            return verificar;
        return verificar;
    }
    public static void mostrarMatrizUsuario(String[][]c) {
        int contadorA = 0;
        for (int a = 0; a < c.length; a++) { // Printa o campo minado do usuário
                for (int b = 0; b <c[a].length ; b++) {
                    System.out.print(c[a][b]);
                    contadorA++;
                    if (contadorA == c[a].length) {
                        System.out.format("\n");
                        contadorA = 0;
                    }
                }
            }
    }
    public static String[][] atualizarMatrizUsuario(int [][]a, String [][]b) {
        for (int i = 0; i < a.length; i++) { // Configura o campo minado do usuario para que apareca a localização das bombas
                for (int j = 0; j < a[i].length; j++) {
                    if (a[i][j] == 1) {
                        b[i][j] = "B ";
                    }
                }
            }
        return b;
    }
    public static int lerDados() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Número: ");
        int a = entrada.nextInt();
        return a;
    }
    
    
    public static int[][] criarMatrizInt(int a, int b) {
        int [][] m = new int[a][b];
        return m;
    }
    public static String[][] criarMatrizUsuario(int a, int b) {
        String[][]m = new String[a][b];
        return m;
    }
    
    public static String[][] preencherMatrizUsuario(String [][]a) {
        for (int i = 0; i < a.length; i++) { // Coloca _ em todos os elementos do Campo minado do usuário
                for (int j = 0; j < a[i].length; j++) {
                    a[i][j] = "_ ";
                }
            }
        return a;
        
    }
    public static int[][] preencherMatriz(int [][]a, int b) {
        Random random = new Random();
         int contaBomba = b;
            int verificacao = 0;
            int chance = 0;
            do {
                for (int i = 0; i < a.length; i++) {
                    for (int j = 0; j < a[i].length; j++) {
                        chance = random.nextInt(2);
                        a[i][j] = chance; // Armazena "0" ou "1" no elemento [i][j] da matriz
                        if (chance == 1) {
                            contaBomba--;  // Se armazenou "1" no elemento da matriz, contaBomba diminui 1.
                        }
                    }
                    verificacao = verificarCampoMinado(a, contaBomba); // Função que verifica se a matriz está com a quantidade ideal de bombas.

                }

            } while (verificacao != b); // Roda esse bloco de código até que a função verificarCampoMinado() retorne o valor exato da variavel bomba;

                return a;
            }
        
    
    
    
    public static int verificarCampoMinado(int[][] a, int b) { // Verifica se as bombas estão dispostas de maneira certa
        int contador = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    contador++;
                }
            }
        }
        return contador;
    }

}
