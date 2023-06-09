package prog07_ejer01;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author IVAN
 */
public class EditorTextosJD extends javax.swing.JFrame {
    JFileChooser seleccionado=new JFileChooser();
    File archivo;
    EditorTextos e=new EditorTextos();
    String ruta=null;
    String contenido;
    int cont=1;

    /**
     * Creates new form EditorTextosJD
     */
    public EditorTextosJD() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        txtPrincipal = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnNuevo = new javax.swing.JMenuItem();
        btnAbrir = new javax.swing.JMenuItem();
        btnGuardar = new javax.swing.JMenuItem();
        btnGuardarComo = new javax.swing.JMenuItem();
        btnSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnCortar = new javax.swing.JMenuItem();
        btnCopiar = new javax.swing.JMenuItem();
        btnPegar = new javax.swing.JMenuItem();
        btnMayuscula = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtPrincipal.setColumns(20);
        txtPrincipal.setRows(5);
        jScrollPane1.setViewportView(txtPrincipal);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/folder_122789.png"))); // NOI18N
        jMenu1.setDelay(250);
        jMenu1.setMaximumSize(new java.awt.Dimension(40, 200));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(btnNuevo);

        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/writing-on-an-open-book_icon-icons.com_70325.png"))); // NOI18N
        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(btnAbrir);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(btnGuardar);

        btnGuardarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardarComo.setText("Guardar Como");
        btnGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarComoActionPerformed(evt);
            }
        });
        jMenu1.add(btnGuardarComo);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/4115235-exit-logout-sign-out_114030.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jMenu1.add(btnSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pencil-striped-symbol-for-interface-edit-buttons_icon-icons.com_56782.png"))); // NOI18N
        jMenu2.setMaximumSize(new java.awt.Dimension(50, 32767));
        jMenu2.setPreferredSize(new java.awt.Dimension(20, 5));

        btnCortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cortar.png"))); // NOI18N
        btnCortar.setText("Cortar");
        btnCortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCortarActionPerformed(evt);
            }
        });
        jMenu2.add(btnCortar);

        btnCopiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/copiar.png"))); // NOI18N
        btnCopiar.setText("Copiar");
        btnCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiarActionPerformed(evt);
            }
        });
        jMenu2.add(btnCopiar);

        btnPegar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/wondicon-ui-free-file_111223.png"))); // NOI18N
        btnPegar.setText("Pegar");
        btnPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPegarActionPerformed(evt);
            }
        });
        jMenu2.add(btnPegar);

        btnMayuscula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mayuscula_minuscula.png"))); // NOI18N
        btnMayuscula.setText("Mayúscula/Minúscula");
        btnMayuscula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMayusculaActionPerformed(evt);
            }
        });
        jMenu2.add(btnMayuscula);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        ruta=null;
        txtPrincipal.setText("");
        txtPrincipal.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if(seleccionado.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            archivo=seleccionado.getSelectedFile();
            if(archivo.getName().endsWith("txt")){
                contenido=e.abrirArchivoTexto(archivo);
                System.out.println(contenido);
                txtPrincipal.setText(contenido);
            }else{
                JOptionPane.showMessageDialog(null, "Por favor seleccione un archivo de texto.");
            }
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarComoActionPerformed
        // TODO add your handling code here:
        guardarComo();
    }//GEN-LAST:event_btnGuardarComoActionPerformed

    private void guardarComo(){
       if(seleccionado.showDialog(null, "Guardar como")==JFileChooser.APPROVE_OPTION){
            archivo=seleccionado.getSelectedFile();
            if(archivo.getName().endsWith("txt")){
                archivo.delete();
                contenido=txtPrincipal.getText();
                String respuesta=e.guardaTexto(archivo, contenido);
                if(respuesta!=null){
                    JOptionPane.showMessageDialog(null, respuesta);
                }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Archivo seleccionado no es formato de texto");
            }
        }
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(archivo!=null){
            contenido=txtPrincipal.getText();
            archivo.delete();
            String respuesta=e.guardaTexto(archivo, contenido);
            if(respuesta!=null){
                JOptionPane.showMessageDialog(null,respuesta);
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Este Archivo aun no tiene nombre");
            guardarComo();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCortarActionPerformed
        txtPrincipal.cut();
    }//GEN-LAST:event_btnCortarActionPerformed

    private void btnCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiarActionPerformed
        txtPrincipal.copy();
    }//GEN-LAST:event_btnCopiarActionPerformed

    private void btnPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPegarActionPerformed
        txtPrincipal.paste();
    }//GEN-LAST:event_btnPegarActionPerformed

    private void btnMayusculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMayusculaActionPerformed
        if(cont%2==0){
            txtPrincipal.setText(txtPrincipal.getText().toLowerCase());
        }else{
            txtPrincipal.setText(txtPrincipal.getText().toUpperCase());
        }
        cont++;
    }//GEN-LAST:event_btnMayusculaActionPerformed

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
            java.util.logging.Logger.getLogger(EditorTextosJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditorTextosJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditorTextosJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorTextosJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditorTextosJD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAbrir;
    private javax.swing.JMenuItem btnCopiar;
    private javax.swing.JMenuItem btnCortar;
    private javax.swing.JMenuItem btnGuardar;
    private javax.swing.JMenuItem btnGuardarComo;
    private javax.swing.JMenuItem btnMayuscula;
    private javax.swing.JMenuItem btnNuevo;
    private javax.swing.JMenuItem btnPegar;
    private javax.swing.JMenuItem btnSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtPrincipal;
    // End of variables declaration//GEN-END:variables
}
