package daggers.components;

import dagger.Component;
import daggers.components.subcomponents.UserCommandRouter;
import daggers.modules.HelloWorldModule;
import daggers.modules.LoginCommandModule;
import daggers.modules.SystemOutModule;
import daggers.CommandProcessor;

import javax.inject.Singleton;

@Singleton
@Component(modules = {LoginCommandModule.class, HelloWorldModule.class, SystemOutModule.class, UserCommandRouter.InstallationModule.class})
public interface CommandProcessorFactory {
    CommandProcessor processor();
}
