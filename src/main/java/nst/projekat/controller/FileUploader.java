package nst.projekat.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import nst.projekat.domain.File;
//import nst.projekat.domain.Image;
import nst.projekat.dto.SpeakerDTO;
import nst.projekat.repository.FileRepository;
//import nst.projekat.repository.ImageRepository;
import nst.projekat.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequestMapping(value = "file")
@CrossOrigin
public class FileUploader {
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private SpeakerService speakerService;

    @PostMapping("/save")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            System.out.println("Original Image Byte Size - " + file.getBytes().length);
            File fileUpload = new File(file.getOriginalFilename(), file.getContentType(),
                    compressBytes(file.getBytes()));
            fileRepository.save(fileUpload);
            return ResponseEntity.status(HttpStatus.OK).body("Uspesno sacuvana slika.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Greska prilikom cuvanja slike.");
        }
    }

    @GetMapping(path = { "/get/{imageName}" })
    public File getImage(@PathVariable("imageName") String imageName) throws IOException {

        final Optional<File> retrievedImage = fileRepository.findByName(imageName);
        File img = new File(retrievedImage.get().getName(), retrievedImage.get().getType(),
                decompressBytes(retrievedImage.get().getFileByte()));
        img.setId(retrievedImage.get().getId());
        return img;
    }

    @GetMapping("download/{fileName}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable("fileName") String fileName) throws Exception {
        /*List<SpeakerDTO> employees = speakerService.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(employees);
        byte[] isr = json.getBytes();
        String fileName = "employees.json";*/
        final Optional<File> retrievedFile = fileRepository.findByName(fileName);
        File file = new File(retrievedFile.get().getName(), retrievedFile.get().getType(),
                decompressBytes(retrievedFile.get().getFileByte()));
        file.setId(retrievedFile.get().getId());
        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.setContentLength(file.getFileByte().length);
        respHeaders.setContentType(new MediaType("text", "json"));
        respHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        respHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
        return new ResponseEntity<byte[]>(file.getFileByte(), respHeaders, HttpStatus.OK);
    }

    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();
    }

    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}
