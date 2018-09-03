package com.elan.workshopmongo.resources;

import com.elan.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserRecource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User alex = new User("1", "Maria Brown", "maria@gmail.com");

        List list = new ArrayList();
        list.addAll(Arrays.asList(maria, alex));

        return ResponseEntity.ok().body(list);
    }


}
