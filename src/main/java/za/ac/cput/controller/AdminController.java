package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Admin;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*") // Allow all origins and headers
public class AdminController {
    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/save")
    public ResponseEntity<Admin> save(@RequestBody Admin obj){
        Admin boss = AdminFactory.buildAdmin(obj.getId(),obj.getName(),obj.getSurname(),obj.getUsername(),obj.getPassword());
        if(boss != null){
            if(!adminService.findAdminByUsername(boss.getUsername())){
                return ResponseEntity.status(HttpStatus.OK).body(adminService.save(boss));
            }
        }
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Admin> read(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.read(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Admin> update(@RequestBody Admin obj){
        Admin boss = AdminFactory.buildAdmin(obj.getId(),obj.getName(),obj.getSurname(),obj.getUsername(),obj.getPassword());
        if(boss != null){
            if(!adminService.findAdminByUsername(boss.getUsername())){
                Admin bossMan = adminService.update(boss);
                if(bossMan != null){
                    return ResponseEntity.status(HttpStatus.OK).body(bossMan);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.delete(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Admin>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.getAll());
    }
}
