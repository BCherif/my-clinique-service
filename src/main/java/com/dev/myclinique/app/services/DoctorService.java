package com.dev.myclinique.app.services;

import com.dev.myclinique.app.entities.Doctor;
import com.dev.myclinique.app.repositories.DoctoRepository;
import com.dev.myclinique.app.uploads.FileUploadService;
import com.dev.myclinique.auth.entity.User;
import com.dev.myclinique.auth.repository.UserRepository;
import com.dev.myclinique.base.response.CResponse;
import com.dev.myclinique.utils.UploadLink;
import com.dev.myclinique.utils.wrapper.DoctorSaveEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static com.dev.myclinique.utils.Utils.getDefaultPageable;

@Service
@AllArgsConstructor
public class DoctorService {
    private final DoctoRepository doctoRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final FileUploadService fileUploadService;

    public Page<Doctor> findAllByPage(Pageable pageable) {
        return doctoRepository.findAll(getDefaultPageable(pageable));
    }

    public CResponse<Doctor> create(DoctorSaveEntity doctorSaveEntity, MultipartFile file) {
        try {
            if (!userRepository.existsByUsername(doctorSaveEntity.getUsername())) {
                Doctor doctor = doctorSaveEntity.getDoctor();
                doctor.setImage(fileUploadService.uploadFile(file, UploadLink.DOCTOR_AVATAR_LINK));
                Doctor newDoctor = doctoRepository.save(doctor);
                User userBuilder = User
                        .builder()
                        .username(doctorSaveEntity.getUsername())
                        .password(passwordEncoder.encode(doctorSaveEntity.getPassword()))
                        .doctor(newDoctor)
                        .active(true)
                        .admin(true)
                        .build();
                userRepository.save(userBuilder);
                return CResponse.success(newDoctor, "Docteur ajouté avec succes");
            } else {
                return CResponse.error("Ce nom d'utilisateur est déjà utilisé");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CResponse.error("Une erreur est survenue!");
        }
    }
}
