package com.teamtreehouse.giflib.data;

import com.teamtreehouse.giflib.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


// Indicates that an annotated class is a "component".
// Such classes are considered as candidates for auto-detection
// when using annotation-based configuration and classpath scanning.
@Component
public class GifRepository {

    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion",1, LocalDate.of(2015,2,13), "Chris Ramacciotti", false),
            new Gif("ben-and-mike",2, LocalDate.of(2015,10,30), "Ben Jakuben", true),
            new Gif("book-dominos",3, LocalDate.of(2015,9,15), "Craig Dennis", false),
            new Gif("compiler-bot",3, LocalDate.of(2015,2,13), "Ada Lovelace", true),
            new Gif("cowboy-coder",1, LocalDate.of(2015,2,13), "Grace Hopper", false),
            new Gif("infinite-andrew",2, LocalDate.of(2015,8,23), "Marissa Mayer", true)
    );


    public Gif findByName(String name){
        return ALL_GIFS.stream().parallel().filter( gif -> gif.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Gif> getAllGifs(){
        return ALL_GIFS;
    }

    public List<Gif> findByCategoryId(int id){
        return ALL_GIFS.stream().parallel().filter( gif -> gif.getCategoryId()==(id)).collect(Collectors.toList());
    }

    public List<Gif> findFavorites(){
        return ALL_GIFS.stream().parallel().filter( gif -> gif.isFavorite()).collect(Collectors.toList());
    }

    public List<Gif> searchGifs(String name){
        return ALL_GIFS.stream().parallel().filter( gif -> gif.getName().toUpperCase().contains(name.toUpperCase())).collect(Collectors.toList());
    }



}

