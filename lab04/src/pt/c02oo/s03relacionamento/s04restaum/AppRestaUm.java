package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      //Funcao que inicia a execucao do jogo resta um

      //Declaracao de variaveis
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      Tabuleiro tab = new Tabuleiro();
      char board[][] = new char[7][7];
      int i = 0, j = 0, iProx = 0, jProx = 0;
      String aux = "";

      //Conectando o tabuleiro a cada peca, para cada peca poder fazer "perguntas" ao tabuleiro
      for(int n = 0; n < 7; n++){
         for(int m = 0; m < 7; m++){
            tab.getPeca(n, m).conecta(tab);
         }
      }
      
      //Escrevendo os comandos no vetor de string "commands"
      String commands[] = tk.retrieveCommands();

      //Criacao da matriz que sera mostrada na impressao
      for(int n = 0; n < 7; n++){
         for(int m = 0; m < 7; m++){
            board[n][m] = tab.getSimboloPeca(n, m);
         }
      }     
      tk.writeBoard("Tabuleiro inicial", board);
      
      for (int l = 0; l < commands.length; l++){
         //Realizacao do "l"ésimo comando da lista
         System.out.println(commands[l]);
         i = Character.getNumericValue(commands[l].charAt(1)) - 1;
         j = commands[l].charAt(0) - 'a';
         iProx = Character.getNumericValue(commands[l].charAt(4)) - 1;
         jProx = commands[l].charAt(3) - 'a';
         tab.moverPeca(i, j, iProx, jProx);

         //Atualizacao da matriz que sera impressa
         for(int n = 0; n < 7; n++){
            for(int m = 0; m < 7; m++){
               board[n][m] = tab.getSimboloPeca(n, m);
            }
         }
         aux = "source: " + commands[l].substring(0, 2) + "; target: " + commands[l].substring(3, 5);
         tk.writeBoard(aux, board);
      }
      tk.stop();
   }

}