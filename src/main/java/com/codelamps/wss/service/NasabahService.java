package com.codelamps.wss.service;

import com.codelamps.wss.entity.Nasabah;

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
public interface NasabahService {
    List<Nasabah> getAllNasabah();

    Optional<Nasabah> findById(Long id);

    Optional<Nasabah> findByKTP(String ktp);

    Nasabah save(Nasabah nasabah);

    void deleteById(Long id);
}
