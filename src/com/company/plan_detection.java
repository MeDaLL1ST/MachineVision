package com.company;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class plan_detection {

    public static void main(String[] args) {
        System.load("F:\\Nikita\\MPr\\opencv\\build\\java\\x64\\opencv_java343.dll");

        Mat source= Imgcodecs.imread("plz33.PNG");
        Mat template=Imgcodecs.imread("template22.PNG");

        Mat outputImage=new Mat();
        int machMethod= Imgproc.TM_CCOEFF;

        Imgproc.matchTemplate(source, template, outputImage, machMethod);
        Core.MinMaxLocResult mmr = Core.minMaxLoc(outputImage);
        Point matchLoc=mmr.maxLoc;

        Imgproc.rectangle(source, matchLoc, new Point(matchLoc.x + template.cols(), matchLoc.y + template.rows()), new Scalar(0, 255, 0));

        Imgcodecs.imwrite("sonuc.jpg", source);
        System.out.println("Succesfull");

    }
}
