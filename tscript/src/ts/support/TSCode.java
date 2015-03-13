package ts.support;

public interface TSCode {
  public TSValue execute(
      Boolean isConstructorCall, TSValue ths, TSValue args[],
      TSLexicalEnvironment env
  ); 
}
