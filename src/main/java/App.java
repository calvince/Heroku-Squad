import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[]args){
        ProcessBuilder processBuilder = new ProcessBuilder();
        Integer port;
        if (processBuilder.environment().get("PORT") != null) {
            port= Integer.parseInt(processBuilder.environment().get("PORT"));
        }else {
            port =4567;
        }
        port(port);

        staticFileLocation("/public");
        get("/",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());
        //squad form
        get("/squad",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"squ-form.hbs");
        },new HandlebarsTemplateEngine());


        post("/squad/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>(); // I may be different from your code to account for generic “Objects”
            String name = req.queryParams("name");
            String cause = req.queryParams("cause");
            int maximum = Integer.parseInt(req.queryParams("maximum"));
            Squad squad = new Squad(name,cause,maximum);
            model.put("squad", squad);
            return new ModelAndView(model,"success-squad.hbs");
        },new HandlebarsTemplateEngine());

        get("/squad/list", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getAll();
            model.put("squads", squads);
            return new ModelAndView(model, "squ-details.hbs");
        }, new HandlebarsTemplateEngine());

        //adding hero baby
        get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        },new HandlebarsTemplateEngine());

        post("/hero/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String specialPowers = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name, age, specialPowers, weakness);
            return new ModelAndView(model, "success-h.hbs");
        }, new HandlebarsTemplateEngine());
        get("/heros/list",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heros = Hero.getAll();
            model.put("heros",heros);
            return new ModelAndView(model,"hero-details.hbs");
        },new HandlebarsTemplateEngine());
        get("/heros/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Hero.clearAllHero();
            return new ModelAndView(model, "success-h.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
