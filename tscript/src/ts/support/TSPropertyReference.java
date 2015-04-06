package ts.support;

public class TSPropertyReference extends TSReference {
  private String id;
  private TSValue base;

  public TSPropertyReference(String name, TSValue base) {
    super(TSString.create(name));
    id = name;
    this.base = base;
  }

  public TSValue getValue(){
    if (isPropertyReference()) {

      TSObject baseObject = (TSObject) base;
      if (id.equals("prototype")) {
        return baseObject.getPrototype();
      } else {
        return baseObject.getProperty(id);
      }
    }
    else{
      throw new TSException("Undefined identifier " + id);
    }
  }

  public void putValue(TSValue value) {
    if(isPropertyReference()){
      TSObject baseObject = (TSObject) base;
      if (id.equals("prototype")) {
        baseObject.putPrototype(value);
      } else {
        baseObject.putProperty(id, value);
      }
    }
    else{

      TSGlobalObject.globalObject.putProperty(id, value);
    }
  }

  public boolean isPropertyReference() {
    return base instanceof TSObject;
  }

  public boolean isUnresolvableReference() {
    return base.isUndefined() || !isPropertyReference();
  }

}
