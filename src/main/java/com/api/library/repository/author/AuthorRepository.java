package com.api.library.repository.author;

import com.api.library.entity.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
