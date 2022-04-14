package pt.c02oo.s03relacionamento.s04restaum;

public class Peça {
    private int i, j;
    private char simbolo;
    private Tabuleiro tab;

    Peça(int i, int j, char simbolo){
        this.i = i;
        this.j = j;
        this.simbolo = simbolo;
    }

    public char getSimbolo(){
        //Metodo get que retorna o simbolo da peca
        return simbolo;
    }

    public void setSimbolo(char simbolo){
        //Metodo set que altera o simbolo da peca
        this.simbolo = simbolo;
    }

    public void conecta(Tabuleiro tab){
        //Metodo que conecta a peca ao tabuleiro, para a peca poder fazer "perguntas" para o tabuleiro
        this.tab = tab;
    }

    public void mover(int iProx, int jProx){
        //Metodo que verifica se esta peca pode se mover para a posicao especificada [iProx][jProx]

        if(simbolo == 'P'){ //Esta é uma peça válida

            if(!tab.temPeca(iProx, jProx)){ //Não há peça para o local aonde queremos mover esta peça

                if(i - iProx + j - jProx == 2 || i - iProx + j - jProx == -2 && i == iProx || j == jProx){ //A posição designada fica a 2 "casas" da atual e esta na mesma linha ou coluna

                    if(tab.temPeca((i + iProx)/2, (j + jProx)/2)){ //Se tem uma peca entre a posicao atual e a designada
                        
                        setSimbolo('-');                                       //
                        tab.setSimboloPeca((i + iProx)/2, (j + jProx)/2, '-'); //Movimento da peça
                        tab.setSimboloPeca(iProx, jProx, 'P');                 //
                    }
                }
            }
        }
    }
}
