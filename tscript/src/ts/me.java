package ts;

import ts.Message;
import ts.support.*;
class me {
  public static void main(String args[])
  {
    try{
      TSLexicalEnvironment lexEnviron = TSLexicalEnvironment.newObjectEnvironment(TSGlobalObject.globalObject);
      Message.setLineNumber(1);
      TSValue temp0 = lexEnviron.getIdentifierReference(TSString.create("x"));
      Message.setLineNumber(1);
      TSValue temp1 = lexEnviron.getIdentifierReference(TSString.create("testThis"));
      TSObject temp2;
      TSValue temp3 = temp1.getValue();
      if(temp3 instanceof TSFunctionObject){
      temp2 = (TSObject)((TSFunctionObject)temp3).functionCall(true, null, null);
      }
      else{
      temp2 = new TSObject();
      }
      if(temp3 instanceof TSObject && ((TSObject)temp3).hasPrototype() ){
        temp2.putPrototype(((TSObject)temp3).getPrototype());
      }
      TSValue temp4 = temp2.getValue();
      TSValue temp5 = temp0.simpleAssignment(temp4);
      Message.setLineNumber(2);
      Message.setLineNumber(2);
      Message.setLineNumber(2);
      TSValue temp6 = lexEnviron.getIdentifierReference(TSString.create("x"));
      TSPropertyReference temp7 =  new TSPropertyReference("printXYZ", temp6.getValue());
      TSFunctionObject temp8 = (TSFunctionObject)temp7.getValue();
      TSValue temp10 = temp8.functionCall(false, null,null);
    }
    catch(TSException temp11){
    }
  }
}
