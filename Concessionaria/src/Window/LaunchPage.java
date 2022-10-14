package Window;

import bd.dbos.*;
import bd.daos.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.*;

public class LaunchPage implements ActionListener{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel(new GridLayout(3,1));
    JLabel label = new JLabel("Concessionária");
    JButton marca = new JButton("Marca");
    JButton carro = new JButton("Carro");
    JButton sair = new JButton("Sair");
    
    public LaunchPage(){

        label.setFont(new Font("Bahnschrift",Font.PLAIN,20));
        label.setFocusable(false);


        marca.setFont(new Font("Bahnschrift",Font.PLAIN,20));
        marca.setFocusable(false);
        marca.addActionListener(this);

        carro.setFont(new Font("Bahnschrift",Font.PLAIN,20));
        carro.setFocusable(false);
        carro.addActionListener(this);

        sair.setFont(new Font("Bahnschrift",Font.PLAIN,20));
        sair.setFocusable(false);
        sair.addActionListener(this);

        panel.add(marca);
        panel.add(carro);
        panel.add(sair);

        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,500);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==marca)
        {
            
            cadMarca janela = new cadMarca(); 
        }

        if(e.getSource()==carro)
        {
            
            cadCarro janela = new cadCarro(); 
        }

        
        if(e.getSource()==sair)
        {
            System.exit(0);
        }
    }
}