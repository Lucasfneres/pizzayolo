package com.gtbr.controller;

import com.gtbr.dao.ProdutoDAO;
import com.gtbr.model.Produto;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
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
        produtoDAO.persistirProduto(produto,false);

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
    public void listarProdutos() throws IOException {
        produtoDAO.listarProdutos();
        List<Produto> listaDeProdutos = produtoDAO.listarProdutos();

        for (Produto produto : listaDeProdutos) {
            System.out.println(produto);

        }
    }

    public void atualizaProduto()throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que produto vc deseja att? ");
        String nomeDoProduto = scanner.next();

        Produto produto = produtoDAO.buscarProduto(nomeDoProduto);

        if (produto == null){
            return;
        }

        System.out.println("Qual atributo você deseja atualizar?");
        System.out.println(" [1] - Nome (atual:  "+ produto.getNome()+")");
        System.out.println(" [2] - Valor (atual:  "+ produto.getValor()+")");
        System.out.println(" [3] - Codigo (atual:  "+produto.getCodigoDeBarras()+ ")");

        Integer atributoEscolhido = scanner.nextInt();

        System.out.println("Para qual valor ira atualizar? ");
        String valorAtualizado = scanner.next();

        produtoDAO.atualizaProduto(atributoEscolhido, valorAtualizado, produto);









    }

    //public atualizaProdutos() throws IOException{}


}
