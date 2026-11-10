package ra.edu.ss11.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.ss11.dto.ApiResponse;
import ra.edu.ss11.dto.PatientRequest;
import ra.edu.ss11.service.PatientService;

@Slf4j
@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<ApiResponse<PatientRequest>> addPatient(@Valid @RequestBody PatientRequest request) {
        log.info("Tiếp nhận bệnh nhân mới: {}", request.getName());

        if (request.getAge() > 120) {
            log.warn("Cảnh báo: Tuổi bệnh nhân bất thường ({} tuổi) đối với bệnh nhân: {}",
                    request.getAge(), request.getName());
        }

        patientService.processPatient(request);

        return new ResponseEntity<>(
                new ApiResponse<>("Thêm bệnh nhân thành công", true, request),
                HttpStatus.CREATED
        );
    }
}