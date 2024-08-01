package com.repo.repository;

import com.repo.model.URL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface URLShortenerRepository extends JpaRepository<URL, Long> {
    Optional<URL> findByOriginalUrl(String originalUrl);
}
