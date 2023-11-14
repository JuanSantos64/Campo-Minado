
# 💣 Campo Minado

Campo Minado em tela preta feito em Java, espero que gostem!

## 🕹 Mecânicas

### 🛠 Criação do  campo minado

O código permite o usuário criar o tamanho que quiser do campo minado, determinando o numero de linhas, colunas e bombas, obviamente, todos devem ser maiores que 1:

```
System.out.println("Digite o número de linhas: ");
        int linha = entrada.nextInt(); // Numero de linhas 
        
        System.out.println("Digite o número de colunas: ");
        int coluna = entrada.nextInt(); // Numeros de colunas
        
        System.out.println("Digite o número de bombas: ");
        int bomba = entrada.nextInt(); // Numero de bombas*/
        
        if(linha>0 && coluna > 0 && bomba > 0){
        Random random = new Random();
        
        
        int[][] campoMinado = new int[linha][coluna]; // Campo minado que vai conter os números e a verificação da bomba
        
```
### 👨‍💻 Criação do campo minado do usuario

O código gera uma matriz de String do mesmo tamanho do campo minado, para que o usuário possa ver a posição que está escolhendo:

```
String[][] campoMinadoUsuario = new String[linha][coluna]; // Campo minado que vai ser mostrado ao usuário
        
        for (int i = 0; i < linha; i++) { // Coloca _ em todos os elementos do Campo minado do usuário
            for (int j = 0; j < coluna; j++) {
                campoMinadoUsuario[i][j] = "_ ";
            }
        }
```

### ⚙ Implementar as bombas no campo minado

Para que possamos implementar as bombas no campo minado tivemos que criar um objeto Random, porém haviam complicações para verificar se todos as bombas estão em lugares diferentes, tornando o código assim:

```
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
         
         }while(verificacao != bomba); // Se as bombas não estiverem em lugares diferentes, o código rodará de novo até que estejam

         public static int montarCampoMinado(int [][]a, int b){ // Classe feita para verificar se as bombas estão em lugares diferentes na matriz
         int contador = 0;
         for (int i = 0; i < a.length; i++) {
             for (int j = 0; j < a[i].length; j++) {
                 if(a[i][j] == 1)
                     contador++;
             }
         }
         return contador;
     }
```

### 🔐 Sistema anti-roubo

Para que o usuário não possa digitar a mesma posição, foi implementado uma verificação: 

```
int valor = campoMinado[linhaChute][colunaChute]; // Chute pra usar na nossa matriz
        if("X ".equals(campoMinadoUsuario[linhaChute][colunaChute])){
            System.out.println("Você não me engana, você tentou digitar o mesmo número pra acumular pontos, agora você perdeu...");
                    System.out.println("Game Over");
                    break;
        }
```
### 💣 "Bomba próximo"

O código implementa uma função para que fique mais divertido para o usuário para jogar, ele avisa se há bombas próximo do lado do chute do usuário, a verificação ficou assim: 

```
System.out.printf("Digite a linha do chute entre 0 e %d: ", linha-1);
            int linhaChute = entrada.nextInt(); // Chute da linha
        
            System.out.printf("Digite a coluna do chute entre 0 e %d: ", coluna-1);
            int colunaChute = entrada.nextInt(); // Chute da coluna

(...)

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
```
###
Obrigado por ler até aqui! ❤
