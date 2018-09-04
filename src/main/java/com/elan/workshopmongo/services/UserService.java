package com.elan.workshopmongo.services;

import com.elan.workshopmongo.domain.User;
import com.elan.workshopmongo.dto.UserDTO;
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

    public User insert(User obj){
        return repo.insert(obj);
    }

    public void delete (String id){
        findByID(id);
        repo.deleteById(id);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
