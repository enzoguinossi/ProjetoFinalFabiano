package com.faetec.projetofinal.controller;

import com.faetec.projetofinal.data.SQLController;
import com.faetec.projetofinal.entity.Cliente;

import java.util.List;
import java.util.Map;

public class ClienteController {

    private final SQLController sql;

    public ClienteController(SQLController sql) {
        this.sql = sql;
    }

    public boolean salvar(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nome, cidade, celular, email) VALUES (?, ?, ?, ?)";
        Object[] params = {
                cliente.getNome(),
                cliente.getCidade(),
                cliente.getCelular(),
                cliente.getEmail()
        };
        int linhas = this.sql.executeUpdate(sql, params);
        return linhas > 0;
    }

    public boolean alterar(Cliente cliente) {
        String sql = "UPDATE Cliente SET nome = ?, cidade = ?, celular = ?, email = ? WHERE codigo = ?";
        Object[] params = {
                cliente.getNome(),
                cliente.getCidade(),
                cliente.getCelular(),
                cliente.getEmail(),
                cliente.getCodigo()
        };
        int linhas = this.sql.executeUpdate(sql, params);
        return linhas > 0;
    }

    public boolean excluir(int codigo) {
        String sql = "DELETE FROM Cliente WHERE codigo = ?";
        Object[] params = { codigo };
        int linhas = this.sql.executeUpdate(sql, params);
        return linhas > 0;
    }

    public List<Cliente> listar() {
        String sql = "SELECT * FROM Cliente";
        List<Map<String, Object>> linhas = this.sql.executeQuery(sql, null);
        return linhas.stream().map(this::mapearCliente).toList();
    }

    public Cliente buscarPorCodigo(int codigo) {
        String sql = "SELECT * FROM Cliente WHERE codigo = ?";
        Object[] params = { codigo };
        List<Map<String, Object>> linhas = this.sql.executeQuery(sql, params);
        if (linhas.isEmpty()) return null;
        return mapearCliente(linhas.getFirst());
    }

    private Cliente mapearCliente(Map<String, Object> linha) {
        Cliente c = new Cliente();
        c.setCodigo(((Number) linha.get("codigo")).intValue());
        c.setNome((String) linha.get("nome"));
        c.setCidade((String) linha.get("cidade"));
        c.setCelular((String) linha.get("celular"));
        c.setEmail((String) linha.get("email"));
        return c;
    }
}