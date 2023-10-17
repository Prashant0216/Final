package com.example.demo;

import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletResponse;


@Controller
public class ClientController {
 
    @Autowired
    private ClientServiceImpl clientServiceImpl;
 
    @GetMapping("/")
    public String viewHomePage(Model model) {
     
        return "welcome";
    }
 
    
    @GetMapping("/admin")
    public String HomePage(Model model) {
        model.addAttribute("allemplist", clientServiceImpl.getAllClient());
        return "index";
    }
    
    @GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "requestforbooking";
    }
 
    @GetMapping("/Requesttocall")
    public String requesttocall(Model model) {
        Client client = new Client();
        model.addAttribute("client2", client);
        return "requesttocall";
    }
    
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("client") Client client) {
    	clientServiceImpl.save(client);
        return "redirect:/";
    }
 
    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Client client = clientServiceImpl.getById(id);
        model.addAttribute("client", client);
        return "update";
    }
 
    @GetMapping("/deleteEmployee/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
    	clientServiceImpl.deleteViaId(id);
        return "redirect:/";
 
    }
    //Excel
    @GetMapping("/export-to-excel")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ShreePlanYourJourney" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List <Client> listOfEmployee = clientServiceImpl.getAllClient();
        ExcelGenerator generator = new ExcelGenerator(listOfEmployee);
        generator.generateExcelFile(response);
    }
    
  
}