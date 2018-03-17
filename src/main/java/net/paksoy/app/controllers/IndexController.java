package net.paksoy.app.controllers;

import com.google.cloud.Timestamp;
import net.paksoy.models.Visit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class IndexController {
    @RequestMapping("/")
    public List<Visit> home() {
        Visit v = new Visit();
        v.created = Timestamp.now();
        v.id = 88L;
        return Arrays.asList(v);
    }
}
