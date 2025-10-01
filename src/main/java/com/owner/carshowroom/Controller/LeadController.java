package com.owner.carshowroom.Controller;

import com.owner.carshowroom.DTO.LeadDTO;
import com.owner.carshowroom.Entity.Lead;
import com.owner.carshowroom.Service.LeadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lead")
public class LeadController {
    private final LeadService leadService;
    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @GetMapping
    public List<LeadDTO> findAll()
    {
        return leadService.findAllLeads();
    }
}
