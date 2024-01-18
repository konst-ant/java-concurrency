package threadExecutors;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 18.05.2016.
 */
public class UserValidator {

    String name;

    public String getName() {
        return name;
    }

    public UserValidator(String name) {
        this.name = name;
    }

    public boolean validate(String user, String password) throws InterruptedException {
        Random random = new Random();
        System.out.printf("Validator : going to validate user %s\n", user);
        TimeUnit.SECONDS.sleep((long)(Math.random()*10));
        return random.nextBoolean();
    }
}
