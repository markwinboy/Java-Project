package ru.nsu.bankClientBD;

import java.util.Map;

public interface Bank {
    public void registerNewClient(Client client) throws NewExeption;

    public void expireClients(int num);

    public Map<String, Integer> getUniqueNameCount();

    public Client[] getAllClient();
}
