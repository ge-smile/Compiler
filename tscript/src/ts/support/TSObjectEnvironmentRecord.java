package ts.support;

public class TSObjectEnvironmentRecord extends TSEnvironmentRecord{
  private TSObject object;
  private boolean provideThis;
  
  TSObjectEnvironmentRecord(TSObject object, boolean provideThis){
    this.object = object;
    this.provideThis = provideThis;
  }
  
  boolean hasBinding(TSString name) {
    return object.hasProperty(name);
  }
  
  void createMutableBinding(TSString name, boolean isDeletable) {
    assert (object.hasProperty(name) == false): "binding already exists";
    object.putProperty(name.getInternal(), TSUndefined.value);
  }

  void setMutableBinding(TSString name, TSValue value) {
    assert (object.hasProperty(name) == true): "binding not exists"; 
    object.putProperty(name.getInternal(), value);
  }

  TSValue getBindingValue(TSString name) {
    // TODO Auto-generated method stub
    boolean value;
    value = object.hasProperty(name);
    assert (value==false): "missing binding";

    return object.getProperty(name.getInternal());
  }

  TSNumber deleteBinding(TSString name) {
    
    return null;
  }

  TSValue implicitThisValue() {
    if(provideThis == true){
      return object;
    }
    else{
      return TSUndefined.value;
    }
  }

}
