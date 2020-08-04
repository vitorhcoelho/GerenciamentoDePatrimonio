/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import gerenciadordepatrimonio.Servidor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Vitor Hugo
 */
public class TelaAdm extends javax.swing.JFrame {

    TelaLogin l = null;
    /**
     * Creates new form TelaAdm
     */
    public TelaAdm(Servidor a) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Gerenciador de Patrimônio");
    }

    public TelaAdm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemGereServs = new javax.swing.JMenuItem();
        jMenuItemGereCampus = new javax.swing.JMenuItem();
        jMenuItemGereAmbientes = new javax.swing.JMenuItem();
        jMenuItemGereItens = new javax.swing.JMenuItem();
        jMenuItemGereMovAmb = new javax.swing.JMenuItem();
        jMenuItemGereMovDonos = new javax.swing.JMenuItem();
        jMenuItemGereRev = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemViewServs = new javax.swing.JMenuItem();
        jMenuItemViewCampus = new javax.swing.JMenuItem();
        jMenuItemViewAmbientes = new javax.swing.JMenuItem();
        jMenuItemViewItens = new javax.swing.JMenuItem();
        jMenuItemViewMovAmb = new javax.swing.JMenuItem();
        jMenuItemViewMovDonos = new javax.swing.JMenuItem();
        jMenuItemViewRev = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemRelatorioAmbiente = new javax.swing.JMenuItem();
        jMenuItemRelatorioServidor = new javax.swing.JMenuItem();
        jMenuLogout = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1459, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 757, Short.MAX_VALUE)
        );

        jMenu1.setText("Gerenciar");

        jMenuItemGereServs.setText("Servidores");
        jMenuItemGereServs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGereServsActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGereServs);

        jMenuItemGereCampus.setText("Campus");
        jMenuItemGereCampus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGereCampusActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGereCampus);

        jMenuItemGereAmbientes.setText("Ambientes");
        jMenuItemGereAmbientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGereAmbientesActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGereAmbientes);

        jMenuItemGereItens.setText("Itens");
        jMenuItemGereItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGereItensActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGereItens);

        jMenuItemGereMovAmb.setText("Movimentações entre ambientes");
        jMenuItemGereMovAmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGereMovAmbActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGereMovAmb);

        jMenuItemGereMovDonos.setText("Movimentações entre donos");
        jMenuItemGereMovDonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGereMovDonosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGereMovDonos);

        jMenuItemGereRev.setText("Revisões");
        jMenuItemGereRev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGereRevActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGereRev);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Visualizar");

        jMenuItemViewServs.setText("Servidores");
        jMenu2.add(jMenuItemViewServs);

        jMenuItemViewCampus.setText("Campus");
        jMenu2.add(jMenuItemViewCampus);

        jMenuItemViewAmbientes.setText("Ambientes");
        jMenu2.add(jMenuItemViewAmbientes);

        jMenuItemViewItens.setText("Itens");
        jMenu2.add(jMenuItemViewItens);

        jMenuItemViewMovAmb.setText("Movimentações entre ambientes");
        jMenu2.add(jMenuItemViewMovAmb);

        jMenuItemViewMovDonos.setText("Movimentações entre donos");
        jMenu2.add(jMenuItemViewMovDonos);

        jMenuItemViewRev.setText("Revisões");
        jMenu2.add(jMenuItemViewRev);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Relatórios");

        jMenuItemRelatorioAmbiente.setText("Ambientes");
        jMenuItemRelatorioAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioAmbienteActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemRelatorioAmbiente);

        jMenuItemRelatorioServidor.setText("Servidores");
        jMenuItemRelatorioServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioServidorActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemRelatorioServidor);

        jMenuBar1.add(jMenu3);

        jMenuLogout.setText("Trocar usuário");
        jMenuLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuLogoutMouseClicked(evt);
            }
        });
        jMenuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuLogoutActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenuLogout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemGereServsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGereServsActionPerformed
        // TODO add your handling code here:
        GerenciaServJInternal frameInterno = new GerenciaServJInternal();
        frameInterno.setVisible(true);
        jDesktopPane1.add(frameInterno);
        centralizaForm(frameInterno);
    }//GEN-LAST:event_jMenuItemGereServsActionPerformed

    private void jMenuItemGereCampusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGereCampusActionPerformed
        // TODO add your handling code here:
        GerenciaCampusJInternal1 frameInterno = new GerenciaCampusJInternal1();
        frameInterno.setVisible(true);
        jDesktopPane1.add(frameInterno);
        centralizaForm(frameInterno);
    }//GEN-LAST:event_jMenuItemGereCampusActionPerformed

    private void jMenuItemGereAmbientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGereAmbientesActionPerformed
        // TODO add your handling code here:
        GerenciaAmbientesJInternal1 frameInterno = new GerenciaAmbientesJInternal1();
        frameInterno.setVisible(true);
        jDesktopPane1.add(frameInterno);
        centralizaForm(frameInterno);
    }//GEN-LAST:event_jMenuItemGereAmbientesActionPerformed

    private void jMenuItemGereItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGereItensActionPerformed
        // TODO add your handling code here:
        GerenciaItensJInternal1 frameInterno = new GerenciaItensJInternal1();
        frameInterno.setVisible(true);
        jDesktopPane1.add(frameInterno);
        centralizaForm(frameInterno);
    }//GEN-LAST:event_jMenuItemGereItensActionPerformed

    private void jMenuItemGereMovAmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGereMovAmbActionPerformed
        // TODO add your handling code here:
        GerenciaMovAmbJInternal1 frameInterno = new GerenciaMovAmbJInternal1();
        frameInterno.setVisible(true);
        jDesktopPane1.add(frameInterno);
        centralizaForm(frameInterno);
    }//GEN-LAST:event_jMenuItemGereMovAmbActionPerformed

    private void jMenuItemGereMovDonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGereMovDonosActionPerformed
        // TODO add your handling code here:
        GerenciaMovDonosJInternal11 frameInterno = new GerenciaMovDonosJInternal11();
        frameInterno.setVisible(true);
        jDesktopPane1.add(frameInterno);
        centralizaForm(frameInterno);
    }//GEN-LAST:event_jMenuItemGereMovDonosActionPerformed

    private void jMenuItemGereRevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGereRevActionPerformed
        // TODO add your handling code here:
        GerenciaRevisoesJInternal11 frameInterno = new GerenciaRevisoesJInternal11();
        frameInterno.setVisible(true);
        jDesktopPane1.add(frameInterno);
        centralizaForm(frameInterno);
    }//GEN-LAST:event_jMenuItemGereRevActionPerformed

    private void jMenuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuLogoutActionPerformed

    private void jMenuLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuLogoutMouseClicked
        // TODO add your handling code here:
        this.dispose();
        l = new TelaLogin();
        l.setVisible(true);
    }//GEN-LAST:event_jMenuLogoutMouseClicked

    private void jMenuItemRelatorioAmbienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioAmbienteActionPerformed
        // TODO add your handling code here:
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("documento.pdf"));

            document.open();
            document.add(new Paragraph("#Teste_GERARDO_PDF https://github.com/Heverton"));

        } catch (DocumentException ex) {
            System.out.println("Error:" + ex);
        } catch (FileNotFoundException ex) {
            System.out.println("Error:" + ex);
        } finally {
            document.close();
        }

        try {
            Desktop.getDesktop().open(new File("documento.pdf"));
        } catch (IOException ex) {
            System.out.println("Error:" + ex);
        }
    }//GEN-LAST:event_jMenuItemRelatorioAmbienteActionPerformed

    private void jMenuItemRelatorioServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioServidorActionPerformed
        // TODO add your handling code here:
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("documento.pdf"));

            document.open();
            document.add(new Paragraph("#Teste_GERARDO_PDF https://github.com/Heverton"));

        } catch (DocumentException ex) {
            System.out.println("Error:" + ex);
        } catch (FileNotFoundException ex) {
            System.out.println("Error:" + ex);
        } finally {
            document.close();
        }

        try {
            Desktop.getDesktop().open(new File("documento.pdf"));
        } catch (IOException ex) {
            System.out.println("Error:" + ex);
        }
    }//GEN-LAST:event_jMenuItemRelatorioServidorActionPerformed

    private void centralizaForm(JInternalFrame frame) {
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

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
            java.util.logging.Logger.getLogger(TelaAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemGereAmbientes;
    private javax.swing.JMenuItem jMenuItemGereCampus;
    private javax.swing.JMenuItem jMenuItemGereItens;
    private javax.swing.JMenuItem jMenuItemGereMovAmb;
    private javax.swing.JMenuItem jMenuItemGereMovDonos;
    private javax.swing.JMenuItem jMenuItemGereRev;
    private javax.swing.JMenuItem jMenuItemGereServs;
    private javax.swing.JMenuItem jMenuItemRelatorioAmbiente;
    private javax.swing.JMenuItem jMenuItemRelatorioServidor;
    private javax.swing.JMenuItem jMenuItemViewAmbientes;
    private javax.swing.JMenuItem jMenuItemViewCampus;
    private javax.swing.JMenuItem jMenuItemViewItens;
    private javax.swing.JMenuItem jMenuItemViewMovAmb;
    private javax.swing.JMenuItem jMenuItemViewMovDonos;
    private javax.swing.JMenuItem jMenuItemViewRev;
    private javax.swing.JMenuItem jMenuItemViewServs;
    private javax.swing.JMenu jMenuLogout;
    // End of variables declaration//GEN-END:variables
}
