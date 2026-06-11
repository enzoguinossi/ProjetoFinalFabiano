USE projeto_final;

INSERT INTO Cliente (nome, cidade, celular, email) VALUES
    ('João Silva', 'Niterói', '21999990001', 'joao.silva@email.com'),
    ('Maria Oliveira', 'Rio de Janeiro', '21999990002', 'maria.oliveira@email.com'),
    ('Carlos Souza', 'São Gonçalo', '21999990003', 'carlos.souza@email.com');

INSERT INTO Garcom (nome, telefone, cpf, salario, turno) VALUES
    ('Ana Pereira', '21988880001', '12345678901', 2500.00, 'MANHÃ'),
    ('Pedro Costa', '21988880002', '98765432101', 2500.00, 'NOITE');

INSERT INTO Mesa (quantidadeLugares, setor, status) VALUES
    (2, 'Salão Interno', 'LIVRE'),
    (4, 'Salão Interno', 'LIVRE'),
    (6, 'Varanda', 'LIVRE'),
    (4, 'Varanda', 'LIVRE');

INSERT INTO Prato (nome, descricao, tipo, preco) VALUES
    ('Bruschetta', 'Pão italiano com tomate, manjericão e azeite', 'ENTRADA', 28.00),
    ('Filé à Parmegiana', 'Filé mignon empanado com queijo e molho de tomate', 'PRATOPRINCIPAL', 65.00),
    ('Suco de Laranja', 'Suco natural de laranja', 'BEBIDA', 12.00),
    ('Petit Gâteau', 'Bolo de chocolate com sorvete de creme', 'SOBREMESA', 32.00);

INSERT INTO Pedido (data, status, cliente_id, garcom_id, mesa_id) VALUES
    ('2026-06-10', 'PENDENTE', 1, 1, 2),
    ('2026-06-10', 'ATENDIDO', 2, 2, 4);

INSERT INTO ItemPedido (pedido_id, prato_id, quantidade, precoUnitario, subtotal) VALUES
    (1, 1, 2, 28.00, 56.00),
    (1, 3, 2, 12.00, 24.00),
    (1, 2, 1, 65.00, 65.00),
    (2, 2, 2, 65.00, 130.00),
    (2, 4, 2, 32.00, 64.00);