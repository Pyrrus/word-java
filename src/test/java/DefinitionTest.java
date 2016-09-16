import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class DefinitionTest {
  @Test
  public void Definition_instantiatesCorrectly() {
    Definition definition = new Definition("Bob", "work");
    assertEquals(true, definition instanceof Definition);
  }

  @Test
  public void getDefinition_instantiatesCorrectly() {
    Definition definition = new Definition("Bob", "work");
    assertEquals("Bob", definition.getDefintion());
  }

  @Test
  public void setDefinition_instantiatesCorrectly() {
    Definition definition = new Definition("Bob", "work");
    definition.setDefintion("Hello");
    assertEquals("Hello", definition.getDefintion());
  }

  @Test
  public void getType_instantiatesCorrectly() {
    Definition definition = new Definition("Bob", "work");
    assertEquals("work", definition.getType());
  }

  @Test
  public void setType_instantiatesCorrectly() {
    Definition definition = new Definition("Bob", "work");
    definition.setType("Hello");
    assertEquals("Hello", definition.getType());
  }
}