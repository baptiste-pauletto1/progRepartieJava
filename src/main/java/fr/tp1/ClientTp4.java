package fr.tp1;

import java.io.*;
import java.net.Socket;

public class ClientTp4 {

    private String serveurTp4;
    private int port;

    public ClientTp4(String serveurTp4, int port) {
        this.serveurTp4 = serveurTp4;
        this.port = port;
    }

    public void getFichier(String nomFichier,String dest) {
        try {
            Socket sockClient = new Socket(serveurTp4,port);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(sockClient.getOutputStream()));

            bufferedWriter.write(nomFichier);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            InputStream inputStream = sockClient.getInputStream();

            byte buffer[] = new byte[512];


            FileOutputStream fileOutputStream = new FileOutputStream(dest);

            int nbOctets;
            while ((nbOctets= inputStream.read(buffer)) !=-1){
                fileOutputStream.write(buffer,0,nbOctets);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
