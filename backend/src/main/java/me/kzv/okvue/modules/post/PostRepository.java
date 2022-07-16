package me.kzv.okvue.modules.board;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FreeRepository extends JpaRepository<Free, Long> {
    Optional<Free> findByIdx(Long idx);

    long deleteByIdx(Long idx);
}
