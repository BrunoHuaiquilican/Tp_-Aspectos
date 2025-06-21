package aop.Punto2.ui;
import aop.Punto2.Modelo.Concurso;
import aop.Punto2.Modelo.Concursos;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaInscriptos {

    public static final String LABEL_TITULO = "Inscription to Competition";
    public static final String LABEL_EXITOSA_INSCRIPCION = "Su inscripcion ha sido exitosa";
    public static final String LABEL_ERROR_INSCRIPCION = "Hubo un error en la inscripción";
    public static final String NOMBRE = "Nombre:";
    public static final String APELLIDO = "Apellido:";
    public static final String TELEFONO = "Telefono:";
    public static final String EMAIL = "Email:";
    public static final String BOTON_OK = "Ok";
    public static final String INFORMACION = "Información";
    public static final String ERROR = "Error";
    public static final String CONCURSO = "Concurso:";
    public static final String DNI = "Dni:";
    List<Concurso> listaConcursos;
    private JPanel contentPane;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblLastName;
    private JTextField txtLastName;
    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblPhone;
    private JTextField txtPhone;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JComboBox<String> comboBox;
    private JButton btnOk;
    private JLabel lblCompetition;
    private Concursos concursos;


    public VentanaInscriptos(Concursos concursos) {
        this.concursos = concursos;
        var frame = new JFrame(LABEL_TITULO);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 451, 229);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        formElements();
        layout();
        frame.setVisible(true);
    }

    private static void mostrarInformacion(String mensaje) {
        JOptionPane.showMessageDialog(null,
                mensaje,
                INFORMACION,
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void mostrarMensajeError(RuntimeException ex) {
        JOptionPane.showMessageDialog(null,
                ex.getMessage(),
                ERROR,
                JOptionPane.WARNING_MESSAGE);
    }

    private void formElements() {
        lblName = new JLabel(NOMBRE);
        txtName = new JTextField();
        txtName.setColumns(10);
        lblLastName = new JLabel(APELLIDO);
        txtLastName = new JTextField();
        txtLastName.setColumns(10);
        lblId = new JLabel(DNI);
        txtId = new JTextField();
        txtId.setColumns(10);
        lblPhone = new JLabel(TELEFONO);
        txtPhone = new JTextField();
        txtPhone.setColumns(10);
        lblEmail = new JLabel(EMAIL);
        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        btnOk = new JButton(BOTON_OK);
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnOk.setEnabled(false);
                try {
                    Concurso unConcurso = listaConcursos.get(comboBox.getSelectedIndex());
                    concursos.saveInscription(txtLastName.getText(), txtName.getText(), txtPhone.getText(), txtEmail.getText(), txtId.getText(), unConcurso.obtenerIDComoString());
                    mostrarInformacion(LABEL_EXITOSA_INSCRIPCION);
                    btnOk.setEnabled(true);
                } catch (RuntimeException ex) {
                    mostrarMensajeError(ex);
                }

            }
        });

        lblCompetition = new JLabel(CONCURSO);
        comboBox = new JComboBox<>();
        todosLosConcursos();
    }

    private void todosLosConcursos() {
        listaConcursos = this.concursos.todosLosConcursos();
        for (Concurso c : listaConcursos) {
            comboBox.addItem(c.obtenerNombre());
        }
    }


    private void layout() {
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
                        .addGroup(gl_contentPane
                                .createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_contentPane
                                        .createSequentialGroup()
                                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(lblLastName).addComponent(lblId)
                                                .addComponent(lblPhone).addComponent(lblEmail)
                                                .addComponent(lblName).addComponent(lblCompetition))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                        .addGroup(
                                                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                        .addComponent(txtEmail, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtPhone, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtId, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtLastName, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtName, GroupLayout.Alignment.TRAILING,
                                                                GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)))
                                .addComponent(btnOk, GroupLayout.Alignment.TRAILING,
                                        GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap()));
        gl_contentPane
                .setVerticalGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtName, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblName))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblLastName).addComponent(txtLastName,
                                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblId).addComponent(
                                                txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(
                                                gl_contentPane.createSequentialGroup().addComponent(lblPhone)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(lblEmail))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(
                                                        gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lblCompetition))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnOk)
                                .addContainerGap(67, Short.MAX_VALUE)));
        contentPane.setLayout(gl_contentPane);
    }
}
