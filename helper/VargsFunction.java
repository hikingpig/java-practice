package practice.helper;

@FunctionalInterface
@SuppressWarnings("unchecked")
public interface VargsFunction<T, U, V> {
  V apply(T arg1, U... args);
}
