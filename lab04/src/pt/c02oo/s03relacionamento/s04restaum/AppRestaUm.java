package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      Tabuleiro tab = new Tabuleiro();
      char board[][] = new char[7][7];
      int i = 0, j = 0, iProx = 0, jProx = 0;
      String aux = "";
      
      String commands[] = tk.retrieveCommands();

      for(int n = 0; n < 7; n++){
         for(int m = 0; m < 7; m++){
            board[n][m] = tab.getSimboloJogo(n, m);
         }
      }     
      tk.writeBoard("Tabuleiro inicial", board);
      
      for (int l = 0; l < commands.length; l++){
         System.out.println(commands[l]);
         i = Character.getNumericValue(commands[l].charAt(1));
         j = commands[l].charAt(0) - 'a';
         iProx = Character.getNumericValue(commands[l].charAt(4));
         jProx = commands[l].charAt(3) - 'a';
         tab.moverPeca(i, j, iProx, jProx);

         for(int n = 0; n < 7; n++){
            for(int m = 0; m < 7; m++){
               board[n][m] = tab.getSimboloJogo(n, m);
            }
         }
         aux = "source: " + commands[l].substring(0, 2) + "; target: " + commands[l].substring(3, 5);
         tk.writeBoard(aux, board);
      }
      tk.stop();
   }

}