package com.gtbr.controller;

import com.gtbr.dao.ProdutoDAO;
import com.gtbr.model.Produto;

import java.io.IOException;
import java.util.Scanner;

public class ProdutoController {

    public Produto cadastraProduto() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        System.out.println("Cadastro de Produto");
        System.out.println("Informe o nome deste produto");

        String nome = scanner.next();

        System.out.println("Informe o valor deste produto");
        float valor = scanner.nextFloat();

        System.out.println("Informe o codigo de barras deste produto");
        Integer codigoDeBarras = scanner.nextInt();

        Produto produto = new Produto(1, nome, valor, codigoDeBarras);
        produtoDAO.persistirProduto(produto);

        return produto;

    }

}
