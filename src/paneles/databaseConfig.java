package paneles;

import clases.laf;
import clases.logger;
import venPrimarias.start;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import javax.swing.JOptionPane;

public class databaseConfig extends javax.swing.JPanel{
    public databaseConfig(){
        initComponents();
        new laf().LookAndFeel(databaseConfig.this,databaseConfig.class.getName(),"databaseConfig");
        
        botones();
        loadConfig();
    }
    
    protected Properties p;
    
    protected void loadConfig(){
        p=new Properties();
        try{
            p.load(new FileInputStream(System.getProperty("user.dir")+"/src/data/config/databaseInfo.properties"));
            jComboBox1.getModel().setSelectedItem(p.getProperty("driver"));
            jTextField1.setText(p.getProperty("database"));
            jTextField2.setText(p.getProperty("user"));
            jTextField3.setText(p.getProperty("pass"));
            jTextField4.setText(p.getProperty("ip"));
            jTextField5.setText(p.getProperty("port"));
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error 1IO",JOptionPane.WARNING_MESSAGE);
            new logger().staticLogger("Error 1IO: "+e.getMessage()+".\nOcurrió en la clase '"+databaseConfig.class.getName()+"', en el método 'loadConfig()'",Level.WARNING);
            new logger().exceptionLogger(databaseConfig.class.getName(),Level.WARNING,"loadConfig-1IO",e.fillInStackTrace());
        }catch(IOException x){
            JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage(),"Error 2IO",JOptionPane.WARNING_MESSAGE);
            new logger().staticLogger("Error 2IO: "+x.getMessage()+".\nOcurrió en la clase '"+databaseConfig.class.getName()+"', en el método 'loadConfig()'",Level.WARNING);
            new logger().exceptionLogger(databaseConfig.class.getName(),Level.WARNING,"loadConfig-2IO",x.fillInStackTrace());
        }
    }
    
    protected final void botones(){
        p=new Properties();
        closeButton.addActionListener((a)->{
            setVisible(false);
        });
        
        storeButton.addActionListener((a)->{
            try{
                p.setProperty("driver",jComboBox1.getSelectedItem().toString());
                p.setProperty("database",jTextField1.getText());
                p.setProperty("user",jTextField2.getText());
                p.setProperty("pass",jTextField3.getText());
                p.setProperty("ip",jTextField4.getText());
                p.setProperty("port", jTextField5.getText());
                
                JOptionPane.showMessageDialog(null,"Se guardaron correctamente","Rel 4",JOptionPane.INFORMATION_MESSAGE);
                new logger().staticLogger("Rel 4: se han guardado las condiguraciones.\nOcurrió en la clase '"+databaseConfig.class.getName()+"', en el método 'botones(storeButton)'.\nUsuario que hizo los cambios: "+String.valueOf(start.userID),Level.INFO);
                
                p.store(new BufferedWriter(new FileWriter(System.getProperty("user.dir")+"/src/data/config/databaseInfo.properties")),"Configuración de la base de datos");
            }catch(FileNotFoundException e){
                JOptionPane.showMessageDialog(null,"Error:\n"+e.getMessage(),"Error 1IO",JOptionPane.WARNING_MESSAGE);
                new logger().staticLogger("Error 1IO: "+e.getMessage()+".\nOcurrió en la clase '"+databaseConfig.class.getName()+"', en el método 'botones(storeButton)'",Level.WARNING);
                new logger().exceptionLogger(databaseConfig.class.getName(),Level.WARNING,"botones.store-1IO",e.fillInStackTrace());
            }catch(NumberFormatException x){
                JOptionPane.showMessageDialog(null,"Error:\n"+x.getMessage(),"Error 32",JOptionPane.WARNING_MESSAGE);
                new logger().staticLogger("Error 32: "+x.getMessage()+".\nOcurrió en la clase '"+databaseConfig.class.getName()+"', en el método 'botones(storeButton)'",Level.WARNING);
                new logger().exceptionLogger(databaseConfig.class.getName(),Level.WARNING,"botones.store-32",x.fillInStackTrace());
            }catch(NullPointerException n){
                JOptionPane.showMessageDialog(null,"Error:\n"+n.getMessage(),"Error 0",JOptionPane.WARNING_MESSAGE);
                new logger().staticLogger("Error 0: "+n.getMessage()+".\nOcurrió en la clase '"+databaseConfig.class.getName()+"', en el método 'botones(storeButton)'",Level.WARNING);
                new logger().exceptionLogger(databaseConfig.class.getName(),Level.WARNING,"botones.store-0",n.fillInStackTrace());
            }catch(IOException s){
                JOptionPane.showMessageDialog(null,"Error:\n"+s.getMessage(),"Error 2IO",JOptionPane.WARNING_MESSAGE);
                new logger().staticLogger("Error 2IO: "+s.getMessage()+".\nOcurrió en la clase '"+databaseConfig.class.getName()+"', en el método 'botones(storeButton)'",Level.WARNING);
                new logger().exceptionLogger(databaseConfig.class.getName(),Level.WARNING,"botones.store-2IO",s.fillInStackTrace());
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        storeButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();

        storeButton.setText("Guardar");

        closeButton.setText("Cerrar panel");

        jLabel1.setText("Base de datos:");

        jLabel2.setText("Usuario:");

        jLabel3.setText("Contraseña:");

        jLabel4.setText("Driver:");

        jLabel5.setText("IP:");

        jLabel6.setText("Puerto:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "com.mysql.cj.jdbc.Driver" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(storeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(166, 166, 166))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(storeButton)
                    .addComponent(closeButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton storeButton;
    // End of variables declaration//GEN-END:variables
}