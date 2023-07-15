package me.kzv.core.worldcup.application.port.out

import me.kzv.core.worldcup.domain.WorldCup
import org.springframework.data.jpa.repository.JpaRepository

interface WordCupRepository : JpaRepository<WorldCup, Long>
