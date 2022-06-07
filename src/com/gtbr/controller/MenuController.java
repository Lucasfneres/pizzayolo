package com.gtbr.controller;

import com.gtbr.model.Produto;

import java.io.IOException;
import java.util.Scanner;

public class MenuController {

    public void exibeMenu() throws IOException {
        boolean querContinuar = true;
        Scanner scanner = new Scanner(System.in);
        while (querContinuar) {

            System.out.println("====Menu====");
            System.out.println("[1] Cadastrar novo produto");
            System.out.println("[2] Buscar produto");
            System.out.println("[3] Deletar produto");
            System.out.print("Digite sua opção: ");
            int opcao = scanner.nextInt();
            ProdutoController produtoController = new ProdutoController();
            switch (opcao) {
                case 1: {

                    Produto produtoCadastrado = produtoController.cadastraProduto();
                    break;
                }
                case 2:{
                    Produto produto = produtoController.buscaProduto();
                    System.out.println(produto.toString());
                    break;
                }
                case 3:{
                    produtoController.deletaProduto();
                }
            }

        }

    }
}
