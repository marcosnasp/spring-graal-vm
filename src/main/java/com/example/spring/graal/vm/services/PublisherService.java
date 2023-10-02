package com.example.spring.graal.vm.services;

import com.example.spring.graal.vm.dto.PublisherDTO;
import com.example.spring.graal.vm.dto.PublisherDTOMapper;
import com.example.spring.graal.vm.repository.PublisherRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherDTOMapper publisherDTOMapper;

    public PublisherService(PublisherRepository publisherRepository, PublisherDTOMapper publisherDTOMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherDTOMapper = publisherDTOMapper;
    }

    public Page<PublisherDTO> findAll(Pageable pageable) {
        return publisherRepository.findAll(pageable).map(publisherDTOMapper);
    }

    public Optional<PublisherDTO> findById(Integer id) {
        return publisherRepository.findById(id).map(publisherDTOMapper);
    }

}
