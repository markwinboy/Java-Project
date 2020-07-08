package ru.nsu.gameClientBD;
import ru.nsu.gameClientBD.LeagueManager.Race;
import ru.nsu.gameClientBD.LeagueManager.League;
public class SC2Player{
    String nickName;
    int points;
    League league;
    Race race;
    @Override
    public String toString() {
        return "SC2Player{" +
                "nickName='" + nickName + '\'' +
                ", points=" + points +
                ", league=" + league +
                ", race=" + race +
                '}';
    }



    public SC2Player(String nickName, int points, League league, Race race){
        this.nickName = nickName;
        this.points = points;
        this.league = league;
        this.race = race;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getPoints() {
        return this.points;
    }

    public League getLeague() {
        return this.league;
    }

    public Race getRace() {
        return this.race;
    }


    public void setPoints(int points) {
        this.points = points;
    }
}
