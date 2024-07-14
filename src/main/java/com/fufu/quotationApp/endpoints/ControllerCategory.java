package com.fufu.quotationApp.endpoints;

import com.fufu.quotationApp.dao.CategoryService;
import com.fufu.quotationApp.entity.Category;
import com.fufu.quotationApp.entity.Qout;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerCategory {

    CategoryService categoryService;


    public ControllerCategory(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(path="/category", consumes = {
            MediaType.APPLICATION_FORM_URLENCODED_VALUE
    })
    public String addCategory(Category category) {
        categoryService.save(category);
        return "<h4>Category " + category.getName() + " successfully created!</h4>";
    }

    @GetMapping("/category")
    public String getCategories(){
        StringBuilder res = new StringBuilder();
        res.append("<div class=\"md:flex\">\n" +
                "<ul class=\"flex-column space-y space-y-4 text-sm font-medium text-gray-500 dark:text-gray-400 md:me-4 mb-4 md:mb-0\">\n"
        );
        for (Category elem : categoryService.get()) {
            res.append(elem.toHTML());
        }

        res.append("</ul>\n" +
                "    </div>");
        return res.toString();
    }
}
