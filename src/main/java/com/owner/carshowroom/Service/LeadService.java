package com.owner.carshowroom.Service;

import com.owner.carshowroom.DAO.LeadRepository;
import com.owner.carshowroom.DTO.LeadDTO;
import com.owner.carshowroom.Entity.Lead;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {
    private final LeadRepository leadRepository;

    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }
    public List<LeadDTO> findAllLeads() {
        return leadRepository.findAllLeads();
    }
}
