package Window;

import bd.dbos.*;
import bd.core.MeuResultSet;
import bd.daos.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class tabelaCarro
{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel(new GridLayout(1,1));

    JTextArea area = new JTextArea(20,10);
    
    tabelaCarro()
    {
        String dados = "";

        try {
            MeuResultSet result = Carros.getCarros();
            while(result.next())
                dados += ""+result.getInt("idMarca")+"       "+result.getInt("idCarro")+"       "
                +result.getString("modelo")+"\n";
        } catch (Exception e) {
           JOptionPane.showMessageDialog(frame,"ERROR");
        }   
        area.setText(dados);
        panel.add(area);
        frame.setSize(400,300);
        frame.setVisible(true);
        frame.add(panel);
    }
}
