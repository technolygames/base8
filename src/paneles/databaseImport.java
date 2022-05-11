package paneles;

import clases.laf;
import clases.logger;
import clases.thread;
import venPrimarias.start;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import venTerciarias.databaseWindow;

public class databaseImport extends javax.swing.JPanel{
    public databaseImport(){
        initComponents();
        new laf().LookAndFeel(databaseImport.this,databaseImport.class.getName(),"importWindow");
        
        botones();
        settings();
    }
    
    protected InputStream is;
    protected OutputStream os;
    
    protected Properties p;
    
    protected void settings(){
        jTextField3.setText(databaseWindow.nombredb);
    }
    
    protected final void botones(){
        closeButton.addActionListener((ae)->{
            setVisible(false);
        });
        
        fileButton.addActionListener((ae)->{
            try{
                p=new Properties();
                p.load(new FileInputStream(System.getProperty("user.dir")+"/src/data/config/filechooserd.properties"));
                JFileChooser chooser=new JFileChooser(p.getProperty("lastdirectory_database_import"));
                
                chooser.setFileFilter(new FileNameExtensionFilter("Archivo SQL","sql"));
                
                int i=chooser.showOpenDialog(null);
                if(JFileChooser.APPROVE_OPTION==i){
                    File f=chooser.getSelectedFile();
                    
                    jTextField2.setText(f.toString());
                    
                    p.setProperty("lastdirectory_database_import",f.getParent());
                    p.store(new BufferedWriter(new FileWriter(System.getProperty("user.dir")+"/src/data/config/filechooserd.properties")),"JFileChooserDirection");
                }
            }catch(IOException e){
                JOptionPane.showMessageDialog(this,"Error:\n"+e.getMessage(),"Error 1IO",JOptionPane.WARNING_MESSAGE);
                new logger().staticLogger("Error 1IO: "+e.getMessage()+".\nOcurrió en la clase '"+databaseImport.class.getName()+"', en el método 'botones(fileButton)'",Level.WARNING);
                new logger().exceptionLogger(databaseImport.class.getName(),Level.WARNING,"botones.file-1IO",e.fillInStackTrace());
            }
        });
        
        importButton.addActionListener((ae)->{
            try{
                Process pr=Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysql.exe -u "+jTextField1.getText()+" -p "+jPasswordField1.getPassword().toString()+" "+jTextField3.getText());
                
                System.out.println(pr.getInputStream());
                
                os=pr.getOutputStream();
                is=new FileInputStream(jTextField2.getText());
                
                new thread(is,os).run();
                
                JOptionPane.showMessageDialog(null,"Se ha importado correctamente la base de datos","Rel 2E",JOptionPane.INFORMATION_MESSAGE);
                new logger().staticLogger("Rel 2E: se importó correctamente la base de datos.\nOcurrió en la clase '"+databaseImport.class.getName()+"', en el método 'botones(importButton)'.\nUsuario que hizo la acción: "+String.valueOf(start.userID),Level.INFO);
                
                os.close();
                os.flush();
                is.close();
            }catch(IOException e){
                JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error 7E",JOptionPane.WARNING_MESSAGE);
                new logger().staticLogger("Error 7E: "+e.getMessage()+".\nOcurrió en la clase '"+databaseImport.class.getName()+"', en el método 'botones(importButton)'",Level.WARNING);
                new logger().exceptionLogger(databaseImport.class.getName(),Level.WARNING,"botones.import-7E",e.fillInStackTrace());
            }catch(NullPointerException x){
                JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage(),"Error 0",JOptionPane.WARNING_MESSAGE);
                new logger().staticLogger("Error 0: "+x.getMessage()+".\nOcurrió en la clase '"+databaseImport.class.getName()+"', en el método 'botones(importButton)'",Level.WARNING);
                new logger().exceptionLogger(databaseImport.class.getName(),Level.WARNING,"botones.import-0",x.fillInStackTrace());
            }catch(Exception n){
                JOptionPane.showMessageDialog(null,"Error:\n"+n.getMessage(),"Error Prueba",JOptionPane.WARNING_MESSAGE);
                new logger().staticLogger("Error Prueba: "+n.getMessage()+".\nOcurrió en la clase '"+databaseImport.class.getName()+"', en el método 'botones(importButton)'",Level.WARNING);
                new logger().exceptionLogger(databaseImport.class.getName(),Level.WARNING,"botones.import-Prueba",n.fillInStackTrace());
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileButton = new javax.swing.JButton();
        createButton = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        importButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        fileButton.setText("Buscar");

        createButton.setText("Crear base de datos");

        jLabel1.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        jLabel3.setText("Base de datos a usar:");

        importButton.setText("Importar");

        closeButton.setText("Cerrar panel");

        jLabel4.setText("Base de datos a importar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(importButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField3)
                                    .addComponent(jPasswordField1)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createButton)
                                .addGap(0, 54, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(closeButton))
                                    .addComponent(jTextField2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fileButton)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fileButton)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importButton)
                    .addComponent(closeButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton createButton;
    private javax.swing.JButton fileButton;
    private javax.swing.JButton importButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    public static javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}