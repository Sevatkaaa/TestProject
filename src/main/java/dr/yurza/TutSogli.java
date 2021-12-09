package dr.yurza;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Map;

public class TutSogli {
    public static void main(String[] args) {
        SogliRunner.run(new DrYurza());
    }
}

class SogliRunner {
    public static void run(DrYurza dr) {
        Sogli sogli = new Sogli();
        initUsers(sogli);
        dr.setSogli(sogli);
        sogli.addUser(new User("Sov", false), true);
    }

    private static void initUsers(Sogli sogli) {
        sogli.addUser(new User("Yuranus", false), true);
        sogli.addUser(new User("Parhom", true), true);
        sogli.addUser(new User("Markiro", false), true);
        sogli.addUser(new User("ToshQa", false), true);
    }
}

@Data
class DrYurza {
    private Sogli sogli;
}

@Data
class Sogli {
    private Map<User, Boolean> sogliMap;

    public Boolean addUser(User user, Boolean sogli) {
        return sogliMap.put(user, sogli);
    }
}

@Data
@AllArgsConstructor
class User {
    private String name;
    private Boolean isDaun;
}
