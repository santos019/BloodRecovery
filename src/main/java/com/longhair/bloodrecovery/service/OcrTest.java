package com.longhair.bloodrecovery.service;
// Imports the Google Cloud client library
import com.google.cloud.vision.v1.*;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.protobuf.ByteString;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OcrTest {
        public String initFunction (String path) throws IOException {
            String returnString = "";
            String filePath = "C:/Users/Admin/Downloads/card2.jpg";
//            String filePath = path;
            List<AnnotateImageRequest> requests = new ArrayList<>();

            Image image = getImage(filePath);

            Feature feature = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();
            AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feature).setImage(image).build();
            requests.add(request);

            try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
                BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
                List<AnnotateImageResponse> responses = response.getResponsesList();

                for (AnnotateImageResponse res : responses) {
                    if (res.hasError()) {
                        System.out.println("Error: " + res.getError().getMessage());

                    }

                    // For full list of available annotations, see http://g.co/cloud/vision/docs
                    for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
                        System.out.println("Text: " + annotation.getDescription());
                        System.out.println("Position : " + annotation.getBoundingPoly());
                        returnString += annotation.getDescription();
                    }
                }
            }
            return returnString;
        }
//    public String initFunction () {
//        String returnString = "";
//        // Initialize client that will be used to send requests. This client only needs to be created
//        // once, and can be reused for multiple requests. After completing all of your requests, call
//        // the "close" method on the client to safely clean up any remaining background resources.
//        try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {
//            System.out.println("이거 받아오니???");
//            // 이미지파일 주소
//            String fileName = "C:/Users/Admin/Downloads/card2.jpg";
//
//            // Reads the image file into memory
//            Path path = Paths.get(fileName);
//            byte[] data = Files.readAllBytes(path);
//            ByteString imgBytes = ByteString.copyFrom(data);
//
//            // Builds the image annotation request
//            List<AnnotateImageRequest> requests = new ArrayList<>();
//            Image img = Image.newBuilder().setContent(imgBytes).build();
//            Feature feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
//            AnnotateImageRequest request =
//                    AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
//            requests.add(request);
//
//            // Performs label detection on the image file
//            BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
//            List<AnnotateImageResponse> responses = response.getResponsesList();
//
//            for (AnnotateImageResponse res : responses) {
//                if (res.hasError()) {
//                    System.out.format("Error: %s%n", res.getError().getMessage());
//
//                }
//
//                for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
//                      System.out.println(annotation.getAllFields());
////                    annotation
////                            .getAllFields()
////                            .forEach((k, v) -> System.out.format("%s : %s%n", k, v.toString()));
////                            .forEach((k, v) -> System.out.println("%s : %s%n"+ k+ v.toString()));
//                    returnString += annotation.getDescription();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return returnString;
//    }
    private static Image getImage(String filePath) throws IOException {
        Image image;

        if (filePath.startsWith("gs://")) { // GCS에서 이미지를 가져올때 image 생성
            ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(filePath).build();
            image = Image.newBuilder().setSource(imgSource).build();
        }
        else { // 로컬에서 이미지를 가져올때 image 생성
            ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));
            image = Image.newBuilder().setContent(imgBytes).build();
        }

        return image;
    }
    public static void main(String... args) throws Exception {

    }
}