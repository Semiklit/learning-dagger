package daggers;

import daggers.commands.common.Command;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class CommandRouter {

    @Inject
    CommandRouter(Map<String, Command> commands) {
        this.commands = commands;
    }

    private Map<String, Command> commands;

    public Command.Result route(String input) {
        List<String> splitInput = split(input);
        if (splitInput.isEmpty()) {
            return invalidCommandInput(input);
        }

        String commandKey = splitInput.get(0);
        Command command = commands.get(commandKey);
        if (command == null) {
            return invalidCommandInput(input);
        }

        Command.Result result = command.handleInput(splitInput.subList(1, splitInput.size()));
        if (result.getStatus() == Command.Status.INVALID) {
            System.out.println(commandKey + ": invalid argument");
        }
        return result;
    }

    private Command.Result invalidCommandInput(String input) {
        System.out.println(String.format("couldn't understand \"%s\". please try again.", input));
        return Command.Result.invalid();
    }

    private static List<String> split(String input) {
        return Arrays.asList(input.split(" "));
    }
}
