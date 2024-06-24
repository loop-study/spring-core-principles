package hello.proxy.pureproxy.decorater;

import hello.proxy.pureproxy.decorater.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        Component component = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(component);
        client.execute();
    }

    @Test
    void decorator1() {
        Component realComponent = new RealComponent();
        Component messageDeco = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDeco);
        client.execute();
    }

    @Test
    void decorator2() {
        Component realComponent = new RealComponent();
        Component messageDeco = new MessageDecorator(realComponent);
        Component timeDeco = new TimeDecorator(messageDeco);
        DecoratorPatternClient client = new DecoratorPatternClient(timeDeco);
        client.execute();
    }
}
