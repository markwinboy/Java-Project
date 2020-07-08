package ru.nsu.gameClientBD;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        SC2Player player1 = new SC2Player("Mark",100,LeagueManager.League.GOLD,LeagueManager.Race.TERRAN);
        SC2Player player11 = new SC2Player("Mark1",100,LeagueManager.League.GOLD,LeagueManager.Race.TERRAN);
        SC2Player player2 = new SC2Player("Ksuha",90, LeagueManager.League.PRO,LeagueManager.Race.ZERG);
        SC2Player player3 = new SC2Player("Toxa",90, LeagueManager.League.SILVER,LeagueManager.Race.PROTOSS);
        LeagueManagerImpl arlist = new LeagueManagerImpl();
        arlist.addPlayer(player1);
        arlist.addPlayer(player2);
        arlist.addPlayer(player3);
        arlist.addPlayer(player11);
        arlist.removePlayer(player3);
        for(SC2Player o: arlist.getAllPlayers()){
            System.out.println(o);
        }
        for(SC2Player o: arlist.getPlayers(LeagueManager.League.PRO)){
            System.out.println(o);
        }
        arlist.addPoints("Mark",10);
        System.out.println(arlist.getPlayer("Mark"));
        SC2Player[] key = arlist.getPlayers(LeagueManager.Race.ZERG);
        for(SC2Player o: key){
            System.out.println(o);
        }
}
}
