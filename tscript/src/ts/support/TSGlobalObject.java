package ts.support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ts.Message;

public class TSGlobalObject extends TSObject{

  static Readln readln = new Readln();
  static IsNaN isNaN = new IsNaN();
  static IsFinite isFinite = new IsFinite();
  static PrintXYZ printXYZ = new PrintXYZ();
  static TestThis testThis = new TestThis();

  public static TSGlobalObject globalObject = new TSGlobalObject();
  private static BufferedReader bufferedReader = new BufferedReader(
          new InputStreamReader(System.in));

  
  public TSGlobalObject() {
    super();
    this.putProperty("NaN", TSNumber.create(Double.NaN));
    this.putProperty("Infinity", TSNumber.create(Double.POSITIVE_INFINITY));
    this.putProperty("undefined", TSUndefined.value);
    supportFunctions();
  }
  
  public void supportFunctions(){
    TSFunctionObject isNaNFunc = new TSFunctionObject(isNaN, null);
    this.putProperty("isNaN", isNaNFunc); 
    
    TSFunctionObject readlnFunc = new TSFunctionObject(readln, null);
    this.putProperty("readln", readlnFunc); 
    
    TSFunctionObject isFiniteFunc = new TSFunctionObject(isFinite, null);
    this.putProperty("isFinite", isFiniteFunc); 
    
    TSObject hasxyz = new TSObject(null);
    TSFunctionObject printXYZFunc = new TSFunctionObject(printXYZ, null);
    hasxyz.putProperty("printXYZ", printXYZFunc);
    
    TSFunctionObject testThisFunc = new TSFunctionObject(testThis, null);
    testThisFunc.putPrototype(hasxyz);
    testThisFunc.setThis(this);
    this.putProperty("testThis", testThisFunc);   
  }
  
  static class TestThis implements TSCode{
    public TSValue execute(Boolean isConstructorCall, TSValue ths,
        TSValue[] args, TSLexicalEnvironment env) {
      if(ths == null){
        globalObject.putProperty("xyz", TSNumber.create(42));
        return globalObject;
      }
      else{
        ((TSObject)ths).putProperty("xyz", TSNumber.create(42));
      }
      return ths;
    }
    
  }

  static class PrintXYZ implements TSCode{
    public TSValue execute(Boolean isConstructorCall, TSValue ths,
        TSValue[] args, TSLexicalEnvironment env) {      
      if(ths == null){
        TSValue temp = globalObject.getProperty("xyz");
        System.out.println(temp.toStr().getInternal());
      }
      else{
        TSValue temp = ((TSObject)ths).getProperty("xyz");
        System.out.println(temp.toStr().getInternal());
      }
      return null;
    }
    
  }

  static class Readln implements TSCode{

    public TSValue execute(Boolean isConstructorCall, TSValue ths,
        TSValue[] args, TSLexicalEnvironment env) {
      String temp; 
      try{
        temp = bufferedReader.readLine();
          if(temp == null){
            return TSString.create("");
          }
          else{
            temp += "\n";
            return TSString.create("");
          }
      }
      catch(IOException e){
      }
      return TSString.create("");
    }
  }
  
  static class IsNaN implements TSCode{

    public TSValue execute(Boolean isConstructorCall, TSValue ths,
        TSValue[] args, TSLexicalEnvironment env) {
      if(args.length > 0){
          if(Double.isNaN(args[0].toNumber().getInternal())){
              return TSBoolean.create(true);
          }
          else{
              return TSBoolean.create(false);
          }
      }
      else{
          throw new TSException("Should have more than one argument");
      }
    }
    
  }
  
  static class IsFinite implements TSCode{

    public TSValue execute(Boolean isConstructorCall, TSValue ths,
        TSValue[] args, TSLexicalEnvironment env) {
        if(args.length > 0){
            if(Double.isNaN(args[0].toNumber().getInternal())){
                return TSBoolean.create(false);
            }
            else{
              if(Double.isInfinite(args[0].toNumber().getInternal())){
                return TSBoolean.create(false);
              }
                return TSBoolean.create(true);
            }
        }
        else{
            throw new TSException("Should have more than one argument");
        }
    }
  }
}
