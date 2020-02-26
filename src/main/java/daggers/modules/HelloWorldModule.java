package daggers.modules;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import daggers.commands.HelloWorldCommand;
import daggers.commands.common.Command;

@Module
public abstract class HelloWorldModule {
    @Binds
    @IntoMap
    @StringKey("hello")
    abstract Command helloWorldCommand(HelloWorldCommand command);
}
