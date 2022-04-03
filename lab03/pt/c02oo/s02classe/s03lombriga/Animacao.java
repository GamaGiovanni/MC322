package lab03.pt.c02oo.s02classe.s03lombriga;

public class Animacao {
    AquarioLombriga lombriga;
    String dados, animacoes;

    Animacao(String dados){
        this.dados = dados;
        animacoes = dados.substring(6, dados.length());
        lombriga = new AquarioLombriga(Integer.parseInt(dados.substring(0, 2)), Integer.parseInt(dados.substring(2, 4)), 
                                       Integer.parseInt(dados.substring(4, 6)));
    }

    String apresenta(){
        String l = lombriga.apresenta();
        return l;
    }

    void passo(){
        char aux = animacoes.charAt(0);
        if(aux == "C".charAt(0))
            lombriga.crescer();
        else if(aux == "M".charAt(0))
            lombriga.mover();
        else
            lombriga.virar();
        animacoes = animacoes.substring(1, animacoes.length());
    }
}
