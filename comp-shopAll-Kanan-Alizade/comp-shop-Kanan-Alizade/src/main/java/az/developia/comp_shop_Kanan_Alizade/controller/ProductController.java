package az.developia.comp_shop_Kanan_Alizade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/ps-shopping")
    public String shoppingPage() {
        return "ps-shopping"; // ps-shopping.html e kececek;
    }

    @GetMapping("/ps")
    public String productPage() {
        return "ps"; // ps.html e kececek;
    }
}