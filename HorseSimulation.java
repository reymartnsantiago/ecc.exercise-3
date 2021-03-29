import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HorseSimulation {
    private List<Horse> healthyHorses;

    public HorseSimulation(int numberOfHorses, int targetDestination) {

        healthyHorses = Stream.generate(getHorses((int) Math.random(), targetDestination)).limit(numberOfHorses)
                .collect(Collectors.toList());

        healthyHorses.stream().filter(horses -> horses.isHealthy()).collect(Collectors.toList());
    }

    public Supplier<Horse> getHorses(int currentLocation, int targetDestination) {
        return () -> new Horse(Utility.randomString(), currentLocation, targetDestination);

    }

    public int getSize() {
        return this.healthyHorses.size();
    }

    public boolean simulate() {

        List<Horse> remainingHorses = getRemainingHorses();

        while (!remainingHorses.isEmpty()) {
            remainingHorses = getRemainingHorses();
            remainingHorses.parallelStream().forEach(horse -> {
                horse.setName(horse.getName().toUpperCase());
                horse.run();
            }

            );

        }
        return remainingHorses.size() > 0;
    }

    public List<Horse> getRemainingHorses() {

        return this.healthyHorses.stream().filter(horse -> !horse.isFinish()).collect(Collectors.toList());
    }
}
