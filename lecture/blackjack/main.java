package lecture.blackjack;

public class main {

    public static void main(String[] args) {

        var response = promptYesNo("Do you want to play a round of blackjack? (yes / no) ");

        if ( response == "no" ) {
            System.exit(0);
        }

        var money = promptDollarAmount("How much money do you like to start? ");

    }

}
