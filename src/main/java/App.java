import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Arrays;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    String header = "templates/header.vtl";

    get("/", (request, response) -> {
      Map <String, Object> model = new HashMap <String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("title", "Wordzilla");
      model.put("header", header);
      model.put("css", "");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/word", (request, response) -> {
      Map <String, Object> model = new HashMap <String, Object>();
      model.put("template", "templates/words.vtl");
      model.put("title", "Wordzilla: Word List");
      model.put("words", Word.all());
      model.put("header", header);
      model.put("css", "..");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/word", (request, response) -> {
      Map <String, Object> model = new HashMap <String, Object>();
      model.put("template", "templates/words.vtl");
      model.put("title", "Wordzilla: Word List");
      model.put("words", Word.all());
      String name = request.queryParams("name");
      Word word = new Word(name);
      model.put("post", "yes");
      model.put("header", header);
      model.put("css", "..");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/word/new", (request, response) -> {
      Map <String, Object> model = new HashMap <String, Object>();
      model.put("template", "templates/word-new-form.vtl");
      model.put("title", "Add new word for Wordzilla");
      model.put("header", header);
      model.put("css", "..");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/word/:id", (request, response) -> {
      Map <String, Object> model = new HashMap <String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("template", "templates/word-info.vtl");
      model.put("title", "Wordzilla: " + word.getWord() + " meaning");
      model.put("word", word);
      model.put("css", "..");
      model.put("header", header);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/word/:id/new", (request, response) -> {
      Map <String, Object> model = new HashMap <String, Object> ();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("template", "templates/word-info-new.vtl");
      model.put("title", "Wordzilla: " + word.getWord() + " add meaning");
      model.put("word", word);
      model.put("css", "../..");
      model.put("header", header);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/word/:id", (request, response) -> {
      Map <String, Object> model = new HashMap <String,Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      String meaning = request.queryParams("info");
      String type = request.queryParams("type");
      System.out.println(meaning);
      Definition info = new Definition(meaning, type);
      word.addDefinition(info);
      model.put("post", "yes");
      model.put("template", "templates/word-info.vtl");
      model.put("title", "Wordzilla: " + word.getWord() + " meaning");
      model.put("word", word);
      model.put("css", "..");
      model.put("header", header);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}