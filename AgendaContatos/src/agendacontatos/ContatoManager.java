package agendacontatos;

import AgendaContato.Contato;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoManager {

   
    public void adicionarContato(Contato contato) {
        String sql = "INSERT INTO contatos (nome, telefone, email) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setString(3, contato.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar contatos do banco de dados SQL Server
    public List<Contato> listarContatos() {
        List<Contato> contatos = new ArrayList<>();
        String sql = "SELECT * FROM contatos";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Contato contato = new Contato(
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
                contatos.add(contato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contatos;
    }

    // Editar contato no banco de dados SQL Server
    public void editarContato(String nome, String novoTelefone, String novoEmail) {
        String sql = "UPDATE contatos SET telefone = ?, email = ? WHERE nome = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoTelefone);
            stmt.setString(2, novoEmail);
            stmt.setString(3, nome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remover contato do banco de dados SQL Server
    public void removerContato(String nome) {
        String sql = "DELETE FROM contatos WHERE nome = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Contato buscarContato(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
