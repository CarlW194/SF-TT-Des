package builder;

final public class BuildMe {
  private String name;
  private int count;
  private BuildMe(){} // no general ability to build...

  // static inner class (aka nested class)
  // essentially stand alone, but has full access
  // to all elements (including private) of the
  // enclosing class
  public static class Builder {
    private Builder(){}
    private BuildMe self = new BuildMe();
    public Builder name(String name) {
      // validate??
      self.name = name;
      return this;
    }
    public Builder count(int count) {
      self.count = count;
      return this;
    }
    public BuildMe build() {
      // VALIDATE
      validate(self.name, self.count);
      BuildMe result = self;
      self = null; // Don't let a subsequent reuse damage the existing object
      return result;
    }
  }

  public static Builder builder() {
    return new Builder();
  }

  public static void validate(String name, int count) {
    if (name == null || name.isEmpty() || count < 1)
      throw new IllegalArgumentException("Bad values"); // be specific!
  }

  @Override
  public String toString() {
    return "BuildMe{" +
        "name='" + name + '\'' +
        ", count=" + count +
        '}';
  }
}
