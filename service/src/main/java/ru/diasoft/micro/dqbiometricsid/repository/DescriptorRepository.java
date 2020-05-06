package ru.diasoft.micro.dqbiometricsid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diasoft.micro.dqbiometricsid.model.entity.DescriptorEntity;

@Repository
public interface DescriptorRepository extends JpaRepository<DescriptorEntity, Long> {
}
