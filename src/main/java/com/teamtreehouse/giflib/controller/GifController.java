package com.teamtreehouse.giflib.controller;

import com.teamtreehouse.giflib.data.GifRepository;
import com.teamtreehouse.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by User on 2016.07.18..
 */

@Controller
public class GifController {
    /*
     Dispatcher servlet maps a URL to the appropriate controller, defined by @Controller annotation
     Dispatcher servlet is able to do this with the help of @RequestMapping annotation
    */

    // auto-assign giRepository a new instance as soon as needed
    // it can be done because of the annotation @Autowired here and @  on GifRepository
    // Spring can initialize field for us as long as it can find a spring component of the same calss as the field
    // it is an example of dependency injection. we use this annotation to inject the gif repository
    // into our controller
    @Autowired
    GifRepository gifRepository;

    // Annotation for mapping web requests onto specific handler classes and/or handler methods.
    @RequestMapping("/")
//    @ResponseBody // make the return string as response without future processing
    public String listGifs(ModelMap modelMap){
        // responds to localhost:8080/
        // looks in resources/templates/...
        List<Gif> allGifs=gifRepository.getAllGifs();
        modelMap.put("gifs",allGifs);
        return "home";
    }

    @RequestMapping("/gif")
    public String gifDetails(@RequestParam(value="name", defaultValue = "compiler-bot") String name, Model model){
        Gif gif = gifRepository.findByName(name);
        // Add the supplied attribute under the supplied name.
        model.addAttribute("gif", gif);
        return "gif-details";
    }

    // URL => http://localhost:8080/gif/android-explosion
    @RequestMapping("/gif/{name}")
    public String gifDetails2(@PathVariable String name, Model model){
        Gif gif = gifRepository.findByName(name);
        // Add the supplied attribute under the supplied name.
        model.addAttribute("gif", gif);
        return "gif-details";
    }

    @RequestMapping("/favorites")
    public String listFavorites(ModelMap modelMap){

        modelMap.put("gifs",gifRepository.findFavorites());

        return "favorites";
    }

    @RequestMapping("/search")
    public String listFound(@RequestParam(value="q") String name,ModelMap modelMap){

        modelMap.put("gifs",gifRepository.searchGifs(name));

        return "favorites";
    }


}
