package com.faetec.projetofinal;

import com.faetec.projetofinal.controller.ClienteController;
import com.faetec.projetofinal.controller.GarcomController;
import com.faetec.projetofinal.controller.MesaController;
import com.faetec.projetofinal.controller.PedidoController;
import com.faetec.projetofinal.controller.PratoController;
import com.faetec.projetofinal.data.SQLController;
import com.faetec.projetofinal.view.ClienteForm;
import com.faetec.projetofinal.view.FramePrincipal;
import com.faetec.projetofinal.view.GarcomForm;
import com.faetec.projetofinal.view.MesaForm;
import com.faetec.projetofinal.view.PedidoForm;
import com.faetec.projetofinal.view.PratoForm;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SQLController sql = SQLController.getInstance();

        ClienteController clienteController = new ClienteController(sql);
        GarcomController garcomController = new GarcomController(sql);
        MesaController mesaController = new MesaController(sql);
        PratoController pratoController = new PratoController(sql);
        PedidoController pedidoController = new PedidoController(sql);

        FramePrincipal frame = new FramePrincipal();
        configurarMenu(frame.getMenuBar(), frame);
        inicializarFormularios(frame, clienteController, garcomController,
                mesaController, pratoController, pedidoController);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private static void configurarMenu(JMenuBar menuBar, FramePrincipal frame) {
        JMenu arquivo = new JMenu("Arquivo");
        JMenuItem sair = new JMenuItem("Sair");
        sair.addActionListener(e -> System.exit(0));
        arquivo.add(sair);
        menuBar.add(arquivo);

        JMenu cadastros = new JMenu("Cadastros");
        JMenuItem itemClientes = new JMenuItem("Clientes");
        itemClientes.addActionListener(e -> frame.exibirFormulario("clientes"));
        cadastros.add(itemClientes);

        JMenuItem itemGarcons = new JMenuItem("Garçons");
        itemGarcons.addActionListener(e -> frame.exibirFormulario("garcons"));
        cadastros.add(itemGarcons);

        JMenuItem itemMesas = new JMenuItem("Mesas");
        itemMesas.addActionListener(e -> frame.exibirFormulario("mesas"));
        cadastros.add(itemMesas);

        JMenuItem itemPratos = new JMenuItem("Pratos");
        itemPratos.addActionListener(e -> frame.exibirFormulario("pratos"));
        cadastros.add(itemPratos);

        menuBar.add(cadastros);

        JMenu pedido = new JMenu("Pedidos");
        JMenuItem efetuarPedido = new JMenuItem("Efetuar Pedido");
        efetuarPedido.addActionListener(e -> frame.exibirFormulario("pedidos"));
        pedido.add(efetuarPedido);
        menuBar.add(pedido);

        JMenu ajuda = new JMenu("Ajuda");
        JMenuItem sobre = new JMenuItem("Sobre...");
        sobre.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Software Gerenciamento Restaurante\nVersão 1.0"));
        ajuda.add(sobre);
        menuBar.add(ajuda);
    }

    private static void inicializarFormularios(FramePrincipal frame,
                                                ClienteController clienteController,
                                                GarcomController garcomController,
                                                MesaController mesaController,
                                                PratoController pratoController,
                                                PedidoController pedidoController) {
        ClienteForm clienteForm = new ClienteForm(clienteController);
        frame.adicionarFormulario("clientes", clienteForm);

        GarcomForm garcomForm = new GarcomForm(garcomController);
        frame.adicionarFormulario("garcons", garcomForm);

        MesaForm mesaForm = new MesaForm(mesaController);
        frame.adicionarFormulario("mesas", mesaForm);

        PratoForm pratoForm = new PratoForm(pratoController);
        frame.adicionarFormulario("pratos", pratoForm);

        PedidoForm pedidoForm = new PedidoForm(pedidoController);
        frame.adicionarFormulario("pedidos", pedidoForm);
    }
}