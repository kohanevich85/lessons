package lessons.generics.extras;

public class Example_03_problem {

    public static void main(String[] args) {
        Builder builder = new ExtendedBuilderImpl().setField("parent");//.setField2();
        String result = builder.build();
        System.out.println(result);
    }

    interface Builder {
        String build();
    }

    static class BuilderImpl implements Builder {
        private String field;

        public String getField() {
            return field;
        }

        public BuilderImpl setField(String field) {
            this.field = field;
            return this;
        }

        @Override
        public String build() {
            return field;
        }
    }

    static class ExtendedBuilderImpl extends BuilderImpl {
        private String field2;

        public String getField2() {
            return field2;
        }

        public ExtendedBuilderImpl setField2(String field2) {
            this.field2 = field2;
            return this;
        }

        @Override
        public String build() {
            return getField() + " " + field2;
        }
    }
}
