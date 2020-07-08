package ru.nsu.gameClientBD;

public interface LeagueManager {
    public void addPlayer(SC2Player player);
    public void removePlayer(SC2Player player);
    public SC2Player getPlayer(String name);
    public SC2Player[] getAllPlayers();
    public SC2Player[] getPlayers(League league);
    public SC2Player[] getPlayers(Race race);
    public void addPoints(String name, int points);

    public enum Race {TERRAN, PROTOSS, ZERG}
    public enum League { PRO, DIAMOND, PLATINUM, GOLD, SILVER, BRONZE, PRACTICE }

}
