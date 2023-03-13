package Modulo_II.A19S.Mesa;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListaContatos {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Criando uma lista de contatos
        List<Contato> contatos = new ArrayList<>();
        contatos.add(new Contato("Guilherme", "guilherme@email.com", "123456789"));
        contatos.add(new Contato("Moreira", "moreira@email.com", "987654321"));

        //Salvando a lista de contatos em um arquivo
        FileWriter fw = new FileWriter("src/main/java/Modulo_II/A19S/Mesa/Arquivo/contatos.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        for (Contato contato : contatos) {
            bw.write(contato.getNome() + ";" + contato.getEmail() + ";" + contato.getTelefone());
            bw.newLine();
        }

        bw.close();

        //Recuperando a lista de contatos do arquivo
        FileReader fr = new FileReader("src/main/java/Modulo_II/A19S/Mesa/Arquivo/contatos.txt");
        BufferedReader br = new BufferedReader(fr);

        List<Contato> contatosSalvos = new ArrayList<>();

        String linha = br.readLine();
        while (linha != null) {
            String[] dados = linha.split(";");
            Contato contato = new Contato(dados[0], dados[1], dados[2]);
            contatosSalvos.add(contato);
            linha = br.readLine();
        }

        br.close();

        //Exibindo a lista de contatos no console
        System.out.println("Lista de contatos:");
        for (Contato contato : contatosSalvos) {
            System.out.println("Nome: " + contato.getNome());
            System.out.println("E-mail: " + contato.getEmail());
            System.out.println("Telefone: " + contato.getTelefone());
            System.out.println("-----------------------------------");
        }
    }

}