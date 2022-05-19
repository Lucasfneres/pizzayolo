package com.gtbr.dao;

import com.gtbr.model.Produto;
import com.gtbr.service.FileManager;
import com.gtbr.service.SequenceManager;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;

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

}
