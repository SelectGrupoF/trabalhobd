/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Vaca;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Clovis
 */
public class DaoVaca {
    public static boolean inserir(Vaca objeto) {
        String sql = "INSERT INTO vaca (brinco, situacao, origem, nascimento, observa, cod_raca, cod_lac, cod_leite, cod_ins, cod_mae) VALUES (?, ?, ?, ?, ?, ?,?,?,?,?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getBrinco());
            ps.setInt(2, objeto.getSituacao());
            ps.setInt(3, objeto.getOrigem());
            ps.setDate(4, Date.valueOf(objeto.getNascimento()));
            ps.setString(5, objeto.getObserva());
            ps.setInt(6, objeto.getCod_raca().getCodigo());
            ps.setInt(7, objeto.getCod_lac().getCodigo());
            ps.setInt(8, objeto.getCod_leite().getCodigo());
            ps.setInt(9, objeto.getCod_ins().getCodigo());
            ps.setInt(10, objeto.getCod_mae().getBrinco());
            
            
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        Vaca objeto = new Vaca();
        objeto.setBrinco(1);
        objeto.setSituacao(1);
        objeto.setOrigem(1);
        objeto.setNascimento(LocalDate.parse("11/01/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setObserva("a");   
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    public static boolean alterar(Vaca objeto) {
        String sql = "UPDATE vaca SET situacao = ?, origem = ?, nascimento = ?, observacao = ?, cod_raca = ?, cod_lac= ?, cod_leite=?, cod_ins=?, cod_mae=? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getSituacao());
            ps.setInt(2, objeto.getOrigem());
            ps.setDate(3, Date.valueOf(objeto.getNascimento()));
            ps.setString(4, objeto.getObserva());
            ps.setInt(5, objeto.getBrinco());
            ps.setInt(6, objeto.getCod_raca().getCodigo());
            ps.setInt(7, objeto.getCod_lac().getCodigo());
            ps.setInt(8, objeto.getCod_leite().getCodigo());
            ps.setInt(9, objeto.getCod_ins().getCodigo());
            ps.setInt(10, objeto.getCod_mae().getBrinco());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
     public static boolean excluir(Vaca objeto) {
        String sql = "DELETE FROM vaca WHERE brinco=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getBrinco());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
     public static List<Vaca> consultar() {
        List<Vaca> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT brinco, situacao, origem, nascimento, observa, cod_raca, cod_lac, cod_leite, cod_ins, cod_mae FROM vaca";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vaca objeto = new Vaca();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setBrinco(rs.getInt("brinco"));
                objeto.setSituacao(rs.getInt("situacao"));
                objeto.setOrigem(rs.getInt("origem"));
                objeto.setNascimento(rs.getDate("nascimento").toLocalDate());
                objeto.setObserva(rs.getString("observa"));
                objeto.setCod_raca(DaoRaca.consultar(rs.getInt("cod_raca"))); //tem que importar DaoTipoProduto
                objeto.setCod_lac(DaoLactacao.consultar(rs.getInt("cod_lac"))); //tem que importar DaoTipoProduto
                objeto.setCod_leite(DaoProducao.consultar(rs.getInt("cod_leite"))); //tem que importar DaoTipoProduto
                objeto.setCod_ins(DaoInseminacao.consultar(rs.getInt("cod_ins"))); //tem que importar DaoTipoProduto
                objeto.setCod_mae(DaoVaca.consultar(rs.getInt("cod_vaca"))); //tem que importar DaoTipoProduto
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
     public static Vaca consultar(int primaryKey) {
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, situacao, origem, nascimento, observa, cod_raca, cod_lac, cod_leite, cod_ins, cod_mae FROM vaca WHERE codigo=?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, primaryKey);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vaca objeto = new Vaca();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setBrinco(rs.getInt("brinco"));
                objeto.setSituacao(rs.getInt("situacao"));
                objeto.setOrigem(rs.getInt("origem"));
                objeto.setNascimento(rs.getDate("nascimento").toLocalDate());
                objeto.setObserva(rs.getString("observa"));
                objeto.setCod_raca(DaoRaca.consultar(rs.getInt("cod_raca"))); //tem que importar DaoTipoProduto
                objeto.setCod_lac(DaoLactacao.consultar(rs.getInt("cod_lac"))); //tem que importar DaoTipoProduto
                objeto.setCod_leite(DaoProducao.consultar(rs.getInt("cod_leite"))); //tem que importar DaoTipoProduto
                objeto.setCod_ins(DaoInseminacao.consultar(rs.getInt("cod_ins"))); //tem que importar DaoTipoProduto
                objeto.setCod_mae(DaoVaca.consultar(rs.getInt("cod_vaca"))); //tem que importar DaoTipoProduto
                
                return objeto;//não mexa nesse, ele adiciona o objeto na lista
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
