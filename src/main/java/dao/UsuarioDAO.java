package dao;

import conexion.ConexionDB;
import java.sql.*;
import java.util.*;
import model.Usuario;

public class UsuarioDAO {

    public boolean insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO registrousuarios (nombre, apellido, email, password, pais) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection(); // Try with resources, cierra los recursos dentro de los parentesis (misma funcionalidad que finally)
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getApellido());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setString(4, usuario.getPassword());
            pstmt.setString(5, usuario.getPais());
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Usuario extraerUsuarioDeResultSet(ResultSet rs) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setNombre(rs.getString("nombre"));
        usuario.setApellido(rs.getString("apellido"));
        usuario.setEmail(rs.getString("email"));
        usuario.setPassword(rs.getString("password"));
        usuario.setPais(rs.getString("pais"));
        return usuario;
    }

    public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM registroUsuarios";

        try (Connection conn = ConexionDB.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Usuario usuario = extraerUsuarioDeResultSet(rs);
                usuarios.add(usuario);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario obtenerPorId(int id) {

        String query = "SELECT * FROM registroUsuarios WHERE id = ? ";

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extraerUsuarioDeResultSet(rs);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean modificar(Usuario usuario) {
        String query = "UPDATE registroUsuarios SET nombre = ?, apellido = ?, email = ?, password = ?, pais = ?";

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getApellido());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setString(4, usuario.getPassword());
            pstmt.setString(5, usuario.getPais());
            pstmt.setInt(6, usuario.getId());
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        String query = "DELETE FROM registroUsuarios WHERE id = ? ";

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
