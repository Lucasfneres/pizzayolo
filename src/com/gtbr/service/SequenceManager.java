package com.gtbr.service;

import java.io.*;

public class SequenceManager {
    public Integer getProdutoSequence() throws IOException {

        //abrir o arquivo
        FileManager fileManager = new FileManager();
        BufferedReader bufferedReader = fileManager.getLeitor("data/sequences/produto-sequences.txt");


        // ler o numero
        String numero = bufferedReader.readLine();
        Integer sequence = Integer.valueOf(numero);

        bufferedReader.close();


        BufferedWriter bufferedWriter = fileManager.getEscritor("data/sequences/produto-sequences.txt", false);

        //incrementar o numero
        //persistir o novo numero
        Integer sequenceNova = sequence +1;
        bufferedWriter.write(sequenceNova.toString());

        bufferedWriter.flush();
        bufferedWriter.close();

        //retornar o numero atual

        return sequence;
    }
}
