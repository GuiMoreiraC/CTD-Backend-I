package Modulo_I.A05S.Mesa.Servico;

import Modulo_I.A05S.Mesa.Usuario.Usuario;

class ServicoDownload implements IServicoDownload {

    @Override
    public void baixarMusica(Usuario usuario, String musica) {

        // Verifica se o usuário tem acesso ao download
        if (usuario.getTipo().equals("Premium")) {
            System.out.println("Baixando a música " + musica + " para o usuário " + usuario.getNome() + "...");
        } else {
            System.out.println("O usuário " + usuario.getNome() + " não tem acesso ao download de músicas.");
        }
    }

}
