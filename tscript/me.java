import ts.Message;
import ts.support.*;
class me {
  public static void main(String args[])
  {
    try{
      TSLexicalEnvironment lexEnviron = TSLexicalEnvironment.newDeclarativeEnvironment(null);
      lexEnviron.declareVariable(TSString.create("undefined"),false);
      Message.setLineNumber(2);
      lexEnviron.declareVariable(TSString.create("tab"), false);
      TSEnvironmentReference temp0 = (TSEnvironmentReference)lexEnviron.getIdentifierReference(TSString.create("tab"));
      if(temp0.isUnresolvableReference())
      {
      throw new TSException(TSString.create("ReferenceError: tab is not defined"));
      }
      TSValue temp1 = TSString.create("    ");
      TSValue temp2 = temp1.getValue();
      TSValue temp3 = temp0.simpleAssignment(temp2);
      lexEnviron.declareVariable(TSString.create("ind"), false);
      TSEnvironmentReference temp4 = (TSEnvironmentReference)lexEnviron.getIdentifierReference(TSString.create("ind"));
      if(temp4.isUnresolvableReference())
      {
      throw new TSException(TSString.create("ReferenceError: ind is not defined"));
      }
      TSEnvironmentReference temp5 = (TSEnvironmentReference)lexEnviron.getIdentifierReference(TSString.create("tab"));
      if(temp5.isUnresolvableReference())
      {
      throw new TSException(TSString.create("ReferenceError: tab is not defined"));
      }
      TSValue temp6 = temp5.getValue();
      TSValue temp7 = temp4.simpleAssignment(temp6);
      try
      {
      Message.setLineNumber(3);
        Message.setLineNumber(3);
        Message.setLineNumber(4);
        TSValue temp8 = TSString.create("try block 0");
        System.out.println(temp8.toStr().getInternal());
        Message.setLineNumber(5);
        TSValue temp9 = TSNumber.create(0.0);
        throw new TSException(temp9);
      }
      catch( TSException temp10){
        Message.setLineNumber(7);
        TSLexicalEnvironment lexicalEnvironment0 = TSLexicalEnvironment.newDeclarativeEnvironment(lexEnviron);
        lexicalEnvironment0.declareParameter("nest0", temp10.getValue());
        Message.setLineNumber(7);
        try
        {
        Message.setLineNumber(8);
          Message.setLineNumber(8);
          Message.setLineNumber(9);
          TSEnvironmentReference temp11 = (TSEnvironmentReference)lexicalEnvironment0.getIdentifierReference(TSString.create("ind"));
          if(temp11.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: ind is not defined"));
          }
          TSValue temp12 = temp11.getValue();
          TSValue temp13 = TSString.create("try block 1");
          TSValue temp14 = temp13.getValue();
          TSValue temp15 = temp12.add(temp14);
          System.out.println(temp15.toStr().getInternal());
          Message.setLineNumber(10);
          lexEnviron.declareVariable(TSString.create("num"), false);
          TSEnvironmentReference temp16 = (TSEnvironmentReference)lexicalEnvironment0.getIdentifierReference(TSString.create("num"));
          if(temp16.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: num is not defined"));
          }
          TSValue temp17 = TSNumber.create(10.0);
          TSValue temp18 = temp17.getValue();
          TSValue temp19 = temp16.simpleAssignment(temp18);
          Message.setLineNumber(11);
          TSEnvironmentReference temp20 = (TSEnvironmentReference)lexicalEnvironment0.getIdentifierReference(TSString.create("nest0"));
          if(temp20.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: nest0 is not defined"));
          }
          TSValue temp21 = temp20.getValue();
          TSValue temp22 = TSNumber.create(1.0);
          TSValue temp23 = temp22.getValue();
          TSValue temp24 = temp21.add(temp23);
          throw new TSException(temp24);
        }
        catch( TSException temp25){
          Message.setLineNumber(12);
          TSLexicalEnvironment lexicalEnvironment1 = TSLexicalEnvironment.newDeclarativeEnvironment(lexicalEnvironment0);
          lexicalEnvironment1.declareParameter("nest1", temp25.getValue());
          Message.setLineNumber(12);
          Message.setLineNumber(13);
          TSEnvironmentReference temp26 = (TSEnvironmentReference)lexicalEnvironment1.getIdentifierReference(TSString.create("ind"));
          if(temp26.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: ind is not defined"));
          }
          TSEnvironmentReference temp27 = (TSEnvironmentReference)lexicalEnvironment1.getIdentifierReference(TSString.create("tab"));
          if(temp27.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: tab is not defined"));
          }
          TSValue temp28 = temp27.getValue();
          TSEnvironmentReference temp29 = (TSEnvironmentReference)lexicalEnvironment1.getIdentifierReference(TSString.create("tab"));
          if(temp29.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: tab is not defined"));
          }
          TSValue temp30 = temp29.getValue();
          TSValue temp31 = temp28.add(temp30);
          TSValue temp32 = temp31.getValue();
          TSValue temp33 = temp26.simpleAssignment(temp32);
          Message.setLineNumber(14);
          TSEnvironmentReference temp34 = (TSEnvironmentReference)lexicalEnvironment1.getIdentifierReference(TSString.create("ind"));
          if(temp34.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: ind is not defined"));
          }
          TSValue temp35 = temp34.getValue();
          TSValue temp36 = TSString.create("previous catch: ");
          TSValue temp37 = temp36.getValue();
          TSValue temp38 = temp35.add(temp37);
          TSValue temp39 = temp38.getValue();
          TSEnvironmentReference temp40 = (TSEnvironmentReference)lexicalEnvironment1.getIdentifierReference(TSString.create("nest0"));
          if(temp40.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: nest0 is not defined"));
          }
          TSValue temp41 = temp40.getValue();
          TSValue temp42 = temp39.add(temp41);
          System.out.println(temp42.toStr().getInternal());
          Message.setLineNumber(15);
          TSEnvironmentReference temp43 = (TSEnvironmentReference)lexicalEnvironment1.getIdentifierReference(TSString.create("ind"));
          if(temp43.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: ind is not defined"));
          }
          TSValue temp44 = temp43.getValue();
          TSValue temp45 = TSString.create("this catch: ");
          TSValue temp46 = temp45.getValue();
          TSValue temp47 = temp44.add(temp46);
          TSValue temp48 = temp47.getValue();
          TSEnvironmentReference temp49 = (TSEnvironmentReference)lexicalEnvironment1.getIdentifierReference(TSString.create("nest1"));
          if(temp49.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: nest1 is not defined"));
          }
          TSValue temp50 = temp49.getValue();
          TSValue temp51 = temp48.add(temp50);
          System.out.println(temp51.toStr().getInternal());
          try
          {
          Message.setLineNumber(16);
            Message.setLineNumber(16);
            Message.setLineNumber(17);
            TSEnvironmentReference temp52 = (TSEnvironmentReference)lexicalEnvironment1.getIdentifierReference(TSString.create("ind"));
            if(temp52.isUnresolvableReference())
            {
            throw new TSException(TSString.create("ReferenceError: ind is not defined"));
            }
            TSEnvironmentReference temp53 = (TSEnvironmentReference)lexicalEnvironment1.getIdentifierReference(TSString.create("ind"));
            if(temp53.isUnresolvableReference())
            {
            throw new TSException(TSString.create("ReferenceError: ind is not defined"));
            }
            TSValue temp54 = temp53.getValue();
            TSEnvironmentReference temp55 = (TSEnvironmentReference)lexicalEnvironment1.getIdentifierReference(TSString.create("tab"));
            if(temp55.isUnresolvableReference())
            {
            throw new TSException(TSString.create("ReferenceError: tab is not defined"));
            }
            TSValue temp56 = temp55.getValue();
            TSValue temp57 = temp54.add(temp56);
            TSValue temp58 = temp57.getValue();
            TSValue temp59 = temp52.simpleAssignment(temp58);
            Message.setLineNumber(18);
            TSEnvironmentReference temp60 = (TSEnvironmentReference)lexicalEnvironment1.getIdentifierReference(TSString.create("ind"));
            if(temp60.isUnresolvableReference())
            {
            throw new TSException(TSString.create("ReferenceError: ind is not defined"));
            }
            TSValue temp61 = temp60.getValue();
            TSValue temp62 = TSString.create("try block 2");
            TSValue temp63 = temp62.getValue();
            TSValue temp64 = temp61.add(temp63);
            System.out.println(temp64.toStr().getInternal());
            Message.setLineNumber(19);
            TSEnvironmentReference temp65 = (TSEnvironmentReference)lexicalEnvironment1.getIdentifierReference(TSString.create("nest1"));
            if(temp65.isUnresolvableReference())
            {
            throw new TSException(TSString.create("ReferenceError: nest1 is not defined"));
            }
            TSValue temp66 = temp65.getValue();
            TSValue temp67 = TSNumber.create(1.0);
            TSValue temp68 = temp67.getValue();
            TSValue temp69 = temp66.add(temp68);
            throw new TSException(temp69);
          }
          catch( TSException temp70){
            Message.setLineNumber(20);
            TSLexicalEnvironment lexicalEnvironment2 = TSLexicalEnvironment.newDeclarativeEnvironment(lexicalEnvironment1);
            lexicalEnvironment2.declareParameter("nest2", temp70.getValue());
            Message.setLineNumber(20);
            Message.setLineNumber(21);
            lexEnviron.declareVariable(TSString.create("something"), false);
            TSEnvironmentReference temp71 = (TSEnvironmentReference)lexicalEnvironment2.getIdentifierReference(TSString.create("something"));
            if(temp71.isUnresolvableReference())
            {
            throw new TSException(TSString.create("ReferenceError: something is not defined"));
            }
            TSValue temp72 = TSString.create("idk");
            TSValue temp73 = temp72.getValue();
            TSValue temp74 = temp71.simpleAssignment(temp73);
            Message.setLineNumber(22);
            TSEnvironmentReference temp75 = (TSEnvironmentReference)lexicalEnvironment2.getIdentifierReference(TSString.create("ind"));
            if(temp75.isUnresolvableReference())
            {
            throw new TSException(TSString.create("ReferenceError: ind is not defined"));
            }
            TSValue temp76 = temp75.getValue();
            TSValue temp77 = TSString.create("previous catch: ");
            TSValue temp78 = temp77.getValue();
            TSValue temp79 = temp76.add(temp78);
            TSValue temp80 = temp79.getValue();
            TSEnvironmentReference temp81 = (TSEnvironmentReference)lexicalEnvironment2.getIdentifierReference(TSString.create("nest1"));
            if(temp81.isUnresolvableReference())
            {
            throw new TSException(TSString.create("ReferenceError: nest1 is not defined"));
            }
            TSValue temp82 = temp81.getValue();
            TSValue temp83 = temp80.add(temp82);
            System.out.println(temp83.toStr().getInternal());
            Message.setLineNumber(23);
            TSEnvironmentReference temp84 = (TSEnvironmentReference)lexicalEnvironment2.getIdentifierReference(TSString.create("ind"));
            if(temp84.isUnresolvableReference())
            {
            throw new TSException(TSString.create("ReferenceError: ind is not defined"));
            }
            TSValue temp85 = temp84.getValue();
            TSValue temp86 = TSString.create("this catch: ");
            TSValue temp87 = temp86.getValue();
            TSValue temp88 = temp85.add(temp87);
            TSValue temp89 = temp88.getValue();
            TSEnvironmentReference temp90 = (TSEnvironmentReference)lexicalEnvironment2.getIdentifierReference(TSString.create("nest2"));
            if(temp90.isUnresolvableReference())
            {
            throw new TSException(TSString.create("ReferenceError: nest2 is not defined"));
            }
            TSValue temp91 = temp90.getValue();
            TSValue temp92 = temp89.add(temp91);
            System.out.println(temp92.toStr().getInternal());
          }
          Message.setLineNumber(25);
          TSEnvironmentReference temp93 = (TSEnvironmentReference)lexicalEnvironment1.getIdentifierReference(TSString.create("ind"));
          if(temp93.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: ind is not defined"));
          }
          TSEnvironmentReference temp94 = (TSEnvironmentReference)lexicalEnvironment1.getIdentifierReference(TSString.create("tab"));
          if(temp94.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: tab is not defined"));
          }
          TSValue temp95 = temp94.getValue();
          TSEnvironmentReference temp96 = (TSEnvironmentReference)lexicalEnvironment1.getIdentifierReference(TSString.create("tab"));
          if(temp96.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: tab is not defined"));
          }
          TSValue temp97 = temp96.getValue();
          TSValue temp98 = temp95.add(temp97);
          TSValue temp99 = temp98.getValue();
          TSValue temp100 = temp93.simpleAssignment(temp99);
          try
          {
          Message.setLineNumber(26);
            Message.setLineNumber(26);
            Message.setLineNumber(27);
            TSEnvironmentReference temp101 = (TSEnvironmentReference)lexicalEnvironment1.getIdentifierReference(TSString.create("nest2"));
            if(temp101.isUnresolvableReference())
            {
            throw new TSException(TSString.create("ReferenceError: nest2 is not defined"));
            }
            System.out.println(temp101.toStr().getInternal());
          }
          catch( TSException temp102){
            Message.setLineNumber(28);
            TSLexicalEnvironment lexicalEnvironment3 = TSLexicalEnvironment.newDeclarativeEnvironment(lexicalEnvironment1);
            lexicalEnvironment3.declareParameter("err", temp102.getValue());
            Message.setLineNumber(28);
            Message.setLineNumber(29);
            TSEnvironmentReference temp103 = (TSEnvironmentReference)lexicalEnvironment3.getIdentifierReference(TSString.create("ind"));
            if(temp103.isUnresolvableReference())
            {
            throw new TSException(TSString.create("ReferenceError: ind is not defined"));
            }
            TSValue temp104 = temp103.getValue();
            TSValue temp105 = TSString.create("err: ");
            TSValue temp106 = temp105.getValue();
            TSValue temp107 = temp104.add(temp106);
            TSValue temp108 = temp107.getValue();
            TSEnvironmentReference temp109 = (TSEnvironmentReference)lexicalEnvironment3.getIdentifierReference(TSString.create("err"));
            if(temp109.isUnresolvableReference())
            {
            throw new TSException(TSString.create("ReferenceError: err is not defined"));
            }
            TSValue temp110 = temp109.getValue();
            TSValue temp111 = temp108.add(temp110);
            System.out.println(temp111.toStr().getInternal());
            Message.setLineNumber(30);
            TSEnvironmentReference temp112 = (TSEnvironmentReference)lexicalEnvironment3.getIdentifierReference(TSString.create("ind"));
            if(temp112.isUnresolvableReference())
            {
            throw new TSException(TSString.create("ReferenceError: ind is not defined"));
            }
            TSValue temp113 = temp112.getValue();
            TSValue temp114 = TSString.create("nest2 is now out of scope");
            TSValue temp115 = temp114.getValue();
            TSValue temp116 = temp113.add(temp115);
            System.out.println(temp116.toStr().getInternal());
          }
        }
        Message.setLineNumber(33);
        TSEnvironmentReference temp117 = (TSEnvironmentReference)lexicalEnvironment0.getIdentifierReference(TSString.create("ind"));
        if(temp117.isUnresolvableReference())
        {
        throw new TSException(TSString.create("ReferenceError: ind is not defined"));
        }
        TSEnvironmentReference temp118 = (TSEnvironmentReference)lexicalEnvironment0.getIdentifierReference(TSString.create("tab"));
        if(temp118.isUnresolvableReference())
        {
        throw new TSException(TSString.create("ReferenceError: tab is not defined"));
        }
        TSValue temp119 = temp118.getValue();
        TSValue temp120 = temp117.simpleAssignment(temp119);
        try
        {
        Message.setLineNumber(34);
          Message.setLineNumber(34);
          Message.setLineNumber(35);
          TSEnvironmentReference temp121 = (TSEnvironmentReference)lexicalEnvironment0.getIdentifierReference(TSString.create("nest1"));
          if(temp121.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: nest1 is not defined"));
          }
          System.out.println(temp121.toStr().getInternal());
        }
        catch( TSException temp122){
          Message.setLineNumber(36);
          TSLexicalEnvironment lexicalEnvironment4 = TSLexicalEnvironment.newDeclarativeEnvironment(lexicalEnvironment0);
          lexicalEnvironment4.declareParameter("err", temp122.getValue());
          Message.setLineNumber(36);
          Message.setLineNumber(37);
          TSEnvironmentReference temp123 = (TSEnvironmentReference)lexicalEnvironment4.getIdentifierReference(TSString.create("ind"));
          if(temp123.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: ind is not defined"));
          }
          TSValue temp124 = temp123.getValue();
          TSValue temp125 = TSString.create("err: ");
          TSValue temp126 = temp125.getValue();
          TSValue temp127 = temp124.add(temp126);
          TSValue temp128 = temp127.getValue();
          TSEnvironmentReference temp129 = (TSEnvironmentReference)lexicalEnvironment4.getIdentifierReference(TSString.create("err"));
          if(temp129.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: err is not defined"));
          }
          TSValue temp130 = temp129.getValue();
          TSValue temp131 = temp128.add(temp130);
          System.out.println(temp131.toStr().getInternal());
          Message.setLineNumber(38);
          TSEnvironmentReference temp132 = (TSEnvironmentReference)lexicalEnvironment4.getIdentifierReference(TSString.create("ind"));
          if(temp132.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: ind is not defined"));
          }
          TSValue temp133 = temp132.getValue();
          TSValue temp134 = TSString.create("nest1 is now out of scope");
          TSValue temp135 = temp134.getValue();
          TSValue temp136 = temp133.add(temp135);
          System.out.println(temp136.toStr().getInternal());
        }
      }
      finally{
       Message.setLineNumber(41);
        Message.setLineNumber(41);
        try
        {
        Message.setLineNumber(42);
          Message.setLineNumber(42);
          Message.setLineNumber(43);
          TSEnvironmentReference temp137 = (TSEnvironmentReference)lexEnviron.getIdentifierReference(TSString.create("nest0"));
          if(temp137.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: nest0 is not defined"));
          }
          System.out.println(temp137.toStr().getInternal());
        }
        catch( TSException temp138){
          Message.setLineNumber(44);
          TSLexicalEnvironment lexicalEnvironment5 = TSLexicalEnvironment.newDeclarativeEnvironment(lexEnviron);
          lexicalEnvironment5.declareParameter("err", temp138.getValue());
          Message.setLineNumber(44);
          Message.setLineNumber(45);
          TSValue temp139 = TSString.create("err: ");
          TSValue temp140 = temp139.getValue();
          TSEnvironmentReference temp141 = (TSEnvironmentReference)lexicalEnvironment5.getIdentifierReference(TSString.create("err"));
          if(temp141.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: err is not defined"));
          }
          TSValue temp142 = temp141.getValue();
          TSValue temp143 = temp140.add(temp142);
          System.out.println(temp143.toStr().getInternal());
          Message.setLineNumber(46);
          TSValue temp144 = TSString.create("nest0 is now out of scope");
          System.out.println(temp144.toStr().getInternal());
        }
        try
        {
        Message.setLineNumber(48);
          Message.setLineNumber(48);
          Message.setLineNumber(49);
          TSValue temp145 = TSString.create("num: ");
          TSValue temp146 = temp145.getValue();
          TSEnvironmentReference temp147 = (TSEnvironmentReference)lexEnviron.getIdentifierReference(TSString.create("num"));
          if(temp147.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: num is not defined"));
          }
          TSValue temp148 = temp147.getValue();
          TSValue temp149 = temp146.add(temp148);
          System.out.println(temp149.toStr().getInternal());
          Message.setLineNumber(50);
          TSValue temp150 = TSString.create("something: ");
          TSValue temp151 = temp150.getValue();
          TSEnvironmentReference temp152 = (TSEnvironmentReference)lexEnviron.getIdentifierReference(TSString.create("something"));
          if(temp152.isUnresolvableReference())
          {
          throw new TSException(TSString.create("ReferenceError: something is not defined"));
          }
          TSValue temp153 = temp152.getValue();
          TSValue temp154 = temp151.add(temp153);
          System.out.println(temp154.toStr().getInternal());
        }
        catch( TSException temp155){
          Message.setLineNumber(51);
          TSLexicalEnvironment lexicalEnvironment6 = TSLexicalEnvironment.newDeclarativeEnvironment(lexEnviron);
          lexicalEnvironment6.declareParameter("err", temp155.getValue());
          Message.setLineNumber(51);
          Message.setLineNumber(52);
          TSValue temp156 = TSString.create("something went wrong!!!");
          System.out.println(temp156.toStr().getInternal());
        }
      }
       Message.setLineNumber(56);
      TSValue temp157 = TSString.create("test complete  <---------------------------------------");
      System.out.println(temp157.toStr().getInternal());
    }
    catch(TSException temp158){
    }
  }
}
