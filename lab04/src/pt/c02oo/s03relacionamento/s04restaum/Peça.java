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
        return simbolo;
    }

    public void setSimbolo(char simbolo){
        this.simbolo = simbolo;
    }

    public void conecta(Tabuleiro tab){
        this.tab = tab;
    }

    public void mover(int iProx, int jProx){
        if(simbolo == 'P'){ //Esta é uma peça válida
            if(!tab.temPeca(iProx, jProx)){ //Não há peça para o local aonde queremos mover esta peça
                if(i - iProx + j - jProx == 2 || i - iProx + j - jProx == -2){ //A posição designada fica a 2 "casas" da atual
                    if(tab.temPeca((i + iProx)/2, (j + jProx)/2)){ //Se tem uma peca entre a posicao atual e a designada
                        
                        setSimbolo('-');                                       //
                        tab.setSimboloJogo((i + iProx)/2, (j + jProx)/2, '-'); //Movimento da peça
                        tab.setSimboloJogo(iProx, jProx, 'P');                 //
                    }
                }
            }
        }
    }
}
