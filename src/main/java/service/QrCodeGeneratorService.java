package service;

import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import dto.qrCodeGenereteResponse;
import org.springframework.stereotype.Service;
import ports.StoragePorts;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class QrCodeGeneratorService {
    private final StoragePorts storage;

    public QrCodeGeneratorService(StoragePorts storage) {
        this.storage = storage;
    }

    public qrCodeGenereteResponse generateAndUploanQrCode(String text) throws IOException, WriterException {
      QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, com.google.zxing.BarcodeFormat.QR_CODE, 250, 250);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix,"PNG",pngOutputStream);
        byte[] qrCodeData = pngOutputStream.toByteArray();

        //upload qr code
        String url = storage.upload(qrCodeData, UUID.randomUUID().toString(), "image/png");
        return new qrCodeGenereteResponse(url);
    }
}
