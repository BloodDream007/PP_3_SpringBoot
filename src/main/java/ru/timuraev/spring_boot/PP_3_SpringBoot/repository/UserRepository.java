package ru.timuraev.spring_boot.PP_3_SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.timuraev.spring_boot.PP_3_SpringBoot.model.User;

public interface UserRepository extends JpaRepository<User, Long> { // дженерик JpaRepository<Для кого, Тип ID>
}
