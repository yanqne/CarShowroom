package com.owner.carshowroom.Controller;

import com.owner.carshowroom.Entity.Color;
import com.owner.carshowroom.Service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/color")
public class ColorController {
    private final ColorService colorService;

    @Autowired
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping
    public List<Color> findAll() {
        return colorService.findAllColors();
    }
    @PostMapping
    public Color save(@RequestBody Color color) {
        return colorService.save(color);
    }
    @DeleteMapping
    public void delete(@RequestBody Color color) {
        colorService.delete(color);
    }
}
