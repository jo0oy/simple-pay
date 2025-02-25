package com.simplepay.banking.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredBankAccountSpringDataRepository extends JpaRepository<RegisteredBankAccountJpaEntity, Long> {
}
