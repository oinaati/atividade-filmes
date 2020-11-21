package com.mycompany.poopratica_ativ07_filmes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Natalia Reis
 *                  RA: 820142521
 */
public class Filmes {

    private String nome, diretor, atorPrincipal, genero;
    private int codigo;

    public Filmes(String nome, String diretor, String atorPrincipal, String genero) {
        this.nome = nome;
        this.diretor = diretor;
        this.atorPrincipal = atorPrincipal;
        this.genero = genero;
    }
    
    public Filmes(int codigo, String nome, String diretor, String atorPrincipal, String genero){
        this(nome, diretor, atorPrincipal, genero);
        this.codigo = codigo;
    }
    
    public Filmes(int codigo){
        this.codigo = codigo;
    }

    public void inserir() {

        String sql = "INSERT INTO tb_filmes (nome, diretor, atorPrincipal, genero) VALUES (?, ?, ?, ?)";

        ConnectionFactory fabrica = new ConnectionFactory();
        Connection c = null;

        try {
            c = fabrica.obterConexao();

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, nome);
            ps.setString(2, diretor);
            ps.setString(3, atorPrincipal);
            ps.setString(4, genero);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void alterar() {
        String sql = "UPDATE tb_filmes SET nome =  ? ,  diretor = ?,  atorPrincipal = ?, genero = ? WHERE codigo =  ?";

        ConnectionFactory fabrica = new ConnectionFactory();

        try (Connection c = fabrica.obterConexao()){


            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, nome);
            ps.setString(2, diretor);
            ps.setString(3, atorPrincipal);
            ps.setString(4, genero);
            ps.setInt(5, codigo);

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void apagar() {
        String sql = "DELETE FROM tb_filmes WHERE codigo=?";

        ConnectionFactory fabrica = new ConnectionFactory();
        Connection c = null;

        try {
            c = fabrica.obterConexao();

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, codigo);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Filmes> listar() {
        List<Filmes> filmes = new ArrayList<>();

        String sql = "SELECT * FROM tb_filmes limite 10";

        try (Connection c = new ConnectionFactory().obterConexao()) {

            PreparedStatement ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String diretor = rs.getString("diretor");
                String atorPrincipal = rs.getString("atorPrincipal");
                String genero = rs.getString("genero");
                
                Filmes p = new Filmes(codigo, nome, diretor, atorPrincipal, genero);
                filmes.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filmes;
    }

    public String getNome() {
        return nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public String getAtorPrincipal() {
        return atorPrincipal;
    }

    public String getGenero() {
        return genero;
    }

    public int getCodigo() {
        return codigo;
    }
    
    
}
