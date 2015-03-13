import ts.Message;
import ts.support.*;
class me {
  public static void main(String args[])
  {
    try{
      TSLexicalEnvironment lexEnviron = TSLexicalEnvironment.newDeclarativeEnvironment(null);
      lexEnviron.declareVariable(TSString.create("undefined"),false);
      Message.setLineNumber(1);
      try
      {
        Message.setLineNumber(1);
        Message.setLineNumber(2);
        TSReference temp0 = lexEnviron.getIdentifierReference(TSString.create("x"));
        if(temp0.isUnresolvableReference())
        {
        throw new TSException(TSString.create("test"));
        }
        System.out.println(temp0.toStr().getInternal());
      }
      catch( TSException temp1){
        Message.setLineNumber(4);
        TSLexicalEnvironment lexicalEnvironment0 = TSLexicalEnvironment.newDeclarativeEnvironment(lexEnviron);
        lexicalEnvironment0.declareParameter("y", temp1.getValue());
        Message.setLineNumber(5);
        Message.setLineNumber(6);
        TSReference temp2 = lexicalEnvironment0.getIdentifierReference(TSString.create("y"));
        if(temp2.isUnresolvableReference())
        {
        throw new TSException(TSString.create("test"));
        }
        System.out.println(temp2.toStr().getInternal());
      }
        Message.setLineNumber(9);
        Message.setLineNumber(10);
        TSValue temp3 = TSString.create("finally");
        System.out.println(temp3.toStr().getInternal());
      Message.setLineNumber(12);
      try
      {
        Message.setLineNumber(12);
        Message.setLineNumber(13);
        TSValue temp4 = TSNumber.create(42.0);
        System.out.println(temp4.toStr().getInternal());
      }
      catch( TSException temp5){
        Message.setLineNumber(15);
        TSLexicalEnvironment lexicalEnvironment1 = TSLexicalEnvironment.newDeclarativeEnvironment(lexEnviron);
        lexicalEnvironment1.declareParameter("y", temp5.getValue());
        Message.setLineNumber(16);
        Message.setLineNumber(17);
        TSValue temp6 = TSNumber.create(43.0);
        System.out.println(temp6.toStr().getInternal());
        Message.setLineNumber(18);
        TSReference temp7 = lexicalEnvironment1.getIdentifierReference(TSString.create("y"));
        if(temp7.isUnresolvableReference())
        {
        throw new TSException(TSString.create("test"));
        }
        System.out.println(temp7.toStr().getInternal());
      }
        Message.setLineNumber(21);
        Message.setLineNumber(22);
        TSValue temp8 = TSString.create("finally");
        System.out.println(temp8.toStr().getInternal());
    }
    catch(TSException temp9){
    }
  }
}
