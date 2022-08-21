package com.dev.myclinique.utils.wrapper;

import com.dev.myclinique.app.entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorSaveEntity {
    private String username;
    private String password;
    private Doctor doctor;
}
