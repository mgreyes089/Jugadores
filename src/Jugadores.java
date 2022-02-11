import java.util.Objects;

public class Jugadores {

    private String namePlayer;
    private String e_mail;
    private String team;
    private int height;
    private int dateOfBirth;
    private int numBaskets;
    private int numRebounds;
    private int numAssistance;

    public Jugadores(String namePlayer, int numBaskets, String team) {
        this.namePlayer = namePlayer;
        this.numBaskets = numBaskets;
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public int getNumBaskets() {
        return numBaskets;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public void setNumBaskets(int numBaskets) {
        this.numBaskets = numBaskets;
    }

    @Override
    public String toString() {
        return "Jugadores{" +
                "namePlayer='" + namePlayer + '\'' +
                ", team='" + team + '\'' +
                ", numBaskets=" + numBaskets +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jugadores)) return false;
        Jugadores jugadores = (Jugadores) o;
        return numBaskets == jugadores.numBaskets && namePlayer.equals(jugadores.namePlayer);
    }



}
