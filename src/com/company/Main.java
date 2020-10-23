package com.company;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import static org.opencv.imgcodecs.Imgcodecs.*;

public class Main {

    public static void main(String[] args) {

        System.load("F:\\Nikita\\MPr\\opencv\\build\\java\\x64\\opencv_java343.dll");
        CascadeClassifier faceDetector = new CascadeClassifier();
        faceDetector.load("F:\\Nikita\\MPr\\opencv\\build\\etc\\haarcascades\\haarcascade_frontalface_default.xml");
        Mat img = imread("nika.jpeg", CV_LOAD_IMAGE_COLOR);

        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(img, faceDetections);

        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(img, new Point(rect.x, rect.y), new Point(rect.x + rect.width,
                            rect.y + rect.height),
                    new Scalar(0, 255, 0));
        }
        imwrite("result.png", img);
        System.out.println("Succesfull");
    }
}