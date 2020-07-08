package ru.nsu.bankClientBD;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BankImpl implements Bank {
    private List<Client> clientsList = new ArrayList<Client>();


    public void Method(Client client1, Client client2) throws NewExeption {
        if (levenshtein(client1.getFIO(), client2.getFIO()) <= 2) {
            throw new NewExeption();
        }

    }

    @Override
    public void registerNewClient(Client client) throws NewExeption {
        int sum = 0;
        Client[] array = clientsList.toArray(new Client[0]);
        if (array.length == 0) {
            clientsList.add(client);
            return;
        }
        for (Client o : clientsList) {
            int count = levenshtein(o.getFIO(), client.getFIO());
            System.out.println(count);
            if (count > sum) {
                sum = count;
            }
            try {
                Method(o, client);
            } catch (NewExeption e) {
                System.out.println(e);
            }

        }
        if (sum > 2) {
            clientsList.add(client);
        }
    }


    @Override
    public void expireClients(int num) {
        for (int i = num - 1; i > -1; i -= 1) {
            clientsList.remove(i);
        }
    }

    @Override
    public Map<String, Integer> getUniqueNameCount() {
        Map<String, Integer> mapClient = new HashMap<String, Integer>();
        for (Client o : clientsList) {
            if (mapClient.containsKey(o.getFirstName()) != true) {
                mapClient.put(o.getFirstName(), 1);
            } else {
                mapClient.put(o.getFirstName(), mapClient.get(o.getFirstName()) + 1);
            }
        }
        return mapClient;
    }

    @Override
    public Client[] getAllClient() {
        Client[] array = clientsList.toArray(new Client[0]);
        return array;
    }

    // Method Levenshtein
    public int levenshtein(String s1, String s2) {
        return dist(s1.toCharArray(), s2.toCharArray());
    }

    public int dist(char[] s1, char[] s2) {
        int[][] d = new int[s1.length + 1][s2.length + 1];
        for (int i = 0; i < s1.length + 1; i++) {
            d[i][0] = i;

        }

        for (int j = 0; j < s2.length + 1; j++) {
            d[0][j] = j;
        }

        for (int i = 1; i < s1.length + 1; i++) {
            for (int j = 1; j < s2.length + 1; j++) {
                int d1 = d[i - 1][j] + 1;
                int d2 = d[i][j - 1] + 1;
                int d3 = d[i - 1][j - 1];
                if (s1[i - 1] != s2[j - 1]) {
                    d3 += 1;
                }

                d[i][j] = Math.min(Math.min(d1, d2), d3);
            }
        }
        return d[s1.length][s2.length];
    }
}
