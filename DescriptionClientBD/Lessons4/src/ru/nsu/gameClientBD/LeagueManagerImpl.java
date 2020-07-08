package ru.nsu.gameClientBD;

import java.util.*;

public class LeagueManagerImpl implements LeagueManager {
    private static List<SC2Player> playerList = new ArrayList<SC2Player>();

    @Override
    public void addPlayer(SC2Player player) {
        playerList.add(player);
    }

    @Override
    public void removePlayer(SC2Player player) {
        playerList.remove(player);
    }

    @Override
    public SC2Player getPlayer(String name) {
        SC2Player player = null;
        for(SC2Player o: playerList){
            if (o.getNickName() == name){
                player = o;
            }
        }
        return player;
    }

    @Override
    public SC2Player[] getAllPlayers() {
        SC2Player[] array = playerList.toArray(new SC2Player[0]);
        return array;
    }

    @Override

    public SC2Player[] getPlayers(League league) {
        List<SC2Player> playerList1 = new ArrayList<SC2Player>();
        for(SC2Player o:playerList){
            if (o.getLeague() == league){
                playerList1.add(o);
            }
        }
        SC2Player[] array = new SC2Player[playerList1.size()];
        playerList1.toArray(array);
        return array;
    }

    @Override
    public SC2Player[] getPlayers(Race race) {
        List<SC2Player> playerList1 = new ArrayList<SC2Player>();
        for(SC2Player o:playerList){
            if (o.getRace() == race){
                playerList1.add(o);
            }
        }
        SC2Player[] array = playerList1.toArray(new SC2Player[0]);
        return array;
    }

    @Override
    public void addPoints(String name, int points) {
        for(SC2Player o:playerList){
            if (o.getNickName() == name){
                o.setPoints(o.getPoints()+points);
            }
        }
    }
}
