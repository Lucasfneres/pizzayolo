package com.gtbr.dao;

import com.gtbr.model.Produto;
import com.gtbr.service.FileManager;
import com.gtbr.service.SequenceManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public Produto persistirProduto(Produto produto) throws IOException {
        FileManager fileManager = new FileManager();
        BufferedWriter bufferedWriter = fileManager.getEscritor("data/produtos.txt", true);

        SequenceManager sequenceManager = new SequenceManager();

        produto.setId(sequenceManager.getProdutoSequence());

        bufferedWriter.write(produto.toString() + "\n");


        bufferedWriter.flush();
        bufferedWriter.close();

        return produto;

    }

    //busca read
    public Produto buscarProduto(String nome) throws IOException {
        FileManager fileManager = new FileManager();
        BufferedReader bufferedReader = fileManager.getLeitor("data/produtos.txt");

        String linha = bufferedReader.readLine();

        while (linha != null) {
            getProdutoFromLine(linha);
            Produto produto = getProdutoFromLine(linha);

            if (produto.getNome().equals(nome)) {

                return produto;
            }

            linha = bufferedReader.readLine();

        }
        System.out.println("Produto nao encontrado");
        return null;
    }

    private Produto getProdutoFromLine(String linha) { //getprodutofromline
        String[] dados = linha.split(":");
        return new Produto(Integer.valueOf(dados[0]), dados[1], Float.valueOf(dados[2]), Integer.valueOf(dados[3].replace(";", "")));


    }

    //deleta delete
    public void deletaProduto(String nome) throws IOException {
        FileManager fileManager = new FileManager();
        BufferedReader bufferedReader = fileManager.getLeitor("data/produtos.txt");

        List<Produto> listaDeProdutos = new ArrayList<>();

        String linha = bufferedReader.readLine();

        while (linha != null) {
            listaDeProdutos.add(getProdutoFromLine(linha));

            linha = bufferedReader.readLine();

        }

        Produto produto = null;
        //foreach: um produto para cada item da lista

        for (Produto produtoDaLista : listaDeProdutos) {
            if (nome.equals(produtoDaLista.getNome())) {
                produto = produtoDaLista;
            }
        }

        if (produto != null) {
            listaDeProdutos.remove(produto);
        }

        bufferedReader.close();

        BufferedWriter bufferedWriter = fileManager.getEscritor("data/produtos.txt", false);
        String tudoDalista = "";

        for (Produto produtoDaLista : listaDeProdutos) {

            tudoDalista = tudoDalista + produtoDaLista.toString() + "\n";

        }

        bufferedWriter.write(tudoDalista);


        bufferedWriter.flush();
        bufferedWriter.close();


    }


    //atualiza
}
