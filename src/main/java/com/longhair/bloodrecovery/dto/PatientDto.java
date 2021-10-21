package com.longhair.bloodrecovery.dto;

import com.longhair.bloodrecovery.domain.DirectDonation;
import lombok.Data;

@Data
public class PatientDto {
    private String patientName;
    private String hospitalName;
    private String roomNumber;

    public PatientDto(DirectDonation directDonation){
        patientName = directDonation.getPatientName();
        hospitalName = directDonation.getHospitalName();
        roomNumber = directDonation.getRoomNumber();
    }
}
