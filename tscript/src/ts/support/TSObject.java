package ts.support;

import java.util.HashMap;
import java.util.Map;

public class TSObject extends TSValue{
  private Map<String, TSValue> properties;
  private TSValue prototype = null;
  
  public TSObject(TSValue prototype){
    properties = new HashMap<String, TSValue>();
    this.prototype = prototype;
  }
  
  public TSObject(){
    properties = new HashMap<String, TSValue>();
  }
  
  public void putProperty(String id, TSValue value){
    properties.put(id, value);
  }
  
  public TSValue getProperty(String id){
    if(properties.containsKey(id)){
      return properties.get(id);
    }
    else{
      if(prototype == null){
        return TSUndefined.value;
      }
      else{
        return ((TSObject)prototype).getProperty(id);
      }
    }
  }
  
  public boolean hasProperty(TSString property){
    return properties.containsKey(property.getInternal());
  }
  
  public boolean hasPrototype(){
    return prototype != null;
  }
  
  public void putPrototype(TSValue prototype){
    this.prototype = prototype;
  }
  
  public TSValue getPrototype(){
    return prototype;
  }
  
  public TSNumber toNumber() {
    // TODO Auto-generated method stub
    return null;
  }

  public TSBoolean toBoolean() {
    // TODO Auto-generated method stub
    return null;
  }
  
  public TSValue defaultValue(int hint){
    if(hint == 0){
      TSValue toString = this.getProperty("toString");
      if(toString.isCallable()){
        TSValue str = ((TSFunctionObject)toString).functionCall(false, this, null);
        if(str instanceof TSPrimitive)
        {
          return str;
        }
      }
      
      TSValue valueOf = this.getProperty("valueOf");
      if(valueOf.isCallable())
      {
        TSValue val = ((TSFunctionObject)valueOf).functionCall(false, this, null).getValue();
        if(val instanceof TSPrimitive)
        {
          return val;
        }
      }
    }
    else if(hint == 1){
      TSValue valueOf = this.getProperty("valueOf");
      
      if(valueOf.isCallable())
      {
        TSValue val = ((TSFunctionObject)valueOf).functionCall(false, this, null).getValue();
        if(val instanceof TSPrimitive)
        {
          return val;
        }
      }
      
      TSValue toString = this.getProperty("toString");
      if(toString.isCallable())
      {
        TSValue str = ((TSFunctionObject)toString).functionCall(false, this, null).getValue();
        if(str instanceof TSPrimitive)
        {
          return str;
        }
      }

    }
    else{
      throw new TSException("Type error in defaultValue");
    }
    return null;
  }
  
  public TSPrimitive toPrimitive() {
    return this.defaultValue(1).toPrimitive();
  }
  
}
