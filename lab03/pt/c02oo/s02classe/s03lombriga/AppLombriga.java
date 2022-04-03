package lab03.pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      
      Animacao lombriga = new Animacao("080403MCMVM");

      String lombrigas[] = tk.recuperaLombrigas();
      
      for (int l = 0; l < lombrigas.length; l++)
         System.out.println(lombrigas[l]);
      
      tk.gravaPasso("=====");
      tk.gravaPasso(lombriga.apresenta());
      lombriga.passo();
      tk.gravaPasso(lombriga.apresenta());
      lombriga.passo();
      tk.gravaPasso(lombriga.apresenta());
      lombriga.passo();
      tk.gravaPasso(lombriga.apresenta());
      lombriga.passo();
      tk.gravaPasso(lombriga.apresenta());
      lombriga.passo();
      tk.gravaPasso(lombriga.apresenta());
      
      tk.stop();
   }

}
