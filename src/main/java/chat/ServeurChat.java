package chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServeurChat {

    private int port;

    public ServeurChat(int port) {
        this.port = port;
    }

    public void lancer(){
        try {
            ServerSocket socketServeur = new ServerSocket(port);
            Socket socketClient;
            BufferedReader bufferedReader ;
            BufferedWriter bufferedWriter ;

            System.out.println("Serveur de chat lancé sur le port : " + port);

            String clientAnswer;

            Scanner scanner = new Scanner(System.in);

            socketClient = socketServeur.accept();
            System.out.println("Client " + socketClient.getInetAddress().getHostAddress());

                while (true) {

                    bufferedReader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));

                    clientAnswer = bufferedReader.readLine();
                    if (clientAnswer == null ||clientAnswer.equals("quit")) break;

                    System.out.println("Reçu : " + clientAnswer);

                    System.out.print("Vous : ");
                    bufferedWriter.write(scanner.nextLine());
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
