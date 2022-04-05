

public class AquarioLombriga {
    int aqua, tamanho, posIni;
    int inverter = 0; 
    /* Usado na a função inverter, se seu valor for 1 a cabeça estará orientada para a direita, caso seja 0 estará para a esquerda*/

    AquarioLombriga(int aqua, int tamanho, int posIni){
        this.aqua = aqua;
        if(tamanho > aqua)
            this.tamanho = aqua;
        else
            this.tamanho = tamanho;
        if(posIni > aqua || posIni + tamanho > aqua)
            this.posIni = 1;
        else
            this.posIni = posIni;
    }

    void crescer(){
        if(inverter == 0){
            if(aqua - posIni - tamanho > 0)
                tamanho++;
        }
        else{
            if(posIni - tamanho > 0)
                tamanho++;
        }
    }

    void virar(){
        inverter = 1;
        posIni = posIni + tamanho - 1;
    }

    void mover(){
        if(inverter == 0){
            if(posIni > 1)
                posIni--;
            else
                virar();
        }
        
        else{
            if(posIni < aqua)
                posIni++;
            else
                virar();
        }
    }

    String apresenta(){
        String atual = "";

        for(int i = 1; i <= aqua; i++){
            if(inverter == 0){
                if(i < posIni)
                    atual = atual.concat("#");
                else if(i == posIni)
                    atual = atual.concat("O");
                else if(i - posIni < tamanho)
                    atual = atual.concat("@");
                else
                    atual =atual.concat("#");
            }

            else{
                if(i <= posIni - tamanho)
                    atual = atual.concat("#");
                else if(i == posIni)
                    atual = atual.concat("O");
                else if(i > posIni)
                    atual = atual.concat("#");
                else if(i >= posIni - tamanho)
                    atual = atual.concat("@");
            }
        }
        return atual;
    }
}
