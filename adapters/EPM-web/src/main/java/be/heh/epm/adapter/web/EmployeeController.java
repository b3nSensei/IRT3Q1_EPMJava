package be.heh.epm.adapter.web;

import be.heh.epm.application.employee.Employee;
import be.heh.epm.application.port.in.*;
import be.heh.epm.common.WebAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:3000") //Permet de lier le backend et le frontend
@WebAdapter
@RestController
public class EmployeeController {

    private AddSalariedEmployeeUseCase addSalariedEmployee;
    private DelSalariedEmployeeUseCase delSalariedEmployee;
    private GetSalariedEmployeeUseCase getSalariedEmployee;
    private GetBySalariedEmployeeUseCase getBySalariedEmployee;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public EmployeeController(AddSalariedEmployeeUseCase addSalariedEmployee,
                              DelSalariedEmployeeUseCase delSalariedEmployee,
                              GetSalariedEmployeeUseCase getSalariedEmployee,
                              GetBySalariedEmployeeUseCase getBySalariedEmployee){
        this.addSalariedEmployee = addSalariedEmployee;
        this.delSalariedEmployee = delSalariedEmployee;
        this.getSalariedEmployee = getSalariedEmployee;
        this.getBySalariedEmployee = getBySalariedEmployee;
    }

    //Mapping API
    @GetMapping("/api/helloworld") //API de test, retourne un Hello World
    public ResponseEntity helloworld() {
        return ResponseEntity.ok("Hello World 2.0 :P");
    }

    @PostMapping("/api/create") //API ajout d'user à la DB
    ResponseEntity<Void> newEmployee(@Valid @RequestBody EmployeeSalariedValidating newEmployee) {
        logger.info("Creating new employee");
        addSalariedEmployee.add(newEmployee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newEmployee.getEmpId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/api/employee") //API all Employee: retourne tout les users
    public ArrayList<Employee> getAllEmployees() {
        logger.info("Listing all employees");
        return getSalariedEmployee.get();
    }

    @GetMapping("/api/employee/{id}") //API ID Employee: Retourne un user avec ID correspondant
    public Employee findByid(@PathVariable int id) {
        logger.info("Fetching user by ID");
        return getBySalariedEmployee.getBy(id);
    }

    @DeleteMapping("/api/employee/delete/{id}") //API delete Employee: prend un id en parametre pour supprimer un employe dans la db
    public ResponseEntity deleteClient(@PathVariable int id){
        logger.info("Deleting employee");
        logger.info(String.valueOf(id));
        delSalariedEmployee.del(id);
        return ResponseEntity.ok("DELETE");
    }

}
