package fr.tp1;

public class main {

    public static void main (String[] args){

        //ServeurTcpEcho serveurTcpEcho = new ServeurTcpEcho(50013);
        //serveurTcpEcho.demarrer();

        //clientTcpEcho pouet = new clientTcpEcho("10.203.9.99", 50007);
        //pouet.envoyer();

        ServeurTcpEchoMulti serveurTcpEchoMulti = new ServeurTcpEchoMulti(50013);
        serveurTcpEchoMulti.demarrer();
    }
}
