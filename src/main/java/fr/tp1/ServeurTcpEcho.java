package fr.tp1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurTcpEcho {


    private int port;

    public ServeurTcpEcho(int port) {
        this.port = port;
    }

    public void demarrer() {
        try {

            Socket client;
            BufferedWriter out;
            BufferedReader in;
            ServerSocket serveur = new ServerSocket(port);
            for (int i = 1; i <= 100; i++) {

                client = serveur.accept();

                System.out.println("Client " + client.getInetAddress().getHostAddress());
                out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                String messageRecu;
                while ((messageRecu = in.readLine()) != null) {
                    out.write(messageRecu.toUpperCase());
                    out.newLine();
                    out.flush();
                }
                client.close();
            }
            serveur.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
