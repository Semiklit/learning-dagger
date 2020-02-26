package daggers.commands;

import daggers.commands.common.Command;
import daggers.modules.Outputter;

import javax.inject.Inject;
import java.util.List;

public class HelloWorldCommand implements Command {
    private final Outputter outputter;

    @Inject
    HelloWorldCommand(Outputter outputter) {
        this.outputter = outputter;
    }

    @Override
    public Command.Result handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Command.Result.invalid();
        }
        outputter.output("world!");
        return Command.Result.handled();
    }
}
