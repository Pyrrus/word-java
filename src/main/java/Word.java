import java.util.ArrayList;
import java.util.List;

public class Word {
  private String mWord;
  private List <Definition> mDefinition;
  private int mId;
  private static List <Word> words = new ArrayList <Word>();

  public Word(String word) {
    mWord = word;
    mDefinition = new ArrayList <Definition>();
    words.add(this);
    mId = words.size();
  }

  public int getId() {
    return mId;
  }

  public String getWord() {
    return mWord;
  }

  public List <Definition> getDefinition() {
    return mDefinition;
  }

  public void addDefinition(Definition info) {
    mDefinition.add(info);
  }

  public static List <Word> all() {
    return words;
  }

  public static void clear() {
    words.clear();
  }

  public static Word find(int id) {
    try {
      return words.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }
}