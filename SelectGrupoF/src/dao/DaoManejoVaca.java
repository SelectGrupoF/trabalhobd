/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ManejoVaca;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Clovis
 */
public class DaoManejoVaca {
    public static boolean inserir(ManejoVaca objeto) {
        String sql = "INSERT INTO manejo_vaca (cod_man, cod_vaca) VALUES (?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCod_man().getCodigo());
            ps.setInt(2, objeto.getCod_vaca().getBrinco());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        ManejoVaca objeto = new ManejoVaca();
        Manejo novoObj = new Vaca();
        novoObj.setCodigo(2); //deve ser um valor de chave primária que já está cadastrado no BD
        objeto.setCod_man(novoObj);

        Vaca novoObj = new Vaca();
        novoObj.setBrinco(2); //deve ser um valor de chave primária que já está cadastrado no BD
        objeto.setCod_vaca(novoObj);
        
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    public static boolean alterar(ManejoVaca objeto) {
        String sql = "UPDATE manejo_vaca SET cod_man = ?, cod_vaca = ? WHERE cod_man = ? AND cod_vaca = ? ";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            
            ps.setInt(1, objeto.getCod_man().getCodigo());
            ps.setInt(2, objeto.getCod_vaca().getBrinco());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static boolean excluir(ManejoVaca objeto) {
        String sql = "DELETE FROM manejo_vaca WHERE cod_man=?, cod_vaca = ?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCod_man().getCodigo());
            ps.setInt(2, objeto.getCod_vaca().getBrinco());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static List<ManejoVaca> consultar() {
        List<ManejoVaca> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT cod_man, cod_vaca FROM manejo_vaca";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ManejoVaca objeto = new ManejoVaca();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCod_man(DaoManejo.consultar(rs.getInt("cod_man"))); //tem que importar DaoTipoProduto
                objeto.setCod_vaca(DaoVaca.consultar(rs.getInt("cod_vaca"))); //tem que importar DaoTipoProduto
              
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
    public static ManejoVaca consultar(int primaryKey) {
        //editar o SQL conforme a entidade
        String sql = "SELECT cod_man, cod_vaca FROM manejo_vaca";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, primaryKey);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ManejoVaca objeto = new ManejoVaca();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCod_man(DaoManejo.consultar(rs.getInt("cod_man"))); //tem que importar DaoTipoProduto
                objeto.setCod_vaca(DaoVaca.consultar(rs.getInt("cod_vaca"))); //tem que importar DaoTipoProduto
                return objeto;//não mexa nesse, ele adiciona o objeto na lista
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
