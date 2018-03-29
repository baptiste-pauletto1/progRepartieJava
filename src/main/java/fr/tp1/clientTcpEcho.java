package fr.tp1;



import java.io.*;
import java.net.*;

public class clientTcpEcho {

    private String hostname;
    private int port;

    public clientTcpEcho(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    private static String lecteurClavier() {
        String choix = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            choix = in.readLine();
        } catch (IOException e) {
            System.out.println("Problème de saisie");
        }
        return choix;
    }

    public void envoyer(){
    //Autre façon de le faire, voir Guilhem Pech, c'est avec un scanner.
        try {

            Socket sockClient = new Socket(this.hostname,this.port);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(sockClient.getOutputStream()));

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sockClient.getInputStream()));

            while (true){

                String ligne;
                String contenu = lecteurClavier();

                if (contenu.equals("quitter")) break;

                bufferedWriter.write(contenu);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                ligne = bufferedReader.readLine();
                System.out.println(ligne);

            }
            System.out.println("Déconnexion du serveur...");
            bufferedReader.close();
            bufferedWriter.close();

            sockClient.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
