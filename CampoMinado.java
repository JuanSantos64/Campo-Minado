package javaapplication2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author juans
 */
public class CampoMinado {

    public static void main(String[] args) {
        // Variaveis utilizadas no código: 
        int contadorA;
        int contadorB;
        int chance;
        int contaBomba;
        int verificacao;
        int pontos = 0;
        int linha = 0;
        int coluna = 0;
        int bomba;
        int linhaChute;
        int colunaChute;
        int[][] campoMinado = new int[linha][coluna]; // Campo minado que vai conter os números e a verificação da bomba
        String[][] campoMinadoUsuario = new String[linha][coluna]; // Campo minado que vai ser mostrado ao usuário
        // Fim das variaveis

        // Objetos utilizados no código: 
        Random random = new Random();
        Scanner entrada = new Scanner(System.in);
        // Fim dos objetos

        // Inicio do código: 
        System.out.println("Digite o número de linhas: ");
        linha = entrada.nextInt(); // Numero de linhas 

        System.out.println("Digite o número de colunas: ");
        coluna = entrada.nextInt(); // Numeros de colunas

        System.out.println("Digite o número de bombas: ");
        bomba = entrada.nextInt(); // Numero de bombas

        if (linha > 0 && coluna > 0 && bomba > 0) { // Se os numeros obtidos acima forem mais que o necessário para continuar o jogo, o código continua

            for (int i = 0; i < linha; i++) { // Coloca _ em todos os elementos do Campo minado do usuário
                for (int j = 0; j < coluna; j++) {
                    campoMinadoUsuario[i][j] = "_ ";
                }
            }

            contaBomba = bomba;
            verificacao = 0;
            do {
                for (int i = 0; i < linha; i++) {
                    for (int j = 0; j < coluna; j++) {
                        chance = random.nextInt(0, 2);
                        campoMinado[i][j] = chance; // Armazena "0" ou "1" no elemento [i][j] da matriz
                        if (chance == 1) {
                            contaBomba--;  // Se armazenou "1" no elemento da matriz, contaBomba diminui 1.
                        }
                    }
                    verificacao = verificarCampoMinado(campoMinado, bomba); // Função que verifica se a matriz está com a quantidade ideal de bombas.

                }

            } while (verificacao != bomba); // Roda esse bloco de código até que a função verificarCampoMinado() retorne o valor exato da variavel bomba;

            for (int i = 0; i < (campoMinado.length * campoMinado[0].length) - bomba; i++) { // Começa a parte do jogo para o usuário
                contadorB = 0;
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

                System.out.printf("Digite a linha do chute entre 0 e %d: ", linha - 1);
                linhaChute = entrada.nextInt(); // Chute da linha

                System.out.printf("Digite a coluna do chute entre 0 e %d: ", coluna - 1);
                colunaChute = entrada.nextInt(); // Chute da coluna

                int valor = campoMinado[linhaChute][colunaChute]; // Chute pra usar na nossa matriz
                if ("X ".equals(campoMinadoUsuario[linhaChute][colunaChute])) { // Verifica se o usuário digitou a mesma posição que já digitou anteriormente
                    System.out.println("Você não me engana, você tentou digitar o mesmo número pra acumular pontos, agora você perdeu...");
                    System.out.println("Game Over");
                    break;
                }

                if (valor == 0) { // Se a posição do chute não tiver bombas, executa a verificação se há alguma bomba próximo
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
                    pontos++;
                    campoMinadoUsuario[linhaChute][colunaChute] = "X ";
                } else { // Se houver uma bomba na posição do chute, executa o fim do jogo
                    System.out.println("Game Over");
                    break;
                }

            }
            for (int i = 0; i < linha; i++) { // Configura o campo minado do usuario para que apareca a localização das bombas
                for (int j = 0; j < coluna; j++) {
                    if (campoMinado[i][j] == 1) {
                        campoMinadoUsuario[i][j] = "B ";
                    }
                }
            }
            // Após o fim do jogo, é exibido a pontuação, número de bombas escolhidas e o campo minado com as posições de todas as bombas
            System.out.println("Pontos: " + pontos);
            System.out.println("Número de bombas: " + bomba);
            System.out.println("Campo Minado: ");
            contadorA = 0;
            for (int a = 0; a < linha; a++) { // Printa o campo minado do usuário
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
