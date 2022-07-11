package com.codelamps.wss.controller;

import com.codelamps.wss.entity.Nasabah;
import com.codelamps.wss.service.NasabahService;
import com.codelamps.wss.exception.NasabahNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * Nama : Andre Rizaldi Brillianto
 * Project : nasabah-webservice-app
 * Email: andrerizaldib@gmail.com
 * Date: 8/07/22
 */
@RestController
@Tag(name = "Nasabah", description = "Endpoints untuk mengatur nasabah")
@RequestMapping("/nasabah")
public class NasabahController {

    private final NasabahService nasabahService;

    @Autowired
    public NasabahController(NasabahService nasabahService) {
        this.nasabahService = nasabahService;
    }

    @GetMapping
    @Operation(
            summary = "Daftar Semua Nasabah",
            description = "Daftar Semua Nasabah.",
            tags = {"Nasabah"})
    @ApiResponses(value = {
            @ApiResponse(
                    description = "Success",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation =
                            Nasabah.class))
            ),
            @ApiResponse(description = "Not found", responseCode = "404",
                    content = @Content),
            @ApiResponse(description = "Internal error", responseCode = "500"
                    , content = @Content)
    }
    )
    public List<Nasabah> getAllNasabah() {
        return nasabahService.getAllNasabah();
    }

    @GetMapping(value = "/{id}")
    @Operation(
            summary = "Mendapatkan Nasabah dengan ID",
            description = "Mendapatkan Nasabah dengan ID",
            tags = {"Nasabah"})
    @ApiResponses(value = {
            @ApiResponse(
                    description = "Success",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation =
                            Nasabah.class))
            ),
            @ApiResponse(description = "Not found", responseCode = "404",
                    content = @Content),
            @ApiResponse(description = "Internal error", responseCode = "500"
                    , content = @Content)
    }
    )
    public Nasabah getNasabahById(@PathVariable("id") @Min(1) Long id) {
        Nasabah nasabah = nasabahService.findById(id)
                .orElseThrow(() -> new NasabahNotFoundException("Nasabah with " + id + " is Not Found!"));
        return nasabah;
    }

//    @GetMapping(value = "/{ktp}")
//    @Operation(
//            summary = "Mendapatkan Data Nasabah by KTP",
//            description = "Mendapatkan Data Nasabah by KTP",
//            tags = {"Nasabah"})
//    @ApiResponses(value = {
//            @ApiResponse(
//                    description = "Success",
//                    responseCode = "200",
//                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Nasabah.class))
//            ),
//            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
//            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
//    })
//    public Nasabah getNasabahByKTP(@PathVariable("ktp") @Min(1) String ktp){
//        return nasabahService.findById(ktp)
//                .orElseThrow(() -> new NasabahNotFoundException("Nasabah with " + ktp + " is not Found"));
//    }

    @PostMapping
    @Operation(
            summary = "Menambahkan Nasabah Baru",
            description = "Menambahkan Nasabah Baru",
            tags = {"Nasabah"})
    @ApiResponses(value = {
            @ApiResponse(
                    description = "Success",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation =
                            Nasabah.class))
            ),
            @ApiResponse(description = "Not found", responseCode = "404",
                    content = @Content),
            @ApiResponse(description = "Internal error", responseCode = "500"
                    , content = @Content)})
    public Nasabah addNasabah(@Valid @RequestBody Nasabah nasabah) {
        return nasabahService.save(nasabah);
    }

    @PutMapping(value = "/{id}")
    @Operation(
            summary = "Update Nasabah by ID",
            description = "Update Nasabah by ID",
            tags = {"Nasabah"})
    @ApiResponses(value = {
            @ApiResponse(
                    description = "Success",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation =
                            Nasabah.class))
            ),
            @ApiResponse(description = "Not found", responseCode = "404",
                    content = @Content),
            @ApiResponse(description = "Internal error", responseCode = "500"
                    , content = @Content)
    }
    )
    public Nasabah updateNasabah(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Nasabah newNasabah) {
        Nasabah nasabah = nasabahService.findById(id)
                .orElseThrow(() -> new NasabahNotFoundException("Nasabah with " + id + " is Not Found!"));
        nasabah.setKtp(newNasabah.getKtp());
        nasabah.setNamaLengkap(newNasabah.getNamaLengkap());
        nasabah.setAlamat(newNasabah.getAlamat());
        nasabah.setTanggalLahir(newNasabah.getTanggalLahir());
        nasabah.setTempatLahir(newNasabah.getTempatLahir());
        nasabah.setPhone(newNasabah.getPhone());
        return nasabahService.save(nasabah);
    }


    @PatchMapping(value = "/{id}")
    @Operation(
            summary = "Update Nasabah by ID",
            description = "Update Nasabah by ID",
            tags = {"Nasabah"})
    @ApiResponses(value = {
            @ApiResponse(
                    description = "Success",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation =
                            Nasabah.class))
            ),
            @ApiResponse(description = "Not found", responseCode = "404",
                    content = @Content),
            @ApiResponse(description = "Internal error", responseCode = "500"
                    , content = @Content)})
    public Nasabah patchNasabah(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Nasabah newNasabah) {
        Nasabah nasabah = nasabahService.findById(id)
                .orElseThrow(() -> new NasabahNotFoundException("Nasabah with " + id + " is Not Found!"));
        nasabah.setKtp(newNasabah.getKtp());
        nasabah.setNamaLengkap(newNasabah.getNamaLengkap());
        nasabah.setAlamat(newNasabah.getAlamat());
        nasabah.setTanggalLahir(newNasabah.getTanggalLahir());
        nasabah.setTempatLahir(newNasabah.getTempatLahir());
        nasabah.setPhone(newNasabah.getPhone());
        return nasabahService.save(nasabah);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(
            summary = "Delete Nasabah by ID",
            description = "Delete Nasabah by ID",
            tags = {"Nasabah"})
    @ApiResponses(value = {
            @ApiResponse(
                    description = "Success",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation =
                            Nasabah.class))
            ),
            @ApiResponse(description = "Not found", responseCode = "404",
                    content = @Content),
            @ApiResponse(description = "Internal error", responseCode = "500"
                    , content = @Content)
    }
    )
    public String deleteStudent(@PathVariable("id") @Min(1) Long id) {
        Nasabah nasabah = nasabahService.findById(id)
                .orElseThrow(() -> new NasabahNotFoundException("Nasabah with " + id + " is Not Found!"));
        nasabahService.deleteById(nasabah.getId());
        return "Nasabah with ID :" + id + " is deleted";
    }
}
