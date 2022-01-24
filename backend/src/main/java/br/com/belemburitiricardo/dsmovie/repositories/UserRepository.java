package br.com.belemburitiricardo.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.belemburitiricardo.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	/*criar busca pelo metodo do campo*/
	User findByEmail(String email);
}
