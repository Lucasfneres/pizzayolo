package com.gtbr.dao;

import com.gtbr.controller.ProdutoController;
import com.gtbr.model.Produto;
import com.gtbr.service.FileManager;
import com.gtbr.service.SequenceManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProdutoDAO {

    public Produto persistirProduto(Produto produto, boolean isAtualizacao) throws IOException {
        FileManager fileManager = new FileManager();
        BufferedWriter bufferedWriter = fileManager.getEscritor("data/produtos.txt", true);


        if (!isAtualizacao) {
            SequenceManager sequenceManager = new SequenceManager();

            produto.setId(sequenceManager.getProdutoSequence());
        }

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
        //parte de deletar

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

    //listar todos produtos

    public List<Produto> listarProdutos() throws IOException {
        //abrir o arquivo
        FileManager fileManager = new FileManager();
        BufferedReader bufferedReader = fileManager.getLeitor("data/produtos.txt");

        //instanciar uma lista de produto vazia
        List<Produto> listaProdutos = new ArrayList<>();

        //pegar todos os itens do arquivo e adcionar uma instancia do produto na lista

        String linha = bufferedReader.readLine();

        while (linha != null) {
            listaProdutos.add(getProdutoFromLine(linha));
            linha = bufferedReader.readLine();

        }

        bufferedReader.close();
        //retornar a lista cheia
        return listaProdutos;
    }

    //atualiza
    public void atualizaProduto(Integer atributoEscolhido, String valorAtualizado, Produto produto) throws IOException {
        List<Produto> produtos = listarProdutos();

        for (Produto produtoDaLista : produtos) {
            if (produtoDaLista.getId().equals(produto.getId())) {

                switch (atributoEscolhido) {
                    case 1: {
                        produtoDaLista.setNome(valorAtualizado);
                        break;
                    }
                    case 2: {
                        produtoDaLista.setValor(Float.valueOf(valorAtualizado));
                        break;
                    }
                    case 3: {
                        produtoDaLista.setCodigoDeBarras(Integer.valueOf(valorAtualizado));
                        break;
                    }
                    default:
                        System.out.println("opção invalida");
                        break;
                }

                deletaProduto(produto.getNome());
                persistirProduto(produtoDaLista, true);

                ordenarLista();

            }

        }


    }

    private void ordenarLista() throws IOException{
        List<Produto>listaDeProduto = listarProdutos();
        listaDeProduto.sort(Comparator.comparingInt(Produto::getId));
        FileManager fileManager = new FileManager();

        BufferedWriter bufferedWriter = fileManager.getEscritor("data/produtos.txt", false);
        bufferedWriter.close();

        for (Produto produto : listaDeProduto){
            persistirProduto(produto,true);
        }
    }
}


