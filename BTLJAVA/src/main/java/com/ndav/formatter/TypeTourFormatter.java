/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.formatter;

import com.ndav.pojos.Typetour;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ADMIN
 */
public class TypeTourFormatter implements Formatter<Typetour> {

    @Override
    public String print(Typetour t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Typetour parse(String typeId, Locale locale) throws ParseException {
        Typetour t = new Typetour();
        t.setId(Long.parseLong(typeId));
        return t;
    }

}
