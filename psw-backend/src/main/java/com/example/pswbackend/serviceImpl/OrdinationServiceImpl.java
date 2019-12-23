package com.example.pswbackend.serviceImpl;

import com.example.pswbackend.domain.Ordination;
import com.example.pswbackend.repositories.OrdinationRepository;
import com.example.pswbackend.services.OrdinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdinationServiceImpl implements OrdinationService {

    @Autowired
    private OrdinationRepository ordinationRepo;

    @Override
    public Ordination findById(long id) {
        return ordinationRepo.findById(id).get();
    }

    @Override
    public List<Ordination> findAll() {
        return ordinationRepo.findAll();
    }
}