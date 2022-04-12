package pt.c02oo.s03relacionamento.s04restaum;

public class Peça {
    String posAtual;
    int i, j;
    char mostra;
    Tabuleiro jogo;

    Peça(String posAtual, char mostra){
        i = Character.getNumericValue(posAtual.charAt(1));
        j = posAtual.charAt(0) - 'a';
        this.posAtual = posAtual;
        this.mostra = mostra;
    }

    void conecta(Tabuleiro jogo){
        this.jogo = jogo;
    }

    boolean podeMover(String proxPos){
        int iProx = Character.getNumericValue(proxPos.charAt(1));
        int jProx = proxPos.charAt(0) - 'a';

        if((iProx > 2 && iProx < 4) || (jProx > 2 && jProx < 4)){ //Se a posicao para a qual queremos mover é uma posicao valida

            if(!jogo.temPeca(iProx, jProx)){ //Se nao tem nenhuma peca na posicao que queremos ir

                if(i == iProx){ //Se o movimento for para a mesma linha

                    if(j == jProx + 2){ //Se a posicao atual está a direita da designada
                        if(jogo.temPeca(i, jProx + 1)) //Se tiver uma peca entre a posicao atual e a designada 
                            return true;  
                    }
                    else if(j == jProx - 2){ //Se a posicao atual está a esquerda da designada
                        if(jogo.temPeca(i, jProx - 1)) //Se tiver uma peca entre a posicao atual e a designada
                            return true;
                    }
                }

                else{ //Se o movimento for para a mesma coluna

                    if(i == iProx + 2){ //Se a posicao atual está acima da designada
                        if(jogo.temPeca(iProx + 1, j)) //Se tiver uma peca entre a posicao atual e a designada 
                            return true;
                    }
                    else if(i == iProx - 2){ //Se a posicao atual está abaixo da designada
                        if(jogo.temPeca(iProx - 1, j)) //Se tiver uma peca entre a posicao atual e a designada 
                            return true;
                    }
                }
            }
        }
        return false;
    }

    void mover(String proxPos){
        if(mostra == 'P'){
            if(podeMover(proxPos)){ //Se podemos mover para esta posicao
                mostra = '-';
            }
        }
    }
}
