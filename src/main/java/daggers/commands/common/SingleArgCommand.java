package daggers.commands.common;

import java.util.List;

abstract class SingleArgCommand implements Command {
    @Override
    public Command.Result handleInput(List<String> input) {
        return input.size() == 1 ? handleArg(input.get(0)) : Result.invalid();
    }

    protected abstract Command.Result handleArg(String string);
}
