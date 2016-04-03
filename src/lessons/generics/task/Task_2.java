package lessons.generics.task;

public class Task_2 {

    public static void main(String[] args) {
        Builder builder = new DoubleExtendedBuilderImpl().setFieldA("parent");//.setFieldB("children"); //.setFieldC("grandson");
        String result = builder.build();
        System.out.println(result);
    }

    interface Builder {
        String build();
    }

    static class BuilderImpl implements Builder {
        private String fieldA;

        public String getFieldA() {
            return fieldA;
        }

        public BuilderImpl setFieldA(String fieldA) {
            this.fieldA = fieldA;
            return this;
        }

        @Override
        public String build() {
            return fieldA;
        }
    }

    static class ExtendedBuilderImpl extends BuilderImpl {
        private String fieldB;

        public String getFieldB() {
            return fieldB;
        }

        public ExtendedBuilderImpl setFieldB(String fieldB) {
            this.fieldB = fieldB;
            return this;
        }

        @Override
        public String build() {
            return getFieldA() + " " + fieldB;
        }
    }

    static class DoubleExtendedBuilderImpl extends ExtendedBuilderImpl {
        private String fieldC;

        public String getFieldC() {
            return fieldC;
        }

        public DoubleExtendedBuilderImpl setFieldC(String fieldC) {
            this.fieldC = fieldC;
            return this;
        }

        @Override
        public String build() {
            return getFieldA() + " " + getFieldB() + " " + fieldC;
        }
    }
}
