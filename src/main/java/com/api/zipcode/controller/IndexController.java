/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.zipcode.controller;

import com.api.zipcode.config.Conexion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.json.simple.JSONValue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Draxl
 */
@RestController
public class IndexController {
    Conexion conexion = new Conexion();
    JdbcTemplate consulta = new JdbcTemplate(conexion.Conectar());
    
    @RequestMapping(value = "/inicio", produces = "text/json; charset=utf-8")
    public @ResponseBody String inicio(HttpServletRequest request){
        return JSONValue.toJSONString("exito");
        
    }
    
    @RequestMapping(value = "/zip-codes/{zip-code}", method = RequestMethod.GET, produces = "text/json; charset=utf-8")
    public @ResponseBody String getZipcode(HttpServletRequest request, HttpServletResponse response,
            @PathVariable(value = "zip-code") String zipcode){
        List<Map<String,Object>> zip;
        List registros = new ArrayList();
        HashMap data = new HashMap();
        String sql = "SELECT * FROM `zipcode` WHERE d_codigo = '"+zipcode+"'";
        zip = consulta.queryForList(sql);
        if(zip.size() == 0){
            return JSONValue.toJSONString(zip);
        }
        data.put("zip_code", zipcode);
        data.put("federal_entity", zip.get(0).get("d_estado"));
        data.put("municipality", zip.get(0).get("D_mnpio"));
        
        for (Map<String, Object> map : zip) {
            HashMap item = new HashMap();
            item.put("name", map.get("d_asenta"));
            item.put("zone_type", map.get("d_zona"));
            item.put("settlement_type", map.get("d_tipo_asenta"));
            registros.add(item);
        }
        data.put("settlements", registros);
        
        return JSONValue.toJSONString(data);
    }
    
    @RequestMapping(value = "/zipcodes", method = RequestMethod.GET, produces = "text/json; charset=utf-8")
    public @ResponseBody String getZipCodes(){
        String sql = "select * from zipcode";
        List datos = consulta.queryForList(sql);
        return JSONValue.toJSONString(datos);
    }
}
