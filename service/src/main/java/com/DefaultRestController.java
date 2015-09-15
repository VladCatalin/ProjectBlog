package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by CataVlad on 10-Sep-15.
 */
@Controller
public class DefaultRestController {

    @RequestMapping("/")
    public String Blog() {
        return "index.jsp";
    }
}
