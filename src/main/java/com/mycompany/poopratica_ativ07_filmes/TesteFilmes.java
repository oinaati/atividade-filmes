package com.mycompany.poopratica_ativ07_filmes;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Natalia Reis
 *                  RA: 820142521
 */
public class TesteFilmes {

    public static void main(String[] args) {
        String menu = "Menu de opções\n1 - Cadastrar\n2 - Atualizar\n3 - Apagar\n4 - Listar\n5 - Sair";
        int op = -1;

        do {

            try {

                op = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (op) {
                    case 1: { // Cadastrar filme
                        String nome = JOptionPane.showInputDialog("Nome do filme: ");
                        String diretor = JOptionPane.showInputDialog("Diretor do filme: ");
                        String atorPrincipal = JOptionPane.showInputDialog("Ator principal do filme: ");
                        String genero = JOptionPane.showInputDialog("Genero do filme: ");

                        Filmes filmes = new Filmes(nome, diretor, atorPrincipal, genero);
                        filmes.inserir();

                        JOptionPane.showMessageDialog(null, "Filme cadastrado!");
                    }
                    break;
                    case 2: { // Atualizar filme
                        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do filme que deseja alterar: "));
                        String nome = JOptionPane.showInputDialog("Nome do filme: ");
                        String diretor = JOptionPane.showInputDialog("Diretor do filme: ");
                        String atorPrincipal = JOptionPane.showInputDialog("Ator principal do filme: ");
                        String genero = JOptionPane.showInputDialog("Genero do filme: ");

                        Filmes filmes = new Filmes(codigo, nome, diretor, atorPrincipal, genero);
                        filmes.alterar();

                        JOptionPane.showMessageDialog(null, "Filme alterado!");
                    }
                    break;
                    case 3: { // Apagar filme
                        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do filme que deseja apagar: "));

                        Filmes filmes = new Filmes(codigo);

                        filmes.apagar();

                        JOptionPane.showMessageDialog(null, "Filme apagado!");
                    }
                    break;
                    case 4: {// Listar filmes
                        
                        
                        List<Filmes> filmes = Filmes.listar();

                        for (Filmes f : filmes) {
                            System.out.println("Código: " + f.getCodigo() + "\nTitulo: " + f.getNome() + "\nDiretor: " + f.getDiretor()
                                    + "\nAtor principal: " + f.getAtorPrincipal() + "\nGênero do filme: " + f.getGenero() + "\n");
                        }
                        JOptionPane.showMessageDialog(null, "Lista impressa no console.");
                    }
                    break;
                    case 5: // Sair
                        JOptionPane.showMessageDialog(null, "Até mais!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um número no menu!");
            }
        } while (op != 5);

    }
}
