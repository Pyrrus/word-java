import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class WordTest{
  @After
  public void tearDown() {
    Word.clear();
  }

  @Test
  public void Word_instantiatesCorrectly() {
    Word word = new Word("Bob");
    assertEquals(true, word instanceof Word);
  }

  @Test
  public void setId_instantiatesCorrectly() {
    Word Word = new Word("Bob");
    assertEquals(1, Word.getId());
  }

  @Test
  public void getWord_instantiatesCorrectly() {
    Word word = new Word("Bob");
    assertEquals("Bob", word.getWord());
  }

  @Test
  public void getDefinition_instantiatesCorrectly() {
    Word word = new Word("Bob");
    assertEquals(0, word.getDefinition().size());
  }

  @Test
  public void getDefinition_sizeIncreasesWhenDefinitionAdded() {
    Word word = new Word("Bob");
    Definition info = new Definition("person name");
    word.addDefinition(info);
    assertEquals(1, word.getDefinition().size());
  }

  @Test
  public void getId_returnsId () {
   Word word = new Word("Bob");
   assertEquals(1, word.getId());
  }

  @Test
  public void find_returnsCorrectWord () {
    Word word = new Word("Bob");
    Word otherword = new Word("Q");
    assertEquals(Word.find(otherword.getId()), otherword);
  }

  @Test
  public void All_returnsAll () {
    Word word = new Word("Bob");
    Word otherword = new Word("Q");
    assertTrue(Word.all().contains(word));
    assertTrue(Word.all().contains(otherword));
  }

  @Test
  public void clear_clearsList () {
    Word word = new Word("Bob");
    Word.clear();
    assertEquals(0, Word.all().size());
  }

}