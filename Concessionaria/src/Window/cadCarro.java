package Window;

import bd.dbos.*;
import bd.daos.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class cadCarro implements ActionListener 
{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel(new GridLayout(13,1));
    JLabel label = new JLabel("idMarca: ");
    JTextField idMarca = new JTextField();
    JLabel label1 = new JLabel("idCarro: ");
    JTextField idCarro = new JTextField();
    JLabel label2 = new JLabel("modelo: ");
    JTextField modelo = new JTextField();
    JButton incluir = new JButton("Incluir Dados");
    JButton visualizar = new JButton("Buscar");
    JButton verTabela = new JButton("Ver tabela");
    JButton atualizar = new JButton("Atualizar linha");
    JButton deletar = new JButton("Deletar linha (informe apenas o ID)");
    JButton voltar = new JButton("Voltar para tela principal");

    cadCarro()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,500);
        frame.setVisible(true);
        
        panel.add(label);
        panel.add(idMarca);
        panel.add(label1);
        panel.add(idCarro);
        panel.add(label2);
        panel.add(modelo);
        panel.add(incluir);
        panel.add(visualizar);
        panel.add(verTabela);
        panel.add(atualizar);
        panel.add(deletar);
        panel.add(voltar);
        frame.add(panel);

        incluir.addActionListener(this);
        visualizar.addActionListener(this);
        verTabela.addActionListener(this);
        atualizar.addActionListener(this);
        deletar.addActionListener(this);
        voltar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==incluir)
        {
            try {
            Carro data = new Carro(Integer.parseInt(idMarca.getText()), Integer.parseInt(idCarro.getText()), modelo.getText());
            Carros.incluir(data);
            JOptionPane.showMessageDialog(frame,"Dados incluídos com sucesso total!!!");
            }
            catch(Exception erro)
            {
                erro.printStackTrace();
                JOptionPane.showMessageDialog(frame,"Não foi possível incluir os dados!");
            }
        }
        if(e.getSource()==visualizar)
        {
            try
            {
                Carro data = Carros.getCarro(Integer.parseInt(idCarro.getText()));
        
                idMarca.setText(""+data.getIdMarca());
                idCarro.setText(""+data.getIdCarro());
                modelo.setText(data.getModelo());
            }
            catch(Exception erro)
            {
                erro.printStackTrace();
                JOptionPane.showMessageDialog(frame,"Não foi possível visualizar os dados!");
            }
        }
        if(e.getSource()==verTabela)
        {
            new tabelaCarro();
        }

        if(e.getSource()==atualizar)
        {
            try {
                Carro data = new Carro(Integer.parseInt(idMarca.getText()), Integer.parseInt(idCarro.getText()), modelo.getText());
                Carros.alterar(data);
                JOptionPane.showMessageDialog(frame,"Dados atualizados!");
                }
            catch(Exception erro)
                {
                    erro.printStackTrace();
                    JOptionPane.showMessageDialog(frame,"Não foi possível atualizar os dados!");
                }
        }

        if(e.getSource()==deletar)
        {
            try {
                    Carros.excluir(Integer.parseInt(idCarro.getText()));
                    JOptionPane.showMessageDialog(frame,"Dados deletados com sucesso total!!!");
                }
            catch(Exception erro)
                {
                    erro.printStackTrace();
                    JOptionPane.showMessageDialog(frame,"Não foi possível deletar os dados!");
                }
        }
        if(e.getSource()==voltar)
        {
            frame.dispose();
        }
    }

}