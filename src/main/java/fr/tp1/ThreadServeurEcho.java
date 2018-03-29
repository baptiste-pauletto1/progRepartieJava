package fr.tp1;

import java.io.*;
import java.net.Socket;

public class ThreadServeurEcho extends Thread {
    private Socket client;

    public ThreadServeurEcho(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        BufferedReader in;
        BufferedWriter out;
        try{
            System.out.println("Client " + client.getInetAddress().getHostAddress());
            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String messageRecu;
            while ((messageRecu = in.readLine()) != null) {
                out.write(messageRecu.toUpperCase());
                out.newLine();
                out.flush();
            }
            out.close();
            in.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
