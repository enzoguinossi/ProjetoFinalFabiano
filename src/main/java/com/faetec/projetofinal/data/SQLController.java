package com.faetec.projetofinal.data;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class SQLController {

    private static final String CONFIG_ARQUIVO = "/config.properties";
    private static final String URL;
    private static final String USUARIO;
    private static final String SENHA;

    static {
        Properties props = new Properties();
        try (InputStream in = SQLController.class.getResourceAsStream(CONFIG_ARQUIVO)) {
            if (in == null) {
                throw new RuntimeException("Arquivo " + CONFIG_ARQUIVO + " nao encontrado em resources");
            }
            props.load(in);
            URL = props.getProperty("db.url");
            USUARIO = props.getProperty("db.user");
            SENHA = props.getProperty("db.password");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar " + CONFIG_ARQUIVO, e);
        }
    }

    private static final SQLController INSTANCIA = new SQLController();
    private Connection conexao;

    private SQLController() { }

    public static SQLController getInstance() {
        return INSTANCIA;
    }

    public Connection getConnection() {
        try {
            if (conexao == null || conexao.isClosed()) {
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            }
            return conexao;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }

    public int executeUpdate(String sql, Object[] params) {
        try (PreparedStatement stmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            definirParametros(stmt, params);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao executar update: " + sql, e);
        }
    }

    public List<Map<String, Object>> executeQuery(String sql, Object[] params) {
        List<Map<String, Object>> resultado = new ArrayList<>();
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            definirParametros(stmt, params);
            try (ResultSet rs = stmt.executeQuery()) {
                ResultSetMetaData meta = rs.getMetaData();
                int colunas = meta.getColumnCount();
                while (rs.next()) {
                    Map<String, Object> linha = new LinkedHashMap<>();
                    for (int i = 1; i <= colunas; i++) {
                        linha.put(meta.getColumnLabel(i), rs.getObject(i));
                    }
                    resultado.add(linha);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao executar query: " + sql, e);
        }
        return resultado;
    }

    public void close() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar conexao", e);
        }
    }

    private void definirParametros(PreparedStatement stmt, Object[] params) throws SQLException {
        if (params == null) return;
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }
    }
}