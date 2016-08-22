package com.mjd.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mjd.model.Reader;

public interface ReaderRepository extends JpaRepository<Reader, String> {
}
