package dev.codeio.Helloworld1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.codeio.Helloworld1.DTO.UserData;
@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {
	
}
