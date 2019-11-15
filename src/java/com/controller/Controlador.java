package com.controller;

import com.conexion.Conexion;
import com.entity.Persona;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Familia Gomez
 */
@Controller
public class Controlador {
    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.conetar());
    ModelAndView mav = new ModelAndView();
    Persona pe = new Persona();
    List datos;
    @RequestMapping("index.htm")
    public ModelAndView listar(){
        String sql ="select * from persona";
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("index");
        return mav;
    }
    
    /*metodo para redireccionar por paginas*/
    @RequestMapping(value="agregar.htm", method = RequestMethod.GET)
    public ModelAndView agregar(){
        mav.addObject(new Persona());
        mav.setViewName("agregar");
        return mav;
    }
    
    /*Metodo para guardar datos*/
    @RequestMapping(value="agregar.htm", method = RequestMethod.POST)
    public ModelAndView agregar(Persona p){
        String sql ="insert into persona(nombre,correo,nacionalidad) values(?,?,?)";
        this.jdbcTemplate.update(sql,p.getNombre(),p.getCorreo(),p.getNacionalidad());
        return new ModelAndView("redirect:/index.htm"); 
    }
    
    
    /*pasar datos entre paginas*/
    @RequestMapping(value="modificar.htm", method = RequestMethod.GET)
    public ModelAndView modificar(HttpServletRequest request){
        pe.setId(Integer.parseInt(request.getParameter("id")));
        String sql ="select * from persona where id="+pe.getId();
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("modificar");//redireccionar a la vista
        return mav;
    }
    
    @RequestMapping(value="modificar.htm", method = RequestMethod.POST)
    public ModelAndView modificar(Persona p){
        String sql = "update persona set nombre=?, correo=?, nacionalidad=? where id="+pe.getId();
        this.jdbcTemplate.update(sql,p.getNombre(),p.getCorreo(),p.getNacionalidad());
        return new ModelAndView("redirect:/index.htm");
    }
    
    @RequestMapping(value="eliminar.htm")
    public ModelAndView eliminar(HttpServletRequest request){
        pe.setId(Integer.parseInt(request.getParameter("id")));
        String sql ="delete from persona where id="+pe.getId();
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/index.htm");
    }
}
