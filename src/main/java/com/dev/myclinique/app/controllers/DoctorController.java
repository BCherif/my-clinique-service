package com.dev.myclinique.app.controllers;

import com.dev.myclinique.app.entities.Doctor;
import com.dev.myclinique.app.services.DoctorService;
import com.dev.myclinique.base.response.CResponse;
import com.dev.myclinique.base.response.PageData;
import com.dev.myclinique.utils.wrapper.DoctorSaveEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/doctors")
@AllArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/page")
    public CResponse<PageData<Doctor>> findAllByPeageable(Pageable pageable) {
        return CResponse.success(PageData.fromPage(doctorService.findAllByPage(pageable)));
    }

    @PostMapping("/save")
    public ResponseEntity<?> create(@RequestParam("doctorSaveEntity") String newDoctorSaveEntity,
                                    @RequestParam("file") MultipartFile file) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        DoctorSaveEntity doctorSaveEntity = objectMapper.readValue(newDoctorSaveEntity, DoctorSaveEntity.class);
        return ResponseEntity.ok(doctorService.create(doctorSaveEntity, file));
    }
}
