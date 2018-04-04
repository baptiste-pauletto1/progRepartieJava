package fr.tp1;

public class main {

    public static void main (String[] args){

        //ServeurTcpEcho serveurTcpEcho = new ServeurTcpEcho(50013);
        //serveurTcpEcho.demarrer();

        //clientTcpEcho pouet = new clientTcpEcho("10.203.9.99", 50007);
        //pouet.envoyer();

        //ServeurTcpEchoMulti serveurTcpEchoMulti = new ServeurTcpEchoMulti(50013);
        //serveurTcpEchoMulti.demarrer();

        ClientSmtp clientSmtp = new ClientSmtp("139.124.187.23",25,"pauletto");
        clientSmtp.send("Pape.Francois<lemaildupape@paradis.com>","pechz","Bonjour, mon frère","Bonjour mon bon, ici le pape, je te souhaite de passer une belle journée ensoleillée ! \nA la prochaine ! \nQue Dieu te protège et te guide dans le droit chemin !");
    }
}
