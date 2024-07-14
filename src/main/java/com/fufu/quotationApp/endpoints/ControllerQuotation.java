package com.fufu.quotationApp.endpoints;

import com.fufu.quotationApp.dao.QoutationService;
import com.fufu.quotationApp.entity.Qout;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerQuotation {

    private QoutationService qoutationService;

    public ControllerQuotation(QoutationService qoutationService) {
        this.qoutationService = qoutationService;
    }

    @GetMapping("/qouts")
    public String getQoutsList() {
        StringBuilder res = new StringBuilder();
        for (Qout elem : qoutationService.get()) {
            res.append(elem.toHTML());
        }
        return res.toString();
    }

    @PostMapping(
            path="/qouts",
            consumes = {
                    MediaType.APPLICATION_FORM_URLENCODED_VALUE
            })
    public String postQout(Qout qout) {
        qoutationService.inputValidation(qout);
        qoutationService.save(qout);
        return TemplateQoutation.PostQouteForm;
    }

    @DeleteMapping("/qouts/{id}")
    public ResponseEntity<Void> deleteQout(@PathVariable("id") int id) {
        qoutationService.delete(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("HX-Trigger", "delete-quote");
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.OK);
    }



    // EDIT QUOT
    @GetMapping("/editQuot/{id}")
    public String getQuotForm(@PathVariable("id") int id) {
        return TemplateQoutation.EditForm("static/editing_form.html", qoutationService.getCertainQuot(id));
    }

    @PutMapping(path = "/qouts/{id}", consumes = {
            MediaType.APPLICATION_FORM_URLENCODED_VALUE
    })
    public ResponseEntity<Void> updateQuot(Qout qout, @PathVariable("id") int id) {
        qoutationService.update(qout);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("HX-Redirect", "/");
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.OK);

    }

}
