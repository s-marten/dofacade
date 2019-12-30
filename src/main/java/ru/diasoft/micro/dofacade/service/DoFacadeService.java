package ru.diasoft.micro.dofacade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diasoft.micro.dofacade.repository.IProductRepository;

@Service
public class DoFacadeService implements IDoFacadeService{

    @Autowired
    private IProductRepository productRepository;

    @Override
    public void saveApplication() {

    }

    @Override
    public String getApplicationById() {
        return null;
    }
}
