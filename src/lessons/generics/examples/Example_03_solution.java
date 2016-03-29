package lessons.generics.examples;

public class Example_03_solution {

    public static void main(String[] args) {
        Builder builder = new ExtendedBuilder<ExtendedBuilder>().setField("parent").setField2("children");
        String result = builder.build();
        System.out.println(result);
    }

    interface Builder {
        String build();
    }

    static class BuilderImpl<T extends Builder> implements Builder {
        private String field;

        public String getField() {
            return field;
        }

        @SuppressWarnings("unchecked")
        public T setField(String field) {
            this.field = field;
            return (T) this;
        }

        @Override
        public String build() {
            return field;
        }
    }

    static class ExtendedBuilder<T extends Builder> extends BuilderImpl<T> {
        private String field2;

        public String getField2() {
            return field2;
        }

        @SuppressWarnings("unchecked")
        public T setField2(String field2) {
            this.field2 = field2;
            return (T) this;
        }

        @Override
        public String build() {
            return getField() + " " + field2;
        }
    }
}
