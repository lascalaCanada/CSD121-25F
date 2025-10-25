/*

enum Response { YES, NO, MAYBE };

enum Status { Shipped, Ordered, Completed };

enum Directions { N, S, E, W }

enum HairColor { Black, White, Gray, Blond, Brown, Red, Blue }

// Declaring the record TYPE <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
// in the parenthesis = variables
record Person (String name, LocalDate birthdate, HairColor hairColor) {}



void main () {

    // Using the Person record <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    var p = new Person("Bob", LocalDate.of(1981, 10, 30), HairColor.Blond);

    // Another way to use the Person record <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    // Class LocalDate <<<<
    var p1 = new Person("Bob", LocalDate.now(), HairColor.Blond);

    IO.println(p.birthdate.toString());

    // How to change information inside aa record?
    var newP = new Person("Bobby", p.birthdate(), p.hairColor);


}

Direction silly(Reponse r) {
    return switch (r) {
        case YES -> Directions.S;
        case NO -> Directions.N;
        case MAYBE -> Math.random() < 0.5 ? Direction.E : Direction.W;
            // IN Python: Direction.E if random() < 0.5 else Direction.W
    };
}

// an infinit number of response -- uses the DEFAULT
Direction silly(String Response) throws Exception {
    return switch (Reponse) {
        case YES -> Directions.S;
        case NO -> Directions.N;
        case MAYBE -> Math.random() < 0.5 ? Direction.E : Direction.W;
        default -> {
            throw new Exception("Invalid response!");
        }
        // IN Python: Direction.E if random() < 0.5 else Direction.W
    };
}

// Sep 30th, 2025
// calculate the distance between 2 points
/*
var d= Math.sqrt (
    Math.pow(varLat.get(i) - userLat, 2) +
    Math.pow(varLon.get(i) - userLong, 2)
)
* 111.1 // Approx conversion factor from degrees in Kms
 */


enum HealthFacilityType { HOSPITAL, CLINIC }
/*
record Location ( double lat, double lng ){
    Location {
        if (lat < -90 || lat > 90) { throw new IllegalArgumentException("Latitude must be between -90 and 90");
        if (lng < -180 || lng > 180) { throw new IllegalArgumentException("Longitudes must be between -180 and 180");
    }
}
*/


/*

    - A deck of cards (with the ability

 */







