package Modulo_II.A20S.Mesa;

import Modulo_II.A20S.Mesa.Empresa.Empresa;
import Modulo_II.A20S.Mesa.Empresa.Funcionario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Criando empresa com 4 funcionários
        Empresa empresa = new Empresa("12.345.678/0001-90", "Empresa XYZ");
        empresa.addFuncionario(new Funcionario("João", "Silva", "2334340232", 5000));
        empresa.addFuncionario(new Funcionario("Márcia", "Oliveira", "5423223443", 12000));
        empresa.addFuncionario(new Funcionario("Gisele", "Braga", "3421323322", 2500));
        empresa.addFuncionario(new Funcionario("Carlos", "Motta", "8322312324", 8000));

        // Salvando a empresa e seus funcionários em um arquivo
        FileWriter fw = new FileWriter("src/main/java/Modulo_II/A20S/Mesa/Arquivo/empresas.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(empresa.getCnpj() + ";" + empresa.getRazaoSocial());
        bw.newLine();

        for (Funcionario funcionario : empresa.getFuncionarios()) {
            bw.write(funcionario.getNome() + ";" + funcionario.getSobrenome() + ";" + funcionario.getDocumento() + ";" + funcionario.getSalario());
            bw.newLine();
        }

        bw.close();

        // Recuperando a empresa e seus funcionários do arquivo
        FileReader fr = new FileReader("src/main/java/Modulo_II/A20S/Mesa/Arquivo/empresas.txt");
        BufferedReader br = new BufferedReader(fr);

        String[] dadosEmpresa = br.readLine().split(";");
        Empresa empresaSalva = new Empresa(dadosEmpresa[0], dadosEmpresa[1]);

        List<Funcionario> funcionariosSalvos = new ArrayList<>();
        String linha = br.readLine();
        while (linha != null) {
            String[] dadosFuncionario = linha.split(";");
            Funcionario funcionario = new Funcionario(dadosFuncionario[0], dadosFuncionario[1], dadosFuncionario[2], Double.parseDouble(dadosFuncionario[3]));
            funcionariosSalvos.add(funcionario);
            linha = br.readLine();
        }

        empresaSalva.setFuncionarios(funcionariosSalvos);

        br.close();

        // Exibindo a empresa e seus funcionários no console
        System.out.println("Empresa: " + empresaSalva.getRazaoSocial() + " (" + empresaSalva.getCnpj() + ")");
        System.out.println("-----------------------------------");
        System.out.println("Funcionários:");
        for (Funcionario funcionario : empresaSalva.getFuncionarios()) {
            System.out.println("Nome: " + funcionario.getNome() + " " + funcionario.getSobrenome());
            System.out.println("Documento: " + funcionario.getDocumento());
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println("-----------------------------------");
        }
    }
}
