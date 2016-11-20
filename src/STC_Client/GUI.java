package STC_Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marcus
 */
public class GUI extends JFrame {
    
    JPanel mid = new JPanel();

    public GUI() {

        

        super.setTitle("STC Client");
        setLayout(new BorderLayout());

        //THE LEFT PANEL, 
        JPanel west = new JPanel();
       // west.setBorder(new EmptyBorder(5,5,5,5));
        west.setLayout(new GridLayout(20,1));
        
       //CLIENT OPTIONS
        west.add(new JLabel("Företag:"));
        JButton newClientB = new JButton("Nytt");
        newClientB.setPreferredSize(new Dimension(40,400));
        west.add(newClientB);
        newClientB.addActionListener(new NewClientLis());
        add(west, BorderLayout.WEST);
        JButton showB = new JButton("Visa");
        showB.addActionListener(new ShowClientLis());
        west.add(showB);
        
        JButton changeClientB = new JButton("Ändra");
        west.add(changeClientB);
        
        //HOTEL OPTIONS
        west.add(new JLabel("Hotell:"));
        
        //DYNAMIC MID FRAME
        JScrollPane midScroll = new JScrollPane(mid);
        add(midScroll, BorderLayout.CENTER);
                       
        //MAIN WINDOW CONFIG
        setSize(1000, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    
    public class NewClientLis implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
               //LEFT MID PANEL 
            Client c = new Client();
            JPanel midWest = new JPanel();
            JPanel midEast = new JPanel();            
            JPanel r1 = new JPanel();
            midWest.add(r1);
            r1.add(new JLabel("FöretagsID: "));
            JTextField id = new JTextField(10);
            int i = c.getID();
            id.setText(i+"");
            id.setEditable(false);
            r1.add(id);
                        
            JPanel r2 = new JPanel();
            r2.add(new JLabel("Företagsnamn: "));
            JTextField name = new JTextField(30);
            r2.add(name);
            midWest.add(r2);
            
            JPanel r3 = new JPanel();
            r3.add(new JLabel("Adress: "));
            JTextField address = new JTextField(30);
            r3.add(address);
            midWest.add(r3);
            
            JPanel r4 = new JPanel();
            r4.add(new JLabel("Post nr: "));
            JTextField postNr = new JTextField(15);
            r4.add(postNr);
            r4.add(new JLabel("ort"));
            JTextField ort = new JTextField(20);
            r4.add(ort);
            midWest.add(r4);
            
            JPanel r5 = new JPanel();
            r5.add(new JLabel("Telefon: "));
            JTextField tel = new JTextField(30);
            r5.add(tel);
            midWest.add(r5);
            
            JPanel r6 = new JPanel();
            r6.add(new JLabel("Mobil: "));
            JTextField mob = new JTextField(30);
            r6.add(mob);
            midWest.add(r6);
            
            JPanel r7 = new JPanel();
            r7.add(new JLabel("Fax: "));
            JTextField fax = new JTextField(30);
            r7.add(fax);
            midWest.add(r7);
            
            JPanel r8 = new JPanel();
            r8.add(new JLabel("E-post: "));
            JTextField epost = new JTextField(30);
            r8.add(epost);
            midWest.add(r8);
            
            JPanel r9 = new JPanel();
            r9.add(new JLabel("E-post för\nStatestik: "));
            JTextArea epostStat = new JTextArea(4,15);
             JScrollPane scES = new JScrollPane(epostStat);
            r9.add(scES);
            midWest.add(r9);
            
            //ADD LOGIC BUTTON GROUP
            JPanel r10 = new JPanel();
            r10.add(new JLabel("Fakturaunderlag: "));
            JRadioButton yes = new JRadioButton("Ja");
            r10.add(yes);
            JRadioButton no = new JRadioButton("Nej");
            r10.add(no);
            midWest.add(r10);
            
            JPanel r11 = new JPanel();
            r11.add(new JLabel("Pris per natt: "));
            JTextField ppn = new JTextField(20);
            r11.add(ppn);
            midWest.add(r11);
            
            JPanel r12 = new JPanel();
            r12.add(new JLabel("Nattdebitering: "));
            JRadioButton yes1 = new JRadioButton("Ja");
            r12.add(yes1);
            JRadioButton no1 = new JRadioButton("Nej");
            r12.add(no1);
            midWest.add(r12);
            
            JPanel r13 = new JPanel();
            r13.add(new JLabel("Pris per natt: "));
            JTextField ppn1 = new JTextField(20);
            r13.add(ppn1);
            midWest.add(r13);
            
             JPanel r14 = new JPanel();
            r14.add(new JLabel("E-post för\nStatestik: "));
            JTextArea maxPrice = new JTextArea(4,15);
             JScrollPane scES1 = new JScrollPane(maxPrice);
            r14.add(scES1);
            midWest.add(r14);
            
            //RIGHT MID PANEL
            JPanel r01 = new JPanel();
            r01.add(new JLabel("Kundprofil: "));
            midEast.add(r01);
            
            JPanel r02 = new JPanel();
            JTextArea custProf = new JTextArea(5,30);
            r02.add(custProf);
            midEast.add(r02);
            
            JPanel r03 = new JPanel();
            r03.add(new JLabel("Övrigt: "));
            midEast.add(r03);
            
            JPanel r04 = new JPanel();
            JTextArea other = new JTextArea(5,30);
            r04.add(other);
            midEast.add(r04);
            
            JPanel r05 = new JPanel();
            r05.add(new JLabel("Notering "));
            midEast.add(r05);
            
            JPanel r06 = new JPanel();
            JTextArea note = new JTextArea(5,30);
            r06.add(note);
            midEast.add(r06);
            
            JPanel r07 = new JPanel();
            r07.add(new JLabel("Vill ha nyhetsbrev: "));
            ButtonGroup NB = new ButtonGroup();
            JRadioButton yes2 = new JRadioButton("Ja");
                     
            mid.add(midWest, BorderLayout.WEST);
            mid.add(midEast, BorderLayout.EAST);
            midWest.setLayout(new BoxLayout(midWest, BoxLayout.Y_AXIS));
            midEast.setLayout(new BoxLayout(midEast, BoxLayout.Y_AXIS));
            mid.revalidate();
            midWest.revalidate();
            midEast.revalidate();
     
            
        }
    }
    
    //TEST THE ARRAYLIST READING
    public class ShowClientLis implements ActionListener{
        public void actionPerformed(ActionEvent e){
            SQLConnectivity con = new SQLConnectivity();        
            ArrayList <Client> clients = new ArrayList<>();
           try{
            clients = con.getClients();
           }catch (Exception ea){
               System.out.print(ea);
           }
           for(int i=0;i<clients.size();i++){
               System.out.println(clients.get(i));
           }
        }
    }

}
