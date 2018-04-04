package fr.tp1;

import java.io.*;
import java.net.Socket;

public class ClientSmtp {

    private String serveurSmtp;
    private int port;
    private String hostname;
    private String serveurAnswer;

    public ClientSmtp(String serveurSmtp, int port, String hostname) {
        this.serveurSmtp = serveurSmtp; //Destinataire
        this.port = port; // Port en écoutechez le destinataire : Par défaut 25
        this.hostname = hostname; // adresse ip / nom de machine du client SMTP
    }

    public void send(String from, String to, String subject, String body) {
        try {
            Socket sockClient = new Socket(serveurSmtp, port);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(sockClient.getOutputStream()));

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sockClient.getInputStream()));

            System.out.println(bufferedReader.readLine()); // Reception connexion OK

            write(bufferedWriter,bufferedReader,"MAIL FROM: " + from);
            write(bufferedWriter,bufferedReader,"RCPT TO: " + to);
            write(bufferedWriter,bufferedReader,"DATA");
            write(bufferedWriter,bufferedReader,"from: " + from + "\nto:" + to + "\nsubject:" + subject + "\n" + body + "\n.");
            write(bufferedWriter,bufferedReader,"QUIT");

        } catch (IOException e){
            e.printStackTrace();
        }

    }
    private void write(BufferedWriter writer, BufferedReader reader,String content) throws IOException {
        writer.write(content);
        writer.newLine();
        writer.flush();

        System.out.println(content);
        if ((serveurAnswer = reader.readLine()).charAt(0) =='4' || serveurAnswer.charAt(0) == '5'){
            throw new IOException("ERREUR : " + serveurAnswer);
        }
        System.out.println(serveurAnswer);
    }
}
