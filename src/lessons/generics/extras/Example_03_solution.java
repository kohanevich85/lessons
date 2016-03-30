package lessons.generics.extras;

public class Example_03_solution {

    public static void main(String[] args) {
        Builder builder = new DoubleExtendedBuilder().setField("parent").setFieldB("child").setFieldC("grandson");
        String result = builder.build();
        System.out.println(result);

        Builder builder_ = new ExtendedBuilder<>().setField("parent").setFieldB("child");
        result = builder_.build();
        System.out.println(result);
    }

    interface Builder {
        String build();
    }

    static class BuilderImpl<T extends BuilderImpl<T>> implements Builder {
        private String fieldA;

        private T item;

        public String getFieldA() {
            return fieldA;
        }

        @SuppressWarnings("unchecked")
        public T setField(String fieldA) {
            this.fieldA = fieldA;
            return (T) this;
        }

        @Override
        public String build() {
            return fieldA;
        }
    }

    static class ExtendedBuilder<T extends ExtendedBuilder<T>> extends BuilderImpl<T> {
        private String fieldB;

        private T item;

        public String getFieldB() {
            return fieldB;
        }

        @SuppressWarnings("unchecked")
        public T setFieldB(String fieldB) {
            this.fieldB = fieldB;
            return (T) this;
        }

        @Override
        public String build() {
            return getFieldA() + " " + fieldB;
        }
    }

    static class DoubleExtendedBuilder extends ExtendedBuilder<DoubleExtendedBuilder> {
        private String fieldC;

        public String getFieldC() {
            return fieldC;
        }

        public DoubleExtendedBuilder setFieldC(String fieldC) {
            this.fieldC = fieldC;
            return this;
        }

        @Override
        public String build() {
            return getFieldA() + " " + getFieldB() + " " + getFieldC();
        }
    }
}
