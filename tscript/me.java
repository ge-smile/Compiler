import ts.Message;
import ts.support.*;
class me {
  public static void main(String args[])
  {
    try{
      TSLexicalEnvironment lexEnviron = TSLexicalEnvironment.newObjectEnvironment(TSGlobalObject.globalObject);
      Message.setLineNumber(6);
      TSValue temp0 = lexEnviron.getIdentifierReference(TSString.create("F"));
      TSValue temp1 = TSNumber.create(42.0);
      TSValue temp2 = temp1.getValue();
      TSValue temp3 = temp0.simpleAssignment(temp2);
      Message.setLineNumber(8);
      Message.setLineNumber(8);
      Message.setLineNumber(8);
      TSPropertyReference temp4 =  new TSPropertyReference("x", TSGlobalObject.globalObject.getValue());
      TSValue temp5 = TSNumber.create(42.0);
      TSValue temp6 = temp5.getValue();
      TSValue temp7 = temp4.simpleAssignment(temp6);
      Message.setLineNumber(10);
      Message.setLineNumber(10);
      Message.setLineNumber(10);
      TSPropertyReference temp8 =  new TSPropertyReference("x", TSGlobalObject.globalObject.getValue());
      System.out.println(temp8.toStr().getInternal());
      Message.setLineNumber(12);
      TSValue temp9 = lexEnviron.getIdentifierReference(TSString.create("x"));
      Message.setLineNumber(12);
      TSValue temp10 = lexEnviron.getIdentifierReference(TSString.create("testThis"));
      TSObject temp11;
      TSValue temp12 = temp10.getValue();
      if(temp12 instanceof TSFunctionObject){
      temp11 = (TSObject)((TSFunctionObject)temp12).functionCall(true, null, null);
      }
      else{
      temp11 = new TSObject();
      }
      if(temp12 instanceof TSObject && ((TSObject)temp12).hasPrototype() ){
        temp11.putPrototype(((TSObject)temp12).getPrototype());
      }
      TSValue temp13 = temp11.getValue();
      TSValue temp14 = temp9.simpleAssignment(temp13);
      Message.setLineNumber(13);
      Message.setLineNumber(13);
      Message.setLineNumber(13);
      TSValue temp15 = lexEnviron.getIdentifierReference(TSString.create("x"));
      TSPropertyReference temp16 =  new TSPropertyReference("printXYZ", temp15.getValue());
      TSFunctionObject temp17 = (TSFunctionObject)temp16.getValue();
      TSValue temp18 = temp16.getValue();
      TSObject temp19 = null;
      if(temp18 instanceof TSObject){
      temp19 = temp18;
      }
      else{
      }
      TSValue temp21 = temp17.functionCall(false, null,null);
      Message.setLineNumber(15);
      TSValue temp22 = lexEnviron.getIdentifierReference(TSString.create("x"));
      Message.setLineNumber(15);
      TSValue temp23 = lexEnviron.getIdentifierReference(TSString.create("F"));
      TSObject temp24;
      TSValue temp25 = temp23.getValue();
      if(temp25 instanceof TSFunctionObject){
      temp24 = (TSObject)((TSFunctionObject)temp25).functionCall(true, null, null);
      }
      else{
      temp24 = new TSObject();
      }
      if(temp25 instanceof TSObject && ((TSObject)temp25).hasPrototype() ){
        temp24.putPrototype(((TSObject)temp25).getPrototype());
      }
      TSValue temp26 = temp24.getValue();
      TSValue temp27 = temp22.simpleAssignment(temp26);
      Message.setLineNumber(16);
      Message.setLineNumber(16);
      TSValue temp28 = lexEnviron.getIdentifierReference(TSString.create("x"));
      TSPropertyReference temp29 =  new TSPropertyReference("f", temp28.getValue());
      TSValue temp30 = lexEnviron.getIdentifierReference(TSString.create("testThis"));
      TSValue temp31 = temp30.getValue();
      TSValue temp32 = temp29.simpleAssignment(temp31);
      Message.setLineNumber(17);
      Message.setLineNumber(17);
      Message.setLineNumber(17);
      TSValue temp33 = lexEnviron.getIdentifierReference(TSString.create("x"));
      TSPropertyReference temp34 =  new TSPropertyReference("f", temp33.getValue());
      TSFunctionObject temp35 = (TSFunctionObject)temp34.getValue();
      TSValue temp36 = temp34.getValue();
      TSObject temp37 = null;
      if(temp36 instanceof TSObject){
      temp37 = temp36;
      }
      else{
      }
      TSValue temp39 = temp35.functionCall(false, null,null);
      Message.setLineNumber(18);
      Message.setLineNumber(18);
      TSValue temp40 = lexEnviron.getIdentifierReference(TSString.create("x"));
      TSPropertyReference temp41 =  new TSPropertyReference("xyz", temp40.getValue());
      System.out.println(temp41.toStr().getInternal());
    }
    catch(TSException temp42){
    }
  }
}
