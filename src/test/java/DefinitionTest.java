import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class DefinitionTest{
  @Test
  public void Definition_instantiatesCorrectly() {
    Definition definition = new Definition("Bob");
    assertEquals(true, definition instanceof Definition);
  }

  @Test
  public void getDefinition_instantiatesCorrectly() {
    Definition definition = new Definition("Bob");
    assertEquals("Bob", definition.getDefintion());
  }

  @Test
  public void setDefinition_instantiatesCorrectly() {
    Definition definition = new Definition("Bob");
    definition.setDefintion("Hello");
    assertEquals("Hello", definition.getDefintion());
  }
}