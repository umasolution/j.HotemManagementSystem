/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dbconnect.DatabaseHelper;
import static event.EventManager.USER;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.lang.Thread.sleep;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import login.login;

/**
 *
 * @author Sakibul
 */
public class Reports extends javax.swing.JFrame {

    /**
     * Creates new form Reports
     */
    static String USER;
    SimpleDateFormat sdf;
    DefaultTableModel model;
    DefaultTableModel model1;
    public Reports(String username) {
        USER = username;
        initComponents();
        searchbyid.setVisible(false);
        pnlsdt.setVisible(false);
        seacrchbet.setVisible(false);
        model = new DefaultTableModel();
        custable.setModel(model);
        model.addColumn("Customer Name");
        model.addColumn("Event Id");
        model.addColumn("Address");
        model.addColumn("Customer NID");
        model.addColumn("Event Date");
        model.addColumn("Total");

        model1 = new DefaultTableModel();
        custable1.setModel(model1);
        model1.addColumn("Customer Name");
        model1.addColumn("Event Id");
        model1.addColumn("Address");
        model1.addColumn("Customer NID");
        model1.addColumn("Event Date");
        model1.addColumn("Total");
        
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2,
                size.height / 2 - getHeight() / 2);

        new Thread() {
            public void run() {
                for (;;) {
                    sdf = new SimpleDateFormat("hh:mm:ss a");
                    Date d = new Date();
                    //System.out.println(sdf.format(d));
                    Time.setText(sdf.format(d));
                    sdf = new SimpleDateFormat("dd-MMM-yyyy");

                    dates.setText(sdf.format(d));

                    sdf = new SimpleDateFormat("EEEE");
                    // Date d3 = new Date();
                    day.setText(sdf.format(d));

                    try {
                        sleep(1000);
                    } catch (Exception e) {
                    }

                }

            }
        }.start();

        welcomeuser.setText(USER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        welcomeuser = new javax.swing.JLabel();
        welcomeuser1 = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        dates = new javax.swing.JLabel();
        day = new javax.swing.JLabel();
        buttonLogOut = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnbydate = new javax.swing.JButton();
        btnbyname = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        searchbyid = new javax.swing.JPanel();
        btnsearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtroomno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnid = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtbill = new javax.swing.JTextField();
        btnprint = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        pnlsdt = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        custable = new javax.swing.JTable();
        seacrchbet = new javax.swing.JPanel();
        startdt = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        custable1 = new javax.swing.JTable();
        enddt = new com.toedter.calendar.JDateChooser();
        jMenuBar1 = new javax.swing.JMenuBar();
        Back = new javax.swing.JMenu();
        Home = new javax.swing.JMenu();
        Exit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerPanel.setBackground(new java.awt.Color(0, 51, 51));
        headerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255), 2));
        headerPanel.setLayout(null);

        welcomeuser.setFont(new java.awt.Font("Monotype Corsiva", 3, 30)); // NOI18N
        welcomeuser.setForeground(new java.awt.Color(240, 240, 240));
        welcomeuser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeuser.setText("Name");
        headerPanel.add(welcomeuser);
        welcomeuser.setBounds(420, 60, 170, 20);

        welcomeuser1.setFont(new java.awt.Font("Monotype Corsiva", 3, 36)); // NOI18N
        welcomeuser1.setForeground(new java.awt.Color(240, 240, 240));
        welcomeuser1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeuser1.setText("WELCOME ");
        headerPanel.add(welcomeuser1);
        welcomeuser1.setBounds(370, 10, 270, 30);

        Time.setFont(new java.awt.Font("Monotype Corsiva", 3, 30)); // NOI18N
        Time.setForeground(new java.awt.Color(240, 240, 240));
        Time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Time.setText("Time");
        headerPanel.add(Time);
        Time.setBounds(190, 90, 170, 30);

        dates.setFont(new java.awt.Font("Monotype Corsiva", 3, 30)); // NOI18N
        dates.setForeground(new java.awt.Color(240, 240, 240));
        dates.setText("date");
        headerPanel.add(dates);
        dates.setBounds(640, 90, 210, 30);

        day.setFont(new java.awt.Font("Monotype Corsiva", 3, 30)); // NOI18N
        day.setForeground(new java.awt.Color(240, 240, 240));
        day.setText("Day");
        headerPanel.add(day);
        day.setBounds(450, 90, 140, 30);

        buttonLogOut.setBackground(new java.awt.Color(255, 255, 255));
        buttonLogOut.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        buttonLogOut.setForeground(new java.awt.Color(51, 153, 255));
        buttonLogOut.setText("Log Out");
        buttonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogOutActionPerformed(evt);
            }
        });
        headerPanel.add(buttonLogOut);
        buttonLogOut.setBounds(910, 80, 77, 33);

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));

        btnbydate.setText("Search By Date");
        btnbydate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbydateActionPerformed(evt);
            }
        });

        btnbyname.setText("Search By NID");
        btnbyname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbynameActionPerformed(evt);
            }
        });

        jButton2.setText("Search between");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnbydate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbyname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btnbydate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnbyname, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        searchbyid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnsearch.setText("search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        jLabel1.setText("Customer Name :");

        jLabel2.setText("Event ID :");

        jLabel7.setText("Customer NID :");

        jLabel8.setText("Total Bill :");

        btnprint.setText("Print");
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });

        jLabel9.setText("Enter NID Number");

        javax.swing.GroupLayout searchbyidLayout = new javax.swing.GroupLayout(searchbyid);
        searchbyid.setLayout(searchbyidLayout);
        searchbyidLayout.setHorizontalGroup(
            searchbyidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchbyidLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(searchbyidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(50, 50, 50)
                .addGroup(searchbyidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtroomno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(txtname, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(searchbyidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(53, 53, 53)
                .addGroup(searchbyidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbill)
                    .addComponent(txtnid, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
            .addGroup(searchbyidLayout.createSequentialGroup()
                .addGroup(searchbyidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchbyidLayout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel9)
                        .addGap(31, 31, 31)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnsearch))
                    .addGroup(searchbyidLayout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(btnprint)))
                .addContainerGap(233, Short.MAX_VALUE))
        );
        searchbyidLayout.setVerticalGroup(
            searchbyidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchbyidLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchbyidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsearch)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(27, 27, 27)
                .addGroup(searchbyidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(searchbyidLayout.createSequentialGroup()
                        .addGroup(searchbyidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(searchbyidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtroomno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(searchbyidLayout.createSequentialGroup()
                        .addGroup(searchbyidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtnid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(searchbyidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(txtbill))))
                .addGap(47, 47, 47)
                .addComponent(btnprint)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        pnlsdt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        custable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Room Number", "Address", "Contact Number", "Customer NID", "Arrival Date", "Departure Date", "Total Bill"
            }
        ));
        jScrollPane1.setViewportView(custable);

        javax.swing.GroupLayout pnlsdtLayout = new javax.swing.GroupLayout(pnlsdt);
        pnlsdt.setLayout(pnlsdtLayout);
        pnlsdtLayout.setHorizontalGroup(
            pnlsdtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlsdtLayout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(333, Short.MAX_VALUE))
            .addGroup(pnlsdtLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlsdtLayout.setVerticalGroup(
            pnlsdtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlsdtLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlsdtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        seacrchbet.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        custable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Room Number", "Address", "Contact Number", "Customer NID", "Arrival Date", "Departure Date", "Total Bill"
            }
        ));
        jScrollPane2.setViewportView(custable1);

        javax.swing.GroupLayout seacrchbetLayout = new javax.swing.GroupLayout(seacrchbet);
        seacrchbet.setLayout(seacrchbetLayout);
        seacrchbetLayout.setHorizontalGroup(
            seacrchbetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seacrchbetLayout.createSequentialGroup()
                .addGroup(seacrchbetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(seacrchbetLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(seacrchbetLayout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(startdt, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(enddt, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 172, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, seacrchbetLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(371, 371, 371))
        );
        seacrchbetLayout.setVerticalGroup(
            seacrchbetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seacrchbetLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(seacrchbetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enddt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(searchbyid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(seacrchbet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(searchbyid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(44, Short.MAX_VALUE)
                    .addComponent(pnlsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(37, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(seacrchbet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Back.setText("Back");
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        jMenuBar1.add(Back);

        Home.setText("Home");
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeMouseClicked(evt);
            }
        });
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });
        jMenuBar1.add(Home);

        Exit.setText("Exit");
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitMouseClicked(evt);
            }
        });
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jMenuBar1.add(Exit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        // TODO add your handling code here:
        EventManager mp = new EventManager(USER);
        mp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackActionPerformed

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked
        // TODO add your handling code here:
        EventManager HM = new EventManager(USER);
        HM.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_HomeMouseClicked

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HomeActionPerformed

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_ExitMouseClicked

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitActionPerformed

    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogOutActionPerformed
        int result = JOptionPane.showConfirmDialog(rootPane, "Do You Want to LogOut");
        if (result == 0) {

            login login = new login();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_buttonLogOutActionPerformed

    private void btnbydateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbydateActionPerformed
        pnlsdt.setVisible(true);
        searchbyid.setVisible(false);
        seacrchbet.setVisible(false);
    }//GEN-LAST:event_btnbydateActionPerformed

    private void btnbynameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbynameActionPerformed
        searchbyid.setVisible(true);
        pnlsdt.setVisible(false);
        seacrchbet.setVisible(false);
    }//GEN-LAST:event_btnbynameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        seacrchbet.setVisible(true);
        searchbyid.setVisible(false);
        pnlsdt.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String dt = txtid.getText();
        //String dt = ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText();
        try {
            con = DatabaseHelper.getDBConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from eventbill where CustomerNid='" + dt + "'");
            while (rs.next()) {

                txtname.setText(rs.getString("CustomerName"));
                txtroomno.setText(rs.getString("event_id"));
                txtnid.setText(rs.getString("CustomerNid"));
                txtbill.setText(rs.getString("Total"));

            }
            rs.close();
            con.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
        try {

            Document doc = new Document();
            try {

                PdfWriter.getInstance(doc, new FileOutputStream("visitorlist.pdf"));

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Bills.class.getName()).log(Level.SEVERE, null, ex);
            }

            doc.open();
            PdfPTable pt = new PdfPTable(1);
            doc.add(new Paragraph("                              Bills"));
            pt.addCell("Customer Name :" + txtname.getText());
            pt.addCell("Event Id :" + txtroomno.getText());

            pt.addCell("Customer NID :" + txtnid.getText());

            pt.addCell("Total Bill :" + txtbill.getText());

            doc.add(pt);
            doc.close();
        } catch (DocumentException ex) {
            Logger.getLogger(Bills.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnprintActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String dat = ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText();
        try {
            con = DatabaseHelper.getDBConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from eventbill where event_date='" + dat + "'");
            while (rs.next()) {

                model.addRow(new Object[]{rs.getString("CustomerName"), rs.getString("event_id"), rs.getString("CustomerNid"),rs.getString("event_date"), rs.getString("Total")});

            }
            rs.close();
            con.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String dat = ((JTextField) startdt.getDateEditor().getUiComponent()).getText();
        String dat1 = ((JTextField) enddt.getDateEditor().getUiComponent()).getText();
        try {
            con = DatabaseHelper.getDBConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from eventbill where event_date between '" + dat + "' and '" + dat1 + "'");
            while (rs.next()) {

                model1.addRow(new Object[]{rs.getString("CustomerName"), rs.getString("event_id"), rs.getString("CustomerNid"), rs.getString("event_date"), rs.getString("Total")});

            }
            rs.close();
            con.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reports(USER).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Back;
    private javax.swing.JMenu Exit;
    private javax.swing.JMenu Home;
    private javax.swing.JLabel Time;
    private javax.swing.JButton btnbydate;
    private javax.swing.JButton btnbyname;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton buttonLogOut;
    private javax.swing.JTable custable;
    private javax.swing.JTable custable1;
    private javax.swing.JLabel dates;
    private javax.swing.JLabel day;
    private com.toedter.calendar.JDateChooser enddt;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlsdt;
    private javax.swing.JPanel seacrchbet;
    private javax.swing.JPanel searchbyid;
    private com.toedter.calendar.JDateChooser startdt;
    private javax.swing.JTextField txtbill;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnid;
    private javax.swing.JTextField txtroomno;
    private javax.swing.JLabel welcomeuser;
    private javax.swing.JLabel welcomeuser1;
    // End of variables declaration//GEN-END:variables
}