/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Manejo;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Clovis
 */
public class DaoManejo {
    public static boolean inserir(Manejo objeto) {
        String sql = "INSERT INTO manejo (codigo, obs, datas) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.setString(2, objeto.getObs());
            ps.setDate(3, Date.valueOf(objeto.getDatas())); //fazer a seguinte importação: java.sql.Date 
            
            
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        Manejo objeto = new Manejo();
        objeto.setCodigo(15);
        objeto.setObs("Luiza");
        objeto.setDatas(LocalDate.parse("11/01/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy"))); //fazer as seguintes importações: java.time.format.DateTimeFormatter e java.time.LocalDate
        
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    public static boolean alterar(Manejo objeto) {
        String sql = "UPDATE lactacao SET obs = ?, datas = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getObs());
            ps.setDate(2, Date.valueOf(objeto.getDatas())); //fazer a seguinte importação: java.sql.Date 
            ps.setInt(3, objeto.getCodigo());
            
           
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static boolean excluir(Manejo objeto) {
        String sql = "DELETE FROM manejo WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static List<Manejo> consultar() {
        List<Manejo> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, obs, datas FROM manejo";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Manejo objeto = new Manejo();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setObs(rs.getString("obs"));
                objeto.setDatas(rs.getDate("datas").toLocalDate());
                
                
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
    public static Manejo consultar(int primaryKey) {
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, obs, datas FROM manejo WHERE codigo=?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, primaryKey);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Manejo objeto = new Manejo();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setObs(rs.getString("obs"));
                objeto.setDatas(rs.getDate("datas").toLocalDate());
                
                
                
                return objeto;//não mexa nesse, ele adiciona o objeto na lista
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
