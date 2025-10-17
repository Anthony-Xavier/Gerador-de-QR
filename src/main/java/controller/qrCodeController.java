package controller;

import dto.qrCodeGenereteRequest;
import dto.qrCodeGenereteResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")

public class qrCodeController {

    @PostMapping
    public ResponseEntity<qrCodeGenereteResponse> generete(@RequestBody qrCodeGenereteRequest request){
        return null;
    }
}
