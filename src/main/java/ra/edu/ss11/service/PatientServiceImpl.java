package ra.edu.ss11.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ra.edu.ss11.dto.PatientRequest;

@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

    @Override
    public void processPatient(PatientRequest request) {
        // [Bài 2] Ghi log mức TRACE kiểm chứng cấu hình logging.level
        log.trace("Đang xử lý logic thêm bệnh nhân ở tầng Service: {}", request.getName());

        // [Bài 4] Mô phỏng lỗi chia cho 0 để kiểm tra Exception Handling và log.error()
        if (request.getAge() != null && request.getAge() == 0) {
            int error = 10 / 0;
        }
    }
}