package Modulo_I.A05S.Atividade;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Documento {

    private int id;
    private String url;
    private String conteudo;
    private List<Usuario> usuariosAutorizados;
    private List<LocalDateTime> acessos;

    public Documento(int id, String url, String conteudo, List<Usuario> usuariosAutorizados) {
        this.id = id;
        this.url = url;
        this.conteudo = conteudo;
        this.usuariosAutorizados = usuariosAutorizados;
        this.acessos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getConteudo() {
        return conteudo;
    }

    public List<Usuario> getUsuariosAutorizados() {
        return usuariosAutorizados;
    }

    public List<LocalDateTime> getAcessos() {
        return acessos;
    }

    public void addAcesso(LocalDateTime acesso) {
        acessos.add(acesso);
    }
}
