package lessons.generics.extras;

/**
 * Return child type from parent
 */
public class ExampleChildFromParent {
    public static void main(String[] args) {
        AbstractAction<ConcreteActionA> actionA = new ConcreteActionA();
        actionA.execute();
        actionA.and().pipelineA().with().pipelineA();

        AbstractAction<ConcreteActionB> actionB = new ConcreteActionB();
        actionB.execute();
        actionB.and().pipelineB().with().pipelineB();
    }
}

interface Action {
    void execute();
}

abstract class AbstractAction<T extends AbstractAction<T>> implements Action {
    @SuppressWarnings("unchecked")
    public T and() {
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T with() {
        return (T) this;
    }
}

class ConcreteActionA extends AbstractAction<ConcreteActionA> {
    @Override
    public void execute() {
        System.out.println("concrete action A");
    }

    ConcreteActionA pipelineA() {
        System.out.println("in pipelineA ...");
        return this;
    }
}

class ConcreteActionB extends AbstractAction<ConcreteActionB> {
    @Override
    public void execute() {
        System.out.println("concrete action B");
    }

    ConcreteActionB pipelineB() {
        System.out.println("in pipelineA B ...");
        return this;
    }
}