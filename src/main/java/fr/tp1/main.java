package fr.tp1;

public class main {

    public static void main (String[] args){

        //ServeurTcpEcho serveurTcpEcho = new ServeurTcpEcho(50013);
        //serveurTcpEcho.demarrer();

        //clientTcpEcho pouet = new clientTcpEcho("10.203.9.99", 50007);
        //pouet.envoyer();

        //ServeurTcpEchoMulti serveurTcpEchoMulti = new ServeurTcpEchoMulti(50013);
        //serveurTcpEchoMulti.demarrer();

        //ClientSmtp clientSmtp = new ClientSmtp("139.124.187.23",25,"pauletto");
        //clientSmtp.send("Pape.Francois<lemaildupape@paradis.com>","pech","Bonjour, mon frère","Bonjour mon bon, ici le pape, je te souhaite de passer une belle journée ensoleillée ! \nA la prochaine ! \nQue Dieu te protège et te guide dans le droit chemin !");

        //ClientPop3 clientPop3 = new ClientPop3("139.124.187.23",110);
        //clientPop3.recupMail("pauletto","pauletto",1);

        ClientTp4 clientTp4 = new ClientTp4("10.203.9.145",2000);
        clientTp4.getFichier("image1.jpeg","img.jpeg");
        clientTp4.getFichier("image2.jpeg","img2.jpeg");

    }
}
