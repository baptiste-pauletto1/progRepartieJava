package fr.tp1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServeurTcpEchoMulti {

    private int port;

    ExecutorService pool = Executors.newFixedThreadPool(3);

    public ServeurTcpEchoMulti(int port) {
        this.port = port;
    }

    public void demarrer() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            for (int i = 0; i<10; i++) {
                Socket client = serverSocket.accept();
                ThreadServeurEcho threadServeurEcho = new ThreadServeurEcho(client);
                pool.execute(threadServeurEcho); //Appelle implicitement run()
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
