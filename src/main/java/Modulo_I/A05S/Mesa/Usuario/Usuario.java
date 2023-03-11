package Modulo_I.A05S.Mesa.Usuario;

public class Usuario {
    private String nome;
    private String identificador;
    private String tipo;

    public Usuario(String nome, String identificador, String tipo) {
        this.nome = nome;
        this.identificador = identificador;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getTipo() {
        return tipo;
    }
}
