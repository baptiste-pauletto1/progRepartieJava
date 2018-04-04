package fr.tp1;

import java.io.*;
import java.net.Socket;

public class ClientPop3 {
    private String serveurPop3;
    private int port;

    public ClientPop3(String serveurPop3, int port) {
        this.serveurPop3 = serveurPop3;
        this.port = port;
    }

    public boolean checkState(String string){
        return string.charAt(0) == '+';
    }

    public void recupMail(String user, String password,int mailNumber){
        try {
            Socket sockClient = new Socket(serveurPop3, port);
            String reponseServeur;

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(sockClient.getOutputStream()));

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sockClient.getInputStream()));

            if (!checkState(reponseServeur = bufferedReader.readLine())){
                throw new IOException("Erreur Connexion : " + reponseServeur);
            }

            write(bufferedWriter,"USER " + user);

            if (!checkState(reponseServeur = bufferedReader.readLine())){
                throw new IOException("Erreur Identifiant : " + reponseServeur);
            }

            write(bufferedWriter,"PASS " + password);

            if (!checkState(reponseServeur = bufferedReader.readLine())){
                throw new IOException("Erreur Mot de passe : " + reponseServeur);
            }

            write(bufferedWriter,"RETR " + mailNumber);

            if (!checkState(reponseServeur = bufferedReader.readLine())){
                throw new IOException("Erreur Recuperation : " + reponseServeur);
            }

            recupererMail(bufferedReader);

            write(bufferedWriter,"QUIT");
            System.out.println("Bye !");

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void write(BufferedWriter writer,String content) throws IOException {
        writer.write(content);
        writer.newLine();
        writer.flush();
        System.out.println(content);
    }

    private void recupererMail(BufferedReader bufferedReader) throws IOException{
        StringBuilder messageReconstitue = new StringBuilder();
        String messageRecu;
        messageRecu = bufferedReader.readLine();
        while (messageRecu.isEmpty() || messageRecu.charAt(0) != '.' ) {
            messageRecu = bufferedReader.readLine();
            messageReconstitue.append(messageRecu + "\n");
        }
        System.out.println(messageReconstitue);
    }
}


