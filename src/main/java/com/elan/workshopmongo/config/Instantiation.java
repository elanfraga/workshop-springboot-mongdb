package com.elan.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.elan.workshopmongo.dto.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.elan.workshopmongo.domain.Post;
import com.elan.workshopmongo.domain.User;
import com.elan.workshopmongo.repository.PostRepository;
import com.elan.workshopmongo.repository.UserRepository;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userReposiroty;

    @Autowired
    private PostRepository postReposiroty;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userReposiroty.deleteAll();
        postReposiroty.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userReposiroty.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        postReposiroty.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userReposiroty.save(maria);
    }
}
