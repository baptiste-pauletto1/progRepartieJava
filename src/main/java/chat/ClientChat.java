package chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {

    private String ip;
    private int port;

    public ClientChat(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void connecter(){
        try {
            Socket socketClient = new Socket(ip,port);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));

            String serveurAnswer;

            Scanner scanner = new Scanner(System.in);

            System.out.println("Je me connecte à : " + ip + " sur le port : " + port);

            while (true) {
                System.out.print("Vous : ");

                String message = scanner.nextLine();

                if (message.equals("quit")) break;
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                serveurAnswer = bufferedReader.readLine();
                if (serveurAnswer.equals("quit")) break;

                System.out.println("Reçu : " + serveurAnswer);
            }

        }catch (IOException e ){
            e.printStackTrace();
        }

    }

}
