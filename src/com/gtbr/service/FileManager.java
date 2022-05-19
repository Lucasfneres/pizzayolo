package com.gtbr.service;

import java.io.*;

public class FileManager {

    public BufferedReader getLeitor(String diretorio) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(diretorio);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        return bufferedReader;
    }

    public BufferedWriter getEscritor(String diretorio, boolean append) throws FileNotFoundException{
        FileOutputStream fileOutputStream = new FileOutputStream(diretorio);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);


        return bufferedWriter;

    }
}
