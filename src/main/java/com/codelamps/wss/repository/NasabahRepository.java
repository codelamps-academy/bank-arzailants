package com.codelamps.wss.repository;

import com.codelamps.wss.entity.Nasabah;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Nama : Andre Rizaldi Brillianto
 * Project : nasabah-webservice-app
 * Email : andrerizaldib@gmail.com
 * website : codelamps.com
 * instagram : codelamps.inc
 * telegram : @arzailants
 * github : codelamps-academy
 * medium : @codelamps
 * Date: 8/07/22
 */
public interface NasabahRepository extends JpaRepository<Nasabah, Long> {


    // Query method
    Optional<Nasabah> findByKtp(String ktp);
}
