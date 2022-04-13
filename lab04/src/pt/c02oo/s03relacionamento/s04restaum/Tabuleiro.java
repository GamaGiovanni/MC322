package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
    private Peça jogo[][] = new Peça[7][7];

    Tabuleiro(){ //Criando o tabuleiro com o formato inicial
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                if((i < 2 || i > 4) && (j < 2 || j > 4)) //Posicoes proibidas
                    jogo[i][j] = new Peça(i, j, ' ');
                else if(i == 3 && j == 3) //Posicao central
                    jogo[i][j] = new Peça(i, j, '-');
                else //Restante do tabuleiro
                    jogo[i][j] = new Peça(i, j, 'P');
            }
        }
    }    

    public boolean temPeca(int i, int j){
        if(jogo[i][j].getSimbolo() == 'P')
            return true;
        else
            return false;
    }

    public void setSimboloJogo(int i, int j, char simbolo){
        jogo[i][j].setSimbolo(simbolo);
    }

    public char getSimboloJogo(int i, int j){
        return jogo[i][j].getSimbolo();
    }

    public void moverPeca(int i, int j, int iProx, int jProx){
        jogo[i][j].mover(iProx, jProx);
    }
}
