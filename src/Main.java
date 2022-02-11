import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Main {

    public static void main(String[] args) {
        List<Jugadores>players = buildPlayersList();
        Jugadores playerMaxPoints = getPlayerMaxPoints(players);
        List<Jugadores> top5BasketsOrderByMaxToMin = getTop5BasketsOrderByMaxToMin(players);
        System.out.println("Mejor jugador:  "+playerMaxPoints);
        double averagePoints = calculateAveragePoints(players);
        System.out.println("Promedio de canastas:  "+ averagePoints);
        System.out.println("Top 5"+ top5BasketsOrderByMaxToMin);
        System.out.println(calculateAVGPoints(players));
        String team = "BOET";
        double avg = calculateAvgPointsByTeam(players, team);

        System.out.println("El avg de los puntos de los" +
                " jugadores del equipo " + team + " es " + avg);
    }
    private static double calculateAVGPoints(List<Jugadores> players) {
        return players.stream()
                .mapToInt(Jugadores::getNumBaskets)
                .average()
                .getAsDouble();

    }


    private static double calculateAvgPointsByTeam
            (List<Jugadores> players, String team) {

        //1. Creo un ArrayList auxiliar vacio
        List<Jugadores> playersFromTeam = new ArrayList<>();

        //2. Agrupar los jugadores de un equipo en particular en
        //ArrayList auxiliar (ejemplo BOET)
        for (Jugadores currentPlayer : players) {
            if (currentPlayer.getTeam().equalsIgnoreCase(team)) {
                playersFromTeam.add(currentPlayer);
            }
        }

        //3. Calcular AVG de puntos de los
        // jugadores del ArrayList auxiliar (ejemplo BOET)
        double totalPoints = 0;

        for (int i = 0; i < playersFromTeam.size(); i++) {
            Jugadores currentPlayer = playersFromTeam.get(i);
            totalPoints = totalPoints + currentPlayer.getNumBaskets();
        }

        double avg = totalPoints / playersFromTeam.size();

        return avg;
    }

    private static List<Jugadores> getTop5BasketsOrderByMaxToMin(List<Jugadores> players) {
       return players.stream().sorted(Comparator.comparing(Jugadores::getNumBaskets).reversed())
           .limit(5)
               .collect(Collectors.toList());

    }

    private static double calculateAveragePoints(List<Jugadores> players) {
        double sumTotalBaskets= 0;

        for (int i=0; i<players.size(); i++){
            sumTotalBaskets+= players.get(i).getNumBaskets();
        }
        return sumTotalBaskets/players.size();
    }
    // es lo mismo que
   // private static double getAveragePoints(List<Jugadores> players) {

    //    double acumulador = 0;

     //   for (int i = 0; i < players.size(); i++) {
     //       Jugadores currentPlayer = players.get(i);
     //       acumulador = acumulador + currentPlayer.getNumBaskets();
     //   }
     //   double resultado = acumulador / players.size();
     //   return resultado;
  //  }

    private static List<Jugadores> buildPlayersList () {
        List<Jugadores>players = new ArrayList<>();
        Jugadores rocio = new Jugadores("Rocìo", 79, "ABPRE");
        Jugadores xavi = new Jugadores("Xavi", 46,"GENT");
        Jugadores sergi = new Jugadores("Sergi", 54, "ABPRE");
        Jugadores olga = new Jugadores("Olga",93,"ABPRE");
        Jugadores fabi = new Jugadores("Fabi", 47,"GENT");
        Jugadores jose = new Jugadores("Jose", 50,"CDA");
        Jugadores marco = new Jugadores("Marco", 82, "CDA");
        Jugadores karla = new Jugadores("Karla", 86,"CDA");
        Jugadores oscar = new Jugadores("Oscar", 99,"CDA");

        players.add(rocio);
        players.add(xavi);
        players.add(sergi);
        players.add(olga);
        players.add(fabi);
        players.add(jose);
        players.add(marco);
        players.add(karla);
        players.add(oscar);
        return players;
    }

 //   private static Jugadores getPlayerMaxPoints(List<Jugadores>players){
 //       Jugadores playerMaxPoints = players.get(0);
 //       for(Jugadores currentPlayer : players) {
 //           if (currentPlayer.getNumBaskets() > playerMaxPoints.getNumBaskets()) ;
//            playerMaxPoints = currentPlayer;
//        }
//        return playerMaxPoints;

 //   }
    private static Jugadores getPlayerMaxPoints (List<Jugadores>players){
        return players.stream().max(comparing(Jugadores::getNumBaskets)).get();
    }

}
