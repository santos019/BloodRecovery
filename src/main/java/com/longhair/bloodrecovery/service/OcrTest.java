//package com.longhair.bloodrecovery.service;
//// Imports the Google Cloud client library
//import com.google.cloud.vision.v1.AnnotateImageRequest;
//import com.google.cloud.vision.v1.AnnotateImageResponse;
//import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
//import com.google.cloud.vision.v1.EntityAnnotation;
//import com.google.cloud.vision.v1.Feature;
//import com.google.cloud.vision.v1.Feature.Type;
//import com.google.cloud.vision.v1.Image;
//import com.google.cloud.vision.v1.ImageAnnotatorClient;
//import com.google.protobuf.ByteString;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//
//public class OcrTest {
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
//                for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
//                    annotation
//                            .getAllFields()
//                            .forEach((k, v) -> System.out.format("%s : %s%n", k, v.toString()));
////                            .forEach((k, v) -> System.out.println("%s : %s%n"+ k+ v.toString()));
//                    returnString += annotation.getAllFields().toString();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return returnString;
//    }
//    public static void main(String... args) throws Exception {
//
//    }
//}