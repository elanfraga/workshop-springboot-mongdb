package com.elan.workshopmongo.services;

import com.elan.workshopmongo.domain.User;
import com.elan.workshopmongo.repository.UserRepository;
import com.elan.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return  repo.findAll();
    }

    public User findByID(String id){
        Optional<User> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
    }
}
