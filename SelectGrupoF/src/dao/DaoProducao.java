/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Producao;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import DaoCod_pessoa;
import DaoCod_pessoa;

/**
 *
 * @author Clovis
 */
public class DaoProducao {
    public static boolean inserir(Producao objeto) {
        String sql = "INSERT INTO producao (codigo, turno, data, total, obs, cod_pessoa) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.setInt(2, objeto.getTurno());
            ps.setDate(3, Date.valueOf(objeto.getData()));
            ps.setInt(4, objeto.getTotal());
            ps.setString(5, objeto.getObs());
            ps.setInt(6, objeto.getCod_pessoa());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        Producao objeto = new Producao();
        objeto.setCodigo(1);
        objeto.setTurno(1);
        objeto.setData(LocalDate.parse("11/01/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setTotal(10);
        objeto.setObs("a");
        
        Cod_pessoa novoObj = new Cod_pessoa();
        novoObj.setCodigo(1);
        objeto.setInteger(novoObj);
        
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    public static boolean alterar(Producao objeto) {
        String sql = "UPDATE producao SET turno = ?, data = ?, total = ?, obs = ?, cod_pessoa = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getTurno());
            ps.setDate(2, Date.valueOf(objeto.getData()));
            ps.setInt(3, objeto.getTotal());
            ps.setString(4, objeto.getObs());
            ps.setInt(5, objeto.getCod_pessoa());
            ps.setInt(6, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
     public static boolean excluir(Producao objeto) {
        String sql = "DELETE FROM producao WHERE codigo=?";
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
     public static List<Producao> consultar() {
        List<Producao> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, turno, data, total, obs, cod_pessoa FROM producao";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producao objeto = new Producao();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setTurno(rs.getInt("turno"));
                objeto.setData(rs.getDate("data").toLocalDate());
                objeto.setTotal(rs.getInt("total"));
                objeto.setObs(rs.getString("obs"));
               objeto.setInteger(DaoCod_pessoa.consultar(rs.getInt("cod_pessoa")));
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
     public static Producao consultar(int primaryKey) {
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, turno, data, total, obs, cod_pessoa FROM producao WHERE codigo=?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, primaryKey);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producao objeto = new Producao();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setTurno(rs.getInt("turno"));
                objeto.setData(rs.getDate("data").toLocalDate());
                objeto.setTotal(rs.getInt("total"));
                objeto.setObs(rs.getString("obs"));
                objeto.setCod_pessoa(DaoCod_pessoa.consultar(rs.getInt("cod_pessoa")));
                
                return objeto;//não mexa nesse, ele adiciona o objeto na lista
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
