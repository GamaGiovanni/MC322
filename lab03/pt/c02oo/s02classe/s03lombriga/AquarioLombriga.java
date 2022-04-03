package lab03.pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
    int aqua, tamanho, pos_ini;
    int inverter = 0; 
    /* Usado na a função inverter, se seu valor for 1 a cabeça estará orientada para a direita, caso seja 0 estará para a esquerda*/

    AquarioLombriga(int aqua, int tamanho, int pos_ini){
        this.aqua = aqua;
        if(tamanho > aqua)
            this.tamanho = aqua;
        else
            this.tamanho = tamanho;
        if(pos_ini > aqua || pos_ini + tamanho > aqua)
            this.pos_ini = 1;
        else
            this.pos_ini = pos_ini;
    }

    void crescer(){
        if(inverter == 0){
            if(aqua - pos_ini - tamanho > 0)
                tamanho++;
        }
        else{
            if(pos_ini - tamanho > 0)
                tamanho++;
        }
    }

    void virar(){
        inverter = 1;
        pos_ini = pos_ini + tamanho - 1;
    }

    void mover(){
        if(inverter == 0){
            if(pos_ini > 1)
                pos_ini--;
            else
                virar();
        }
        
        else{
            if(pos_ini < aqua)
                pos_ini++;
            else
                virar();
        }
    }

    String apresenta(){
        String atual = "";

        for(int i = 1; i <= aqua; i++){
            if(inverter == 0){
                if(i < pos_ini)
                    atual = atual.concat("#");
                else if(i == pos_ini)
                    atual = atual.concat("O");
                else if(i - pos_ini < tamanho)
                    atual = atual.concat("@");
                else
                    atual =atual.concat("#");
            }

            else{
                if(i <= pos_ini - tamanho)
                    atual = atual.concat("#");
                else if(i == pos_ini)
                    atual = atual.concat("O");
                else if(i > pos_ini)
                    atual = atual.concat("#");
                else if(i >= pos_ini - tamanho)
                    atual = atual.concat("@");
            }
        }
        return atual;
    }
}
