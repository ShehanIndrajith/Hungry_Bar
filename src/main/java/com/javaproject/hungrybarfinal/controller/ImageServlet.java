package com.javaproject.hungrybarfinal.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {
    private static final String STAFF_IMAGE_DIRECTORY = "D:/Java Project/Front-End/src/Images/StaffProfileImages/";
    private static final String MENU_ITEM_IMAGE_DIRECTORY = "D:/Java Project/Front-End/src/Images/MenuItemImages/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Extract the image filename from the URL
        String filename = req.getPathInfo().substring(1); // Remove the leading slash

        // Determine the directory based on the request
        String imageDirectory;
        if (filename.startsWith("staff/")) {
            imageDirectory = STAFF_IMAGE_DIRECTORY;
            filename = filename.substring("staff/".length()); // Remove the "staff/" prefix
        } else if (filename.startsWith("menu/")) {
            imageDirectory = MENU_ITEM_IMAGE_DIRECTORY;
            filename = filename.substring("menu/".length()); // Remove the "menu/" prefix
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND); // 404 Not Found
            return;
        }

        // Construct the full file path
        File imageFile = new File(imageDirectory, filename);

        // Check if the file exists
        if (!imageFile.exists()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND); // 404 Not Found
            return;
        }

        // Set the content type
        resp.setContentType("image/png"); // Adjust based on your image type

        // Stream the image to the response
        try (FileInputStream in = new FileInputStream(imageFile);
             OutputStream out = resp.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}