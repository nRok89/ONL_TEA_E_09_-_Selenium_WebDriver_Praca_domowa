package homework;

import java.util.List;
import java.util.Random;

public class Petent {
    List<String> listName = List.of("Jan", "Janina", "Krzysztof", "Mieszko", "Marika", "Julia", "Adam", "Alina", "Marek", "Liliana", "Zbigniew", "Ruszadr", "Cezary", "Alicja", "Ewa");
    List<String> listLastName = List.of("Reina", "Koke", "Loko", "Pop", "Kot", "Sowa", "Kruk", "Noc", "Nowak", "Kwiat", "Konopa", "Mickiewicza", "Sienkiewicza", "Papaj", "Lech", "Psuj");
    List<String> listDomen = List.of("gmail.com", "onet.pl", "interia.pl", "wp.pl", "o2.com");
    List<String> listCity = List.of("Warszawa", "Poznań", "Wrocław", "Kielce", "Katowice", "Inowrocław", "Kruszwica");
    List<String> listAdress = List.of("Mickiewicza", "Słowackiego", "Tuwima", "Sienkiewicza", "Leśmiana", "Zeusa", "Hery", "Apolla", "Posejdona");


    String name = rName();
    String lastName = rLastName();
    String domena = rDomena();
    String rNumber = rRandom();
    String email = name + "." + lastName + rNumber + "@" + domena;
    String password = lastName + rNumber + name;
    String birthdate = rBirthdate();
    String adress = rAdress();
    String city = rCity();

    public Petent() {

    }

    public String rName() {
        Random rName = new Random();
        int index = rName.nextInt(listName.size());
        return listName.get(index);
    }

    public String rLastName() {
        Random rLastName = new Random();
        int index = rLastName.nextInt(listLastName.size());
        return listLastName.get(index);
    }




    public String rDomena() {
        Random rDomena = new Random();
        int index = rDomena.nextInt(listDomen.size());
        return listDomen.get(index);
    }

    public String rRandom() {
        Random random = new Random();
        int s = random.nextInt(9999);
        String rNumber = Integer.toString(s);
        return rNumber;
    }

    public String rCity() {
        Random rCity = new Random();
        int index = rCity.nextInt(listCity.size());
        return listCity.get(index);
    }

    public String rAdress() {
        Random rAdress = new Random();
        int index = rAdress.nextInt(listAdress.size());
        return listAdress.get(index);
    }


    public String rBirthdate() {
        int fo = 2;
        Random random = new Random();
        int rPart1 = random.nextInt(12) + 1;
        int rPart2 = random.nextInt(31) + 1;
        int rPart3 = random.nextInt(100) + 1908;
        if (!(rPart1 % 2 == 0) && rPart2 > 30) {
            rPart2 = 30;
        }
        if (rPart2 > 28 && rPart1 == 2) {
            rPart2 = 28;
        }

        String mm = Integer.toString(rPart1);
        String dd = Integer.toString(rPart2);
        String yyyy = Integer.toString(rPart3);

        return mm + "/" + dd + "/" + yyyy;
    }


}
