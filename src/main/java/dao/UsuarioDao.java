/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
import view.TelaPrincipalView;

/**
 *
 * @author chris
 */
public class UsuarioDao {

    private static final UsuarioDao instance = new UsuarioDao();

    public static UsuarioDao getInstance() {
        return instance;
    }

    public void insert(String nome, String login, String senha, boolean admin) {

        try {
            Connection conexao = new Conexao().getConnection();

            String sql = "insert into usuario(nome,login,senha,admin) values('" + nome + "', '" + login + "', '" + senha + "', " + admin + ")";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.execute();

            conexao.close();

        } catch (SQLException ex) {

            System.out.printf("Erro ao adicionar %s\n%s\n\n", nome, ex.getMessage());
            Logger.getLogger(TelaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Usuario getUser(String login, String senha) {
        Usuario user = new Usuario("INVALID", "123", "456", true);
        try {
            Connection conexao = new Conexao().getConnection();
            String sql = "select * from usuario where usuario.login = '" + login + "' and usuario.senha = '" + senha + "'";

            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

       
                while (rs.next()) {
                user.setNome(rs.getString(2));
                user.setLogin(rs.getString(3));
                user.setSenha(rs.getString(4));
                user.setAdmin(rs.getBoolean(5));
            }
            
            

            conexao.close();
            return user;

        } catch (SQLException ex) {

           
            Logger.getLogger(TelaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
            return user;
        }

    }

}
