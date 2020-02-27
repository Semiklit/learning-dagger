package daggers;

import daggers.commands.common.Command;
import daggers.components.DaggerCommandProcessorFactory;

import java.util.Scanner;

public class CommandLineAtm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandProcessor commandProcessor = DaggerCommandProcessorFactory.create().processor();
        while (scanner.hasNextLine()) {
            Command.Status commandStatus = commandProcessor.process(scanner.nextLine());
            if (commandStatus.equals(Command.Status.INPUT_COMPLETED)) {
                break;
            }
        }
    }
}
