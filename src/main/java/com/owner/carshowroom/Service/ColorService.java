package com.owner.carshowroom.Service;


import com.owner.carshowroom.DAO.ColorRepository;
import com.owner.carshowroom.Entity.Color;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {
    private final ColorRepository colorRepository;
    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }
    public List<Color> findAllColors() {
        return colorRepository.findAll();
    }
    public Color save(Color color) {
        return colorRepository.save(color);
    }
    public void delete(Color color) {
        colorRepository.delete(color);
    }

}
