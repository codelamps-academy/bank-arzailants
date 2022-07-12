package com.codelamps.wss.service;

import com.codelamps.wss.entity.Nasabah;
import com.codelamps.wss.repository.NasabahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class NasabahServiceImpl implements NasabahService {

    private final NasabahRepository nasabahRepository;

    @Autowired
    public NasabahServiceImpl(NasabahRepository nasabahRepository) {
        this.nasabahRepository = nasabahRepository;
    }

    @Override
    public List<Nasabah> getAllNasabah() {
        return nasabahRepository.findAll();
    }

    @Override
    public Optional<Nasabah> findById(Long id) {
        return nasabahRepository.findById(id);
    }

    @Override
    public Optional<Nasabah> findByKTP(String ktp) {
        return nasabahRepository.findByKtp(ktp);
    }


    @Override
    public Nasabah save(Nasabah nasabah) {
        return nasabahRepository.save(nasabah);
    }

    @Override
    public void deleteById(Long id) {
        nasabahRepository.deleteById(id);
    }
}
