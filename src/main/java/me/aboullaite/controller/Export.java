package me.aboullaite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.aboullaite.service.EmployeeService;
import me.aboullaite.service.MessageService;
import me.aboullaite.view.PdfView;

/**
 * Created by aboullaite on 2017-02-23.
 */

@Controller
public class Export {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    MessageService messageService;
    /**
     * Handle request to download an Excel document
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public PdfView download(final Model model) {
        model.addAttribute("users", employeeService.findAll());
        model.addAttribute("message", messageService.findAll());
        final PdfView view = new PdfView();
        return view;
    }


}
