package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.GeneralStaff;
import za.ac.cput.factory.GenStaffFactory;
import za.ac.cput.service.GenStaffService;

import java.util.List;

@RestController
@RequestMapping("/generalStaff")
public class GenStaffController {
    private GenStaffService genStaffService;

    @Autowired
    public GenStaffController(GenStaffService genStaffService) {
        this.genStaffService = genStaffService;
    }
}
