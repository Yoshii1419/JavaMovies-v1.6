/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jframes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javamovies.DataBaseManager;
import javamovies.Titles;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

/**
 *
 * @author Yuri.Ramos
 */
public class SearchPanel extends javax.swing.JPanel {

    private ArrayList<Titles> titlesList;
    private ArrayList<TitleListPanel> titleListPanel;
    private Connection conn;
 
    /**
     * Creates new form NovoJPanel
     */
    public SearchPanel() {
        initComponents();
        
        // setando icone do botão de busca //
        ImageIcon imgIcon = new ImageIcon("C:\\Users\\yuri.ramos\\Downloads\\JavaMovies-V4\\image_java_project\\search.png");
        Image image = imgIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        this.GoButton.setIcon(new ImageIcon(image));
        
        // setando itens do combo box //
        this.SearchComboBox.addItem("Title");
        this.SearchComboBox.addItem("Director");
        this.SearchComboBox.addItem("Genre");
        this.SearchComboBox.addItem("Year");
        this.SearchComboBox.addItem("Writer");
        
        this.RegisterNumberLabel.setText("");
        this.jLabelLoader.setText(null);
    }

    public void AddToTitlePanels() {
        
        this.jPanelPrincipal.removeAll(); // limpando Panel principal para nova exibição //
       
        // setando jpanel principal //
        this.jPanelPrincipal.setVisible(true);
        this.jPanelPrincipal.setLayout(new BoxLayout(this.jPanelPrincipal, BoxLayout.PAGE_AXIS));
        
        this.titleListPanel = new ArrayList<TitleListPanel>();
        
        for(int i = 0; i < this.titlesList.size(); i++){
            System.out.println("Title: " + this.titlesList.get(i).getTitleName() + "  Year: " + this.titlesList.get(i).getReleaseYear() + "\n");
            
            TitleListPanel titleList = new TitleListPanel();
            titleList.setPreferredSize(new Dimension(502, 181));
            titleList.setBorder(new LineBorder(Color.black));
            titleList.setTitles(this.titlesList.get(i));
            titleList.setPanelAttributes();
            
            // pinta cor na lista de Panels //
            titleList.setBackground(new Color(230,230,250));

            this.titleListPanel.add(titleList);
            this.jPanelPrincipal.add(this.titleListPanel.get(i));
        }
        
        this.jPanelPrincipal.revalidate();
        this.jPanelPrincipal.repaint();
    }
    
    void ConnectToDatabase(){
        // estabelecendo conexão com o banco de dados //
        conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/movies_database";
            String user = "root";
            String password = "";

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to the database");
            }

        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mainwindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        SearchTextField = new javax.swing.JTextField();
        SearchComboBox = new javax.swing.JComboBox<>();
        GoButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelPrincipal = new javax.swing.JPanel();
        RegisterNumberLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setPreferredSize(new java.awt.Dimension(597, 350));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Search Titles");

        SearchTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SearchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchComboBoxActionPerformed(evt);
            }
        });

        GoButton.setBorder(null);
        GoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoButtonActionPerformed(evt);
            }
        });
        GoButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GoButtonKeyPressed(evt);
            }
        });

        jScrollPane1.setToolTipText("");
        jScrollPane1.setPreferredSize(new java.awt.Dimension(525, 250));

        jPanelPrincipal.setBackground(new java.awt.Color(201, 189, 231));
        jPanelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanelPrincipal);

        RegisterNumberLabel.setText("nº registers");

        jLabelLoader.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(SearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegisterNumberLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelLoader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(GoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addComponent(SearchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addComponent(SearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelLoader, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                .addComponent(RegisterNumberLabel))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(91, 91, 91)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SearchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchComboBoxActionPerformed
        
    private void GoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoButtonActionPerformed
        // TODO add your handling code here:
        
        String search = this.SearchTextField.getText();
        String filter = this.SearchComboBox.getSelectedItem().toString();
        
        this.titlesList = new ArrayList<Titles>();
        
        ImageIcon  imgIcon = new ImageIcon("C:\\Users\\yuri.ramos\\Downloads\\JavaMovies-V4\\image_java_project\\loader.gif");
        imgIcon.setImage(imgIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
        jLabelLoader.setIcon(imgIcon);
        
        // Thread t1 executa busca dos títulos no banco de dados //
        Thread t1 = new Thread() {
            public void run() {
                DataBaseManager dataBase = new DataBaseManager();
                // Abrindo conexão com o banco //
                dataBase.OpenConnectionDataBase();
                // Executando query de seleção e recuperando lista de titulos //
                titlesList = dataBase.ExecuteQuerySelectTitles(search, filter);
                // Encerrando conexão com o banco //
                dataBase.CloseConnection();
                
                AddToTitlePanels();
                jLabelLoader.setIcon(null);
                RegisterNumberLabel.setText(titlesList.size() + " titles founds.");   
            }
        };
        t1.start(); 
        
        
    }//GEN-LAST:event_GoButtonActionPerformed

    private void GoButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GoButtonKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_GoButtonKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GoButton;
    private javax.swing.JLabel RegisterNumberLabel;
    private javax.swing.JComboBox<String> SearchComboBox;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JLabel jLabel2;
    private final javax.swing.JLabel jLabelLoader = new javax.swing.JLabel();
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
