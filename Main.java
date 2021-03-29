
public class Main {

    public static void main(String[] args) {

        HorseSimulation obj = new HorseSimulation(Utility.getIntegerInput("Please input the number of horses: "),
                Utility.getIntegerInput("Please input the target location: "));

        // HorseSimulation obj = new HorseSimulation(),
        // );

        do {
            System.out.println("The number of healthy horses is less than 2.");
            obj = new HorseSimulation(Utility.getIntegerInput("Please input the number of horses: "),
                    Utility.getIntegerInput("Please input the target location: "));
        } while (obj.getSize() < 2);

        do {
            obj.simulate();

        } while (obj.simulate());

    }

}
