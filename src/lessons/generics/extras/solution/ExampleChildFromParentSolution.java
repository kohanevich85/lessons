package lessons.generics.extras.solution;

public class ExampleChildFromParentSolution {
    public static void main(String[] args) {
        AbstractAction and = new ConcreteActionA().and();//.pipelineA().with();
    }
}

interface Action {
    void execute();
}

abstract class AbstractAction implements Action {
    public AbstractAction and() { return this; }
    public AbstractAction with() { return this; }
}

class ConcreteActionA extends AbstractAction {
    @Override
    public void execute() { System.out.println("concrete action A"); }

    ConcreteActionA pipelineA() {
        System.out.println("in pipelineA ...");
        return this;
    }
}

class ConcreteActionB extends AbstractAction {
    @Override
    public void execute() { System.out.println("concrete action B"); }

    ConcreteActionB pipelineB() {
        System.out.println("in pipelineA B ...");
        return this;
    }
}