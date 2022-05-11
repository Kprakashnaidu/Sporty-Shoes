package com.sportyshoes.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SimpleErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        // get error status

        String error = null;

        final String referer = request.getHeader("Referer");

        String path = request.getContextPath();

        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        switch (statusCode) {

            case 500:
                error = "Internal Server Error";
                break;
            case 403:
                error = "Request Forbidden";
                break;
            case 400:
                error = "Bad Request";
                break;
            case 401:
                error = "Unauthorized";
                break;
            default:
                error = "Page Not Found";
        }

        model.addAttribute("statusCode", statusCode);
        model.addAttribute("error", error);
        model.addAttribute("path", path);
        model.addAttribute("referer", referer);

        // display generic error
        return "error";
    }
}
