package com.code.apostador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApostadorBDRepository extends JpaRepository<ApostadorBD, Long> {

}
