package Modulo_I.A08S.Aula.service;

public class ApiQuantidade {

    public int desconto(int quantidade) {
        if (quantidade > 12){
            return 15;
        }
        return 0;
    }

}
