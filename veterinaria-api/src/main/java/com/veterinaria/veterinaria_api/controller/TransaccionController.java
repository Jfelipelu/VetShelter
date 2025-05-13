package com.veterinaria.veterinaria_api.controller;

import com.veterinaria.veterinaria_api.model.Transaccion;
import com.veterinaria.veterinaria_api.service.TransaccionService;
import com.veterinaria.veterinaria_api.repository.TransaccionRepository;

import jakarta.validation.Valid;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "*")
public class TransaccionController {

    private final TransaccionService transactionService;
    private final TransaccionRepository transaccionRepository;

    public TransaccionController(TransaccionService transactionService, TransaccionRepository transaccionRepository) {
        this.transactionService = transactionService;
        this.transaccionRepository = transaccionRepository;
    }

    @GetMapping
    public ResponseEntity<List<Transaccion>> getAll() {
        return ResponseEntity.ok(transactionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaccion> getById(@PathVariable Long id) {
        return transactionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/animal/{animalId}")
    public ResponseEntity<List<Transaccion>> getByAnimal(@PathVariable Long animalId) {
        return ResponseEntity.ok(transactionService.findByAnimal(animalId));
    }

    @PostMapping
    public ResponseEntity<Transaccion> create(@Valid @RequestBody Transaccion transaction) {
        Transaccion saved = transactionService.save(transaction);
        URI location = URI.create(String.format("/api/transactions/%s", saved.getId()));
        return ResponseEntity.created(location).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/excel")
    public ResponseEntity<byte[]> exportToExcel() throws IOException {
        List<Transaccion> transacciones = transaccionRepository.findAll();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Transacciones");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Animal");
        header.createCell(2).setCellValue("Tipo");
        header.createCell(3).setCellValue("Responsable");
        header.createCell(4).setCellValue("Fecha");

        for (int i = 0; i < transacciones.size(); i++) {
            Transaccion t = transacciones.get(i);
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(t.getId());
            row.createCell(1).setCellValue(t.getAnimal().getName());
            row.createCell(2).setCellValue(t.getType());
            row.createCell(3).setCellValue(t.getResponsible());
            row.createCell(4).setCellValue(t.getDate().toString());
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        workbook.write(bos);
        workbook.close();

        byte[] content = bos.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(ContentDisposition.attachment().filename("transacciones.xlsx").build());

        return new ResponseEntity<>(content, headers, HttpStatus.OK);
    }
}
