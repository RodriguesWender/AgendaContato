import AgendaContato.Contato;
import agendacontatos.ContatoManager;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AgendaSwing extends JFrame {
    private ContatoManager manager = new ContatoManager();
    private JTextArea areaContatos;
    private JTextField tfNome, tfTelefone, tfEmail;

    public AgendaSwing() {
        setTitle("Agenda de Contatos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

       
        areaContatos = new JTextArea();
        areaContatos.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaContatos);
        add(scroll, BorderLayout.CENTER);

       
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Nome:"));
        tfNome = new JTextField();
        panel.add(tfNome);

        panel.add(new JLabel("Telefone:"));
        tfTelefone = new JTextField();
        panel.add(tfTelefone);

        panel.add(new JLabel("Email:"));
        tfEmail = new JTextField();
        panel.add(tfEmail);

        JButton btnAdicionar = new JButton("Adicionar Contato");
        btnAdicionar.addActionListener(e -> adicionarContato());

        JButton btnListar = new JButton("Listar Contatos");
        btnListar.addActionListener(e -> listarContatos());

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btnAdicionar);
        buttonsPanel.add(btnListar);

        add(panel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    private void adicionarContato() {
        String nome = tfNome.getText();
        String telefone = tfTelefone.getText();
        String email = tfEmail.getText();

        Contato contato = new Contato(nome, telefone, email);
        manager.adicionarContato(contato);
        tfNome.setText("");
        tfTelefone.setText("");
        tfEmail.setText("");
        JOptionPane.showMessageDialog(this, "Contato Adicionado!");
    }

    private void listarContatos() {
        List<Contato> contatos = manager.listarContatos();
        areaContatos.setText(""); // Limpar área de texto
        if (contatos.isEmpty()) {
            areaContatos.append("Nenhum contato cadastrado.");
        } else {
            for (Contato c : contatos) {
                areaContatos.append(c + "\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AgendaSwing app = new AgendaSwing();
            app.setVisible(true);
        });
    }
}
