package Modulo_I.A05S.Mesa.Servico;

import Modulo_I.A05S.Mesa.Usuario.Usuario;

class ServicoDownloadProxy implements IServicoDownload {
    private ServicoDownload servicoDownload = new ServicoDownload();

    @Override
    public void baixarMusica(Usuario usuario, String musica) {
        // Verifica se o usuário tem acesso ao download
        if (usuario.getTipo().equals("Premium")) {
            servicoDownload.baixarMusica(usuario, musica);
        } else {
            System.out.println("O usuário " + usuario.getNome() + " não tem acesso ao download de músicas.");
        }
    }
}