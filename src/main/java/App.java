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
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("title", "Wordzilla");
      model.put("header", header);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/word", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/words.vtl");
      model.put("title", "Wordzilla list");
      model.put("words", Word.all());
      model.put("header", header);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/word", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/words.vtl");
      model.put("title", "Wordzilla list");
      model.put("words", Word.all());
      String name = request.queryParams("name");
      Word word = new Word(name);
      model.put("post", "yes");
      model.put("header", header);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
    get("/word/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("title", "Wordzilla");
      model.put("header", header);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/word/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("title", "Wordzilla");
      model.put("header", header);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/word/:id/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("title", "Wordzilla");
      model.put("header", header);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
