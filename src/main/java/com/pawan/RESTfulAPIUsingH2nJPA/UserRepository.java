package com.pawan.RESTfulAPIUsingH2nJPA;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
