package ru.nsu.bankClientBD;
import ru.nsu.bankClientBD.Client;
import ru.nsu.bankClientBD.BankImpl;

import java.util.Map;

public class Main {
    public static void main(String[] args) throws NewExeption {
        Client client1 = new Client("Mark", "Karap", "Surenovich");
        Client client2 = new Client("Mark", "Kerap", "Surenovich");
        Client client3 = new Client("Mark", "Kerapet", "Sergeevich");
        Client client4 = new Client("Mark", "Kerapat", "Surenivich");
        Client client5 = new Client("Mark", "Kerapatya", "Surinovich");
        Client client6 = new Client("Mark", "Kerapatya", "Surrrrrrr");
        BankImpl arlist = new BankImpl();
        System.out.println(client1);
        arlist.registerNewClient(client1);
        arlist.registerNewClient(client2);
        arlist.registerNewClient(client3);
        arlist.registerNewClient(client4);
        arlist.registerNewClient(client5);
        arlist.registerNewClient(client6);
        System.out.println(arlist.getAllClient().length);
        for (Client o: arlist.getAllClient()){
            System.out.println(o);
        }
        System.out.println();
        System.out.println(arlist.getUniqueNameCount().get("Mark"));
        System.out.println(arlist.getAllClient().length);
        arlist.expireClients(3);
        System.out.println(arlist.getAllClient().length);
    }


}
