package com.fincas.app.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.fincas.app.controller.api.exeptions.notFoundException;
import com.fincas.app.controller.api.exeptions.unaceptableException;
import com.fincas.app.crud.category.categoryEntity;
import com.fincas.app.services.categoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*")
public class categoryApi {
    @Autowired
    private categoryService catService;

    @GetMapping("/{id}")
    public categoryEntity getFarm(@PathVariable long id){
        Optional<categoryEntity> exist = catService.getCategoryByID(id);
        if(exist.isEmpty()){
            throw new notFoundException("Category with id: " + id+ " not exist");
        }
        return exist.get();
    }
    @GetMapping
    public List<categoryEntity> getEveryCats() {
        return catService.getAllCategories();
    }
    @PostMapping
    public void addCategory(@RequestBody categoryEntity body){
        categoryEntity exist = catService.saveCategory(body);
        if(exist == null){
            throw new unaceptableException("There is already a category with the id: " + body.getId());
        }
    }
    @PutMapping
    public void updaate(@RequestBody categoryEntity body){
        categoryEntity exsist = catService.update(body);
        if(exsist == null){
            throw new notFoundException("Category with id: " + body.getId() + " not exist");
        }
    }
    @DeleteMapping
    public void delete(@RequestBody categoryEntity body){
        boolean isDeleted = catService.delete(body.getId());

        if(!isDeleted){
            throw new notFoundException("Farm with id: " + body.getId() + " not exist");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWhitId(@PathVariable long id){
        boolean isDeleted = catService.delete(id);

        if(!isDeleted){
            throw new notFoundException("Farm with id: " + id + " not exist");
        }
    }

    // MinTic Request

    @GetMapping(value = "/all")
    public List<categoryEntity> getEveryCatsInAll() {
        return catService.getAllCategories();
    }

    @PostMapping(value = "/all")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCategoryInAll(@RequestBody categoryEntity body){
        categoryEntity exist = catService.saveCategory(body);
        if(exist == null){
            throw new unaceptableException("There is already a category with the id: " + body.getId());
        }
    }

    @PutMapping(value = "/all")
    @ResponseStatus(HttpStatus.CREATED)
    public void updaateInAll(@RequestBody categoryEntity body){
        categoryEntity exsist = catService.update(body);
        if(exsist == null){
            throw new notFoundException("Category with id: " + body.getId() + " not exist");
        }
    }

    @GetMapping(value = "/update")
    public List<categoryEntity> getEveryCatsInUpdate() {
        return catService.getAllCategories();
    }

    @PostMapping(value = "/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCategoryInUpdate(@RequestBody categoryEntity body){
        categoryEntity exist = catService.saveCategory(body);
        if(exist == null){
            throw new unaceptableException("There is already a category with the id: " + body.getId());
        }
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updaateInUpdate(@RequestBody categoryEntity body){
        categoryEntity exsist = catService.update(body);
        if(exsist == null){
            throw new notFoundException("Category with id: " + body.getId() + " not exist");
        }
    }

    @GetMapping(value = "/save")
    public List<categoryEntity> getEveryCatsInSave() {
        return catService.getAllCategories();
    }

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCategoryISave(@RequestBody categoryEntity body){
        categoryEntity exist = catService.saveCategory(body);
        if(exist == null){
            throw new unaceptableException("There is already a category with the id: " + body.getId());
        }
    }

    @PutMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void updaateInSave(@RequestBody categoryEntity body){
        categoryEntity exsist = catService.update(body);
        if(exsist == null){
            throw new notFoundException("Category with id: " + body.getId() + " not exist");
        }
    }
}
