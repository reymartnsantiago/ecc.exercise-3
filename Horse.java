import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Horse {
    private String name;
    private int currentLocation;
    private int targetLocation;
    private boolean isHealthy;
    private static List<Optional<String>> warcry;

    public Horse(String name, int currentLocation, int targetLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
        this.targetLocation = targetLocation;

        this.isHealthy = Math.random() > 5;
        Supplier<Optional<String>> horseWarcry = () -> {
            return (Math.random() > 2) ? Optional.empty() : Optional.of(Utility.randomString(5));
        };

        this.warcry = Stream.generate(horseWarcry).limit(10).collect(Collectors.toList());

    }

    public boolean isHealthy() {
        return this.isHealthy;
    }

    public boolean isFinish() {
        return this.currentLocation >= this.targetLocation;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int getRemainingLocation() {
        return this.targetLocation - this.currentLocation;
    }

    public boolean run() {
        Random rnd = new Random();
        int location = rnd.nextInt(10 - 1) + 1;
        this.currentLocation += location;
        if (!isFinish()) {

            System.out.printf("%s is currently at %d. %d meters left. \n", this.getName(), this.currentLocation,
                    getRemainingLocation());

        } else {
            int selectWarcry = rnd.nextInt(9 - 0) + 0;
            System.out.printf("%s has completed the race.\n%s's warcry: %s \n", this.getName(), this.getName(),
                    warcry.get(selectWarcry).orElse("No warcry"));

        }

        return true;
    }
}
