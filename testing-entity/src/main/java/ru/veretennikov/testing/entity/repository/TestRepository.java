package ru.veretennikov.testing.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.veretennikov.testing.entity.db.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
}