package com.teamtreehouse.giflib.data;
import com.teamtreehouse.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by UberV on 20.07.2016.
 */
@Component
public class CategoryRepository {

    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
        new Category(1,"Technology"),
        new Category(2,"People"),
        new Category(3,"Destruction")
    );

    /*
    DAO играет роль посредника между сервисом и базой данных (репозиторий круд)
    в основном перенаправляет реквесты
     */

    public Category findById(int id){
        return ALL_CATEGORIES.stream().parallel().filter( cat -> cat.getId() == id).findFirst().orElse(null);
    }

    public List<Category> getAllCategories(){
        return ALL_CATEGORIES;
    }

}
