package practice.helper;

@FunctionalInterface
@SuppressWarnings("unchecked")
public interface VargsFunction<T,R> {
  R apply(T arg1, T... args);
}
