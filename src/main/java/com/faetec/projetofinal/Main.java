package com.faetec.projetofinal;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Software Gerenciamento Restaurante");
        JMenuBar menuBar = new JMenuBar();

        JMenu arquivo = new JMenu("Arquivo");
            arquivo.add(new JMenuItem("Sair"));
        menuBar.add(arquivo);

        JMenu cadastros = new JMenu("Cadastros");
            JMenuItem itemClientes = new JMenuItem("Clientes");
            JMenuItem itemGarcons = new JMenuItem("Garçons");
            JMenuItem itemMesas = new JMenuItem("Mesas");
            JMenuItem itemPratos = new JMenuItem("Pratos");

            cadastros.add(itemClientes);
            cadastros.add(itemGarcons);
            cadastros.add(itemMesas);
            cadastros.add(itemPratos);
        menuBar.add(cadastros);


        JMenu pedido = new JMenu("Pedidos");
            pedido.add(new JMenuItem("Efetuar Pedido"));
        menuBar.add(pedido);

        JMenu ajuda = new JMenu("Ajuda");
            ajuda.add(new JMenuItem("Sobre..."));
        menuBar.add(ajuda);

        frame.setJMenuBar(menuBar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);

        frame.setVisible(true);
    }
}