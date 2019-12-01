/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoManejoVaca;
import javax.swing.JOptionPane;
import modelo.ManejoVaca;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tela.manutencao.ManutencaoManejoVaca;

/**
 *
 * 
 */
public class ControladorManejoVaca {

    public static void inserir(ManutencaoManejoVaca man){
        ManejoVaca objeto = new ManejoVaca();
        objeto.setCod_man((Manejo)man.jcbCod_man.getSelectedItem());
        objeto.setCod_vaca((Vaca)man.jcbCod_vaca.getSelectedItem());
        
        
        boolean resultado = DaoManejoVaca.inserir(objeto);
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

    public static void alterar(ManutencaoManejoVaca man){
        ManejoVaca objeto = new ManejoVaca ();
        //definir todos os atributos
        objeto.setCod_man((Manejo)man.jcbCod_man.getSelectedItem());
         objeto.setCod_vaca((Vaca)man.jcbCod_vaca.getSelectedItem());
        
        
        
        boolean resultado = DaoManejoVaca .alterar(objeto);
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

    public static void excluir(ManutencaoManejoVaca man){
        ManejoVaca objeto = new ManejoVaca();
        
       objeto.setCod_man((Manejo)man.jcbCod_man.getSelectedItem());
       objeto.setCod_vaca((Vaca)man.jcbCod_vaca.getSelectedItem());
        
        boolean resultado = DaoManejoVaca.excluir(objeto);
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
        modelo.addColumn("Código do Manejo");
        modelo.addColumn("Código da Vaca");
     
        List<ManejoVaca> resultados = DaoManejoVaca.consultar();
        for (ManejoVaca objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCod_man());
            linha.add(objeto.getCod_vaca());
            
          
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
    public static void atualizaCampos(ManutencaoManejoVaca man, int pk){ 
        ManejoVaca objeto = DaoManejoVaca.consultar(pk);
        //Definindo os valores do campo na tela (um para cada atributo/campo)
        man.jcbCod_man.setSelectedItem(objeto.getCod_man());
        man.jcbCod_vaca.setSelectedItem(objeto.getCod_vaca());
        
       
        man.jcbCod_man.setEnabled(false); //desabilitando o campo código
        man.jcbCod_vaca.setEnabled(false); 
        man.btnAdicionar.setEnabled(false); //desabilitando o botão adicionar
    }
    
    public static void atualizaComboCod_man(ManutencaoManejoVaca man) {
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(DaoManejoVaca.consultar().toArray());
        man.jcbCod_man.setModel(defaultComboBoxModel);
}
    public static void atualizaComboCod_vaca(ManutencaoManejoVaca man) {
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(DaoManejoVaca.consultar().toArray());
        man.jcbCod_vaca.setModel(defaultComboBoxModel);
}
}
