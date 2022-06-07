package com.gtbr.controller;

import com.gtbr.dao.ProdutoDAO;
import com.gtbr.model.Produto;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ProdutoController {

    private ProdutoDAO produtoDAO;

    public ProdutoController () {
        this.produtoDAO = new ProdutoDAO();
    }

    public Produto cadastraProduto() throws IOException {
        Scanner scanner = new Scanner(System.in);

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
    public Produto buscaProduto() throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual nome do produto?");
        String nome = scanner.next();

        Produto produto = produtoDAO.buscarProduto(nome);

        return produto;

    }

    public void deletaProduto() throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual nome do produto que deseja deletar?");
        String nome = scanner.next();
        produtoDAO.deletaProduto(nome);
    }


}
