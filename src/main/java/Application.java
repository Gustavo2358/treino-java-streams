import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) throws IOException {
        Path datasetPath = Path.of("src", "main", "resources", "titanic.csv");

        var passengers = Files.lines(datasetPath)
                .skip(1)
                .map(line -> line.split(","))
                .map(p -> new Passenger(p[0].equals("1"),
                        Integer.parseInt(p[1]),
                        p[2],
                        p[3],
                        Double.parseDouble(p[4]),
                        p[5].equals("1"),
                        p[6].equals("1"),
                        Double.parseDouble(p[7])))
                .collect(Collectors.toList());

        //passageiros
        //passengers.forEach(System.out::println);

        System.out.println("quantidade de passageiros por classe");
        var passengersByClass = passengers.stream()
                .collect(Collectors.groupingBy(Passenger::getPassengerClass, Collectors.counting()));

        passengersByClass.forEach((classe, qtd) -> System.out.printf("classe: %d - qtd: %d%n", classe, qtd));

        System.out.println();

        System.out.println("quantidade de passageiros que não sobreviveram, separados por classe");
        var notSurvivedByClass = passengers.stream()
                .filter(passenger -> !passenger.Survived())
                .collect(Collectors.groupingBy(Passenger::getPassengerClass, Collectors.counting()));

        notSurvivedByClass.forEach((classe, qtd) -> System.out.printf("classe: %d - qtd: %d%n", classe, qtd));

        System.out.println();

        System.out.println("Porcentagem de mortes por classe");
        var percentage = passengersByClass.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(),
                        e -> asPercent(notSurvivedByClass.get(e.getKey()), e.getValue() )));
        percentage.forEach((k,v) -> System.out.printf("Classe: %d Não sobreviveram: %s%n", k, v));

        System.out.println();

        System.out.println("Porcentagem de homens da terceira classe que não sobreviveram");
        var thirdClassMenNotSurvived = passengers.stream()
                .filter(p -> p.getSex().equals("male") &&
                        p.getPassengerClass() == 3 &&
                        p.Survived() == false)
                .count();

        var thirdClassMen = passengers.stream()
                        .filter(p -> p.getPassengerClass() == 3 &&
                                p.getSex().equals("male"))
                        .count();
        System.out.println(asPercent(thirdClassMenNotSurvived, thirdClassMen));


    }

    private static String asPercent(Long part, Long total ){
        return String.format("%2.1f%%", part / (double)total * 100)
                .replace(",",".");
    }
}
