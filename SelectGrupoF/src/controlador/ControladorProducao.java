/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoProducao;
import javax.swing.JOptionPane;
import modelo.Producao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tela.manutencao.ManutencaoProducao;

/**
 *
 * @author Clovis
 */
public class ControladorProducao {

    public static void inserir(ManutencaoProducao man){
        Producao objeto = new Producao();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setTurno(Integer.parseInt(man.jtfTurno.getText()));
        objeto.setData(LocalDate.parse(man.jtfData.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setTotal(Integer.parseInt(man.jtfTotal.getText()));
        objeto.setObs(man.jtfObs.getText());
        objeto.setCod_pessoa((Cod_pessoa)man.jcbCod_pessoa.getSelectedItem());
        
        boolean resultado = DaoProducao.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}

    public static void alterar(ManutencaoProducao man){
        Producao objeto = new Producao();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setTurno(Integer.parseInt(man.jtfTurno.getText()));
        objeto.setData(LocalDate.parse(man.jtfData.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setTotal(Integer.parseInt(man.jtfTotal.getText()));
        objeto.setObs(man.jtfObs.getText());
        objeto.setCod_pessoa((Cod_pessoa)man.jcbCod_pessoa.getSelectedItem());
        
        boolean resultado = DaoProducao.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

    public static void excluir(ManutencaoProducao man){
        Producao objeto = new Producao();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoProducao.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Código");
        modelo.addColumn("Turno");
        modelo.addColumn("Data");
        modelo.addColumn("Total");
        modelo.addColumn("Observação");
        modelo.addColumn("Código do produtor");
        List<Producao> resultados = DaoProducao.consultar();
        for (Producao objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getTurno());
            linha.add(objeto.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            linha.add(objeto.getTotal());
            linha.add(objeto.getObs());
            linha.add(objeto.getCod_pessoa());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
    public static void atualizaCampos(ManutencaoProducao man, int pk){ 
        Producao objeto = DaoProducao.consultar(pk);
        //Definindo os valores do campo na tela (um para cada atributo/campo)
        man.jtfCodigo.setText(objeto.getCodigo().toString());
        man.jtfTurno.setText(objeto.getTurno().toString());
        man.jtfData.setText(objeto.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        man.jtfTotal.setText(objeto.getTotal().toString());
        man.jtfObs.setText(objeto.getObs());
        man.jcbCod_pessoa.setSelectedItem(objeto.getCod_pessoa());
        
        man.jtfCodigo.setEnabled(false); //desabilitando o campo código
        man.btnAdicionar.setEnabled(false); //desabilitando o botão adicionar
    }
    public static void atualizaComboCod_pessoa(ManutencaoProducao man) {
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(DaoCod_pessoa.consultar().toArray());
        man.jcbCod_pessoa.setModel(defaultComboBoxModel);
}
}
