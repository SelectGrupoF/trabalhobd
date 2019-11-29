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
import modelo.Lactacao;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Clovis
 */
public class DaoLactacao {
    public static boolean inserir(Lactacao objeto) {
        String sql = "INSERT INTO lactacao (codigo, inicio, fim, obser) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.setDate(2, Date.valueOf(objeto.getInicio())); //fazer a seguinte importação: java.sql.Date
            ps.setDate(3, Date.valueOf(objeto.getFim())); //fazer a seguinte importação: java.sql.Date 
            ps.setString(4, objeto.getObser());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        Lactacao objeto = new Lactacao();
        objeto.setCodigo(15);
        objeto.setInicio(LocalDate.parse("11/01/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy"))); //fazer as seguintes importações: java.time.format.DateTimeFormatter e java.time.LocalDate
        objeto.setFim(LocalDate.parse("11/01/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy"))); //fazer as seguintes importações: java.time.format.DateTimeFormatter e java.time.LocalDate
        objeto.setObser("Luiza");
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    public static boolean alterar(Lactacao objeto) {
        String sql = "UPDATE lactacao SET inicio = ?, fim = ?, obser = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setDate(1, Date.valueOf(objeto.getInicio())); //fazer a seguinte importação: java.sql.Date 
            ps.setDate(2, Date.valueOf(objeto.getFim())); //fazer a seguinte importação: java.sql.Date 
            ps.setString(3, objeto.getObser());
           
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static boolean excluir(Lactacao objeto) {
        String sql = "DELETE FROM lactacao WHERE codigo=?";
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
    public static List<Lactacao> consultar() {
        List<Lactacao> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, inicio, fim, obser FROM lactacao";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lactacao objeto = new Lactacao();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setInicio(rs.getDate("inicio").toLocalDate());
                objeto.setFim(rs.getDate("Fim").toLocalDate());
                objeto.setObser(rs.getString("obser"));
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
    public static Lactacao consultar(int primaryKey) {
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, inicio, fim, obser FROM lactacao WHERE codigo=?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, primaryKey);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lactacao objeto = new Lactacao();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setInicio(rs.getDate("inicio").toLocalDate());
                objeto.setFim(rs.getDate("fim").toLocalDate());
                objeto.setObser(rs.getString("obser"));
                
                return objeto;//não mexa nesse, ele adiciona o objeto na lista
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
