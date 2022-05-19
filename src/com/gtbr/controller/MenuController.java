package com.gtbr.controller;

import com.gtbr.model.Produto;

import java.io.IOException;
import java.util.Scanner;

public class MenuController {

    public void exibeMenu() throws IOException {
        boolean querContinuar = true;
        Scanner scanner = new Scanner(System.in);
        while (querContinuar){

            System.out.println("====Menu====");
            System.out.println("[1] Cadastrar novo produto");
            int opcao = scanner.nextInt();
            ProdutoController produtoController = new ProdutoController();
            switch (opcao){
                case 1: {

                    Produto produtoCadastrado = produtoController.cadastraProduto();
                    break;
                }
            }

        }

    }
}
