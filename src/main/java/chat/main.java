package chat;

public class main {

    public static void main (String[] args){

//    ServeurChat serveurChat = new ServeurChat(50007);
//    serveurChat.lancer();

    ClientChat clientChat = new ClientChat("127.0.0.1",50007);
    clientChat.connecter();

    }
}