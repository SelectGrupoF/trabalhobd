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
import modelo.Inseminacao;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Clovis
 */
public class DaoInseminacao {
    public static boolean inserir(Inseminacao objeto) {
        String sql = "INSERT INTO inseminacao (codigo, datai, situacao, observo, datap, cod_touro) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.setDate(2, Date.valueOf(objeto.getDatai())); //fazer a seguinte importação: java.sql.Date 
            ps.setInt(3, objeto.getSituacao());
            ps.setString(4, objeto.getObservo());
            ps.setDate(5, Date.valueOf(objeto.getDatap())); //fazer a seguinte importação: java.sql.Date 
            ps.setInt(6, objeto.getCod_touro().getCodigo());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        Inseminacao objeto = new Inseminacao();
        objeto.setCodigo(15);
        objeto.setDatai(LocalDate.parse("11/01/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy"))); //fazer as seguintes importações: java.time.format.DateTimeFormatter e java.time.LocalDate
        objeto.setSituacao(1);
        objeto.setObservo("Luiza");
        objeto.setDatap(LocalDate.parse("11/01/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy"))); //fazer as seguintes importações: java.time.format.DateTimeFormatter e java.time.LocalDate
        Touro novoObj = new Touro();
novoObj.setCodigo(2); //deve ser um valor de chave primária que já está cadastrado no BD
objeto.setCod_touro(novoObj);
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    public static boolean alterar(Inseminacao objeto) {
        String sql = "UPDATE inseminacao SET datai = ?, situacao = ?, observo = ?, datap = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setDate(1, Date.valueOf(objeto.getDatai())); //fazer a seguinte importação: java.sql.Date 
            ps.setInt(2, objeto.getSituacao());
            ps.setString(3, objeto.getObservo());
            ps.setDate(4, Date.valueOf(objeto.getDatap())); //fazer a seguinte importação: java.sql.Date 
            ps.setInt(5, objeto.getCod_touro().getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static boolean excluir(Inseminacao objeto) {
        String sql = "DELETE FROM inseminacao WHERE codigo=?";
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
    public static List<Inseminacao> consultar() {
        List<Inseminacao> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, datai, situacao, observo, datap, cod_touro FROM inseminacao";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inseminacao objeto = new Inseminacao();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setDatai(rs.getDate("datai").toLocalDate());
                objeto.setSituacao(rs.getInt("situacao"));
                objeto.setObservo(rs.getString("observo"));
                objeto.setDatap(rs.getDate("datap").toLocalDate());
                objeto.setCod_touro(DaoTouro.consultar(rs.getInt("cod_touro"))); //tem que importar DaoTipoProduto
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
    public static Inseminacao consultar(int primaryKey) {
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, datai, situacao, observo, datap, cod_touro FROM inseminacao WHERE codigo=?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, primaryKey);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inseminacao objeto = new Inseminacao();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setDatai(rs.getDate("datai").toLocalDate());
                objeto.setSituacao(rs.getInt("situacao"));
                objeto.setObservo(rs.getString("observo"));
                objeto.setDatap(rs.getDate("datap").toLocalDate());
                objeto.setCod_touro(DaoTouro.consultar(rs.getInt("cod_touro")));
                return objeto;//não mexa nesse, ele adiciona o objeto na lista
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
