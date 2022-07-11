package com.codelamps.wss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Nama : Andre Rizaldi Brillianto
 * Project : nasabah-webservice-app
 * Email: andrerizaldib@gmail.com
 * Date: 8/07/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nasabah")
public class Nasabah {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "ktp dibutuhkan")
    @NotNull(message = "ktp tidak boleh kosong")
    @Column(nullable = false, name = "ktp")
    private String ktp;

    @NotEmpty(message = "nama dibutuhkan")
    @NotNull(message = "nama tidak boleh kosong")
    @Column(nullable = false, name = "nama_lengkap")
    private String namaLengkap;

    @NotEmpty(message = "alamat dibutuhkan")
    @NotNull(message = "alamat tidak boleh kosong")
    @Column(nullable = false, name = "alamat")
    private String alamat;

    @NotEmpty(message = "tempat lahir dibutuhkan")
    @NotNull(message = "tempat lahir tidak boleh kosong")
    @Column(nullable = false, name = "tempat_lahir")
    private String tempatLahir;


    @NotNull(message = "tanggal lahir tidak boleh kosong")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate tanggalLahir;

    @NotEmpty(message = "phone dibutuhkan")
    @NotNull(message = "phone tidak boleh kosong")
    @Size(max = 13, min = 10, message = "Nomor telepon harus mininal 10 digit")
    @Column(nullable = false, unique = true)
    private String phone;
}
