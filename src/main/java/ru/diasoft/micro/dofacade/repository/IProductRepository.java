package ru.diasoft.micro.dofacade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diasoft.micro.dofacade.data.ProductEntity;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Long> {

}
