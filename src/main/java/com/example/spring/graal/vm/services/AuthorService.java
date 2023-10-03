package com.example.spring.graal.vm.services;

import com.example.spring.graal.vm.dto.AuthorDTO;
import com.example.spring.graal.vm.dto.AuthorDTOMapper;
import com.example.spring.graal.vm.repository.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorDTOMapper authorDTOMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorDTOMapper authorDTOMapper) {
        this.authorRepository = authorRepository;
        this.authorDTOMapper = authorDTOMapper;
    }

    public Page<AuthorDTO> findAll(Pageable pageable) {
        return authorRepository.findAll(pageable).map(authorDTOMapper);
    }

    public Optional<AuthorDTO> findById(Integer id) {
        return authorRepository.findById(id).map(authorDTOMapper);
    }

}
