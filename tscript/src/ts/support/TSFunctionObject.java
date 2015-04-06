package ts.support;

public class TSFunctionObject extends TSObject{
  private TSCode tsCode;
  private TSLexicalEnvironment tsLexicalEnvironment;
  private TSValue ths; 
  
  public TSFunctionObject(TSCode tsCode, TSLexicalEnvironment tsLexicalEnvironment){
    super(null);
    this.tsCode = tsCode;
    this.tsLexicalEnvironment = tsLexicalEnvironment;
  }

  public TSValue functionCall(boolean isConstructorCall, TSValue ths, TSValue args[])
  {
    return tsCode.execute(isConstructorCall, ths, args, tsLexicalEnvironment);
  }
  
  public TSCode getTSCode() {
    return tsCode;
  }
  
  public TSLexicalEnvironment getTSLexicalEnvironment(){
    return tsLexicalEnvironment;
  }
  
  public TSNumber toNumber() {
    // TODO Auto-generated method stub
    return null;
  }

  public TSBoolean toBoolean() {
    // TODO Auto-generated method stub
    return null;
  }

  public static TSFunctionObject createTSFunctionObject(
      final TSCode tsCode, final TSLexicalEnvironment tsLexicalEnvironment)
  {
    return new TSFunctionObject(tsCode,
        tsLexicalEnvironment);
  }
  
  public void setThis(TSValue ths)
  {
    this.ths = ths;
  }
  
}
