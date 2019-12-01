/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoVaca;
import javax.swing.JOptionPane;
import modelo.Vaca;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tela.manutencao.ManutencaoVaca;

/**
 *
 * @author Clovis
 */
public class ControladorVaca{

    public static void inserir(ManutencaoVaca man){
        Vaca objeto = new Vaca();
        objeto.setBrinco(Integer.parseInt(man.jtfBrinco.getText()));
        objeto.setSituacao(Integer.parseInt(man.jtfSituacao.getText()));
        objeto.setOrigem(Integer.parseInt(man.jtfOrigem.getText()));
        objeto.setNascimento(LocalDate.parse(man.jtfNascimento.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setObserva(man.jtfObserva.getText());
        objeto.setCod_raca((Raca)man.jcbCod_raca.getSelectedItem());
        objeto.setCod_lac((Lactacao)man.jcbCod_lac.getSelectedItem());
        objeto.setCod_leite((Leite)man.jcbCod_leite.getSelectedItem());
        objeto.setCod_ins((Inseminacao)man.jcbCod_ins.getSelectedItem());
        objeto.setCod_mae((Vaca)man.jcbCod_mae.getSelectedItem());
        
        boolean resultado = DaoVaca.inserir(objeto);
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

    public static void alterar(ManutencaoVaca man){
        Vaca objeto = new Vaca();
        //definir todos os atributos
        objeto.setBrinco(Integer.parseInt(man.jtfBrinco.getText()));
        objeto.setSituacao(Integer.parseInt(man.jtfSituacao.getText()));
        objeto.setOrigem(Integer.parseInt(man.jtfOrigem.getText()));
        objeto.setNascimento(LocalDate.parse(man.jtfNascimento.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setObserva(man.jtfObserva.getText());
        objeto.setCod_raca((Raca)man.jcbCod_raca.getSelectedItem());
        objeto.setCod_lac((Lactacao)man.jcbCod_lac.getSelectedItem());
        objeto.setCod_leite((Leite)man.jcbCod_leite.getSelectedItem());
        objeto.setCod_ins((Inseminacao)man.jcbCod_ins.getSelectedItem());
        objeto.setCod_mae((Vaca)man.jcbCod_mae.getSelectedItem());
        
        boolean resultado = DaoVaca.alterar(objeto);
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

    public static void excluir(ManutencaoVaca man){
        Vaca objeto = new Vaca();
        objeto.setBrinco(Integer.parseInt(man.jtfBrinco.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoVaca.excluir(objeto);
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
        modelo.addColumn("Brinco");
        modelo.addColumn("Situação");
        modelo.addColumn("Origem");
        modelo.addColumn("Nascimento");
        modelo.addColumn("Observação");
        modelo.addColumn("Código da Raça");
        modelo.addColumn("Código da Lactação");
        modelo.addColumn("Código da produção");
        modelo.addColumn("Código da Inseminação");
        modelo.addColumn("Código da Mãe");
        
        
        List<Vaca> resultados = DaoVaca.consultar();
        for (Vaca objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getBrinco());
            linha.add(objeto.getSituacao());
            linha.add(objeto.getOrigem());
            linha.add(objeto.getNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            linha.add(objeto.getObserva());
            linha.add(objeto.getCod_raca());
            linha.add(objeto.getCod_lac());
            linha.add(objeto.getCod_leite());
            linha.add(objeto.getCod_ins());
            linha.add(objeto.getCod_mae());
            
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
    public static void atualizaCampos(ManutencaoVaca man, int pk){ 
        Vaca objeto = DaoVaca.consultar(pk);
        //Definindo os valores do campo na tela (um para cada atributo/campo)
        man.jtfBrinco.setText(objeto.getBrinco().toString());
        man.jtfSituacao.setText(objeto.getSituacao().toString());
        man.jtfNascimento.setText(objeto.getNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        man.jtfOrigem.setText(objeto.getOrigem().toString());
        man.jtfObserva.setText(objeto.getObserva());
        
        man.jtfBrinco.setEnabled(false); //desabilitando o campo código
        man.btnAdicionar.setEnabled(false); //desabilitando o botão adicionar
    }
    
        public static void atualizaComboCod_raca(ManutencaoVaca man) {
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(DaoVaca.consultar().toArray());
        man.jcbCod_raca.setModel(defaultComboBoxModel);
        }
        public static void atualizaComboCod_lac(ManutencaoLactacao man) {
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(DaoLactacao.consultar().toArray());
        man.jcbCod_lac.setModel(defaultComboBoxModel);
        }
        public static void atualizaComboCod_leite(ManutencaoProducao man) {
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(DaoProducao.consultar().toArray());
        man.jcbCod_leite.setModel(defaultComboBoxModel);
        }
        public static void atualizaComboCod_ins(ManutencaoInseminacao man) {
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(DaoTipoProduto.consultar().toArray());
        man.jcbCod_ins.setModel(defaultComboBoxModel);
        }
        public static void atualizaComboCod_vaca(ManutencaoVaca man) {
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(DaoTipoProduto.consultar().toArray());
        man.jcbCod_mae.setModel(defaultComboBoxModel);
        }
       