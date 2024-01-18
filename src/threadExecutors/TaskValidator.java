package threadExecutors;

import java.util.concurrent.Callable;

/**
 * Created by kantipin on 18.05.2016.
 */
public class TaskValidator implements Callable<String> {

    private UserValidator validator;
    String user;
    String password;

    public TaskValidator(UserValidator validator, String user, String password) {
        this.validator = validator;
        this.user = user;
        this.password = password;
    }

    @Override
    public String call() throws Exception {
        if (!validator.validate(user, password)) {
            System.out.printf("TaskValidator : validator %s : the user %s was not found\n", validator.getName(), user);
            throw new Exception("Error validating user " + user);
        }

        System.out.printf("TaskValidator: validator %s : the user %s was found\n", validator.getName(), user);
        return validator.getName();
    }
}
