package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
    Peça aux;
    Peça jogo[][] = new Peça[7][7];

    Tabuleiro(){
        String aux = "a";
        String s = "";
        //Variáveis para ajudar na nomeacao das posicoes

        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                aux = Character.toString(aux.charAt(0) + j);
                s = aux + i + 1;
                //Variavel s contem uma string que identifica a posicao atual

                if((i < 2 || i > 4) && (j < 2 || j > 4)) //Posicoes proibidas
                    jogo[i][j] = new Peça(s, ' ');
                else if(i == 3 && j == 3) //Posicao central
                    jogo[i][j] = new Peça("d4", '-');
                else //Restante do tabuleiro
                    jogo[i][j] = new Peça(s, 'P');
            }
        }
    }

    boolean temPeca(int i, int j){
        if(jogo[i][j].mostra == 'P')
            return true;
        else
            return false;
    }
}
