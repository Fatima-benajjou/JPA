package org.example.JPAZoo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class IHM {

    static Scanner scanner = new Scanner(System.in);
    static AnimauxDAO animauxDAO;

    public static void affichageMenu() {

        System.out.println("1 creation d'animaux\n" +
                "2 recherche par id\n" +
                "3 recherche par nom (le nom n'est par forcement unique)\n" +
                "4 recherche par regime alimentaire");
    }

    public static void debutApp() {
        animauxDAO = new AnimauxDAO();
        while (true) {
            affichageMenu();
            System.out.println("Selectionnez votre choix");
            int choixUser = scanner.nextInt();
            scanner.nextLine();

            switch (choixUser) {
                case 1 -> creationAnimaux();
            }

        }
    }

    private static void creationAnimaux () {
        System.out.println("Veuillez entrer le nom de l'animal");
        String saisieNom = scanner.nextLine();
        System.out.println("Veuillez saisir l'age");
        int saisieAge = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Quel est son régime alimentaire parmis ces possibilités (0 Carnivore,1 Herbivore, 2 Omnivore");
        int saisieRegime = scanner.nextInt();
        scanner.nextLine();
        RegimeAlimentaire choixRegime = RegimeAlimentaire.values()[saisieRegime];
        System.out.println("Entrez sa date d'entrée dans le zoo");
        String dateSaisie = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateformater = LocalDate.parse(dateSaisie,formatter) ;


        Animaux animaux = new Animaux();
        animaux.setNom(saisieNom);
        animaux.setAge(saisieAge);
        animaux.setDateArrivee(dateformater);
        animaux.setRegimeAlimentaire(choixRegime);

        animauxDAO.ajoutAnimaux(animaux); // cela permet de faire appel à DAO pour envoyer la nuovelle
        //instance dans la base

    }

}
