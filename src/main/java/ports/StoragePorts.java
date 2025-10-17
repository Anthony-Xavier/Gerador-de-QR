package ports;

public interface StoragePorts {
    String upload(byte[] data, String fileName, String contentType);
}
