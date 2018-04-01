package com.film.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.film.entity.Film;
import com.film.service.FilmService;
import com.film.util.PageBean;
import com.film.vo.FilmVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author 柳超
 * @date 2018年3月13日 下午2:18:52
 */
@Controller
@RequestMapping("/film")
public class FilmController {

	private static final Integer pageSize = 2;
	private static final Integer firstPage = 1;
	
	@Autowired
	private FilmService filmService;

	/*@RequestMapping("/list")
	public String queryFilm(Model model, HttpSession session) {
		session.setAttribute("date", new Date());
		List<Film> films = filmService.findAllFilms();
		model.addAttribute("films", films);
		return "filmList";
	}*/

	// (插件)分页
	/*@RequestMapping("/list")
	public String queryFilm(Model model,HttpSession session, @RequestParam(required = true, defaultValue = "1") Integer page)
			throws Exception {
		session.setAttribute("date", new Date());
		PageHelper.startPage(page, 3);
		List<Film> films = filmService.findAllFilms();
		PageInfo<Film> pageInfo = new PageInfo<Film>(films);
		model.addAttribute("page", pageInfo);
		model.addAttribute("films", films);
		return "filmList";
	}*/
	
	//分页（数据库分页）
	@RequestMapping("/getFilmData")
	public String getFilmData(Model model,FilmVo filmVo,HttpServletRequest request) throws Exception{
		String pageNo = request.getParameter("page");
		String filmName = request.getParameter("filmName");
		System.out.println("filmName"+filmName);
		if(filmName != null){
			Film film = new Film();
			film.setFilmname(filmName);
			filmVo.setFilm(film);
		}
		if(pageNo == null){
			pageNo = String.valueOf(firstPage);
		}
		PageBean<Film> page = filmService.queryFilmByCondition(Integer.valueOf(pageNo), pageSize, filmVo);
		request.setAttribute("page", page);
		
		return "filmListDataPage";
	}

	/*@RequestMapping("/list")
	public String queryConditionFilm(Model model, FilmVo filmVo) {
		List<Film> films = filmService.findFilmListByCondition(filmVo);
		model.addAttribute("films", films);
		return "filmList";
	}*/
	@RequestMapping("/list")
	public String queryConditionFilm(HttpSession session) {
		session.setAttribute("date", new Date());
		return "filmList";
	}

	@RequestMapping("/preAdd")
	public String preAdd() {
		return "filmForm";
	}

	@RequestMapping("/save")
	@ResponseBody
	public String add(Film film) {
		return filmService.saveFilm(film);
	}

	@RequestMapping("/preUpdate")
	public String preUpdate(Model model, Integer id) {
		Film film = filmService.findOne(id);
		model.addAttribute("film", film);
		// return "filmUpdate";
		return "filmForm";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String deleteFilms(String ids) {
		String[] filmIds = ids.split(",");
		return filmService.deleteFilms(filmIds);
	}

	/*
	 * @RequestMapping("/update")
	 * 
	 * @ResponseBody public String update(Film film) { return
	 * filmService.updateFilm(film); }
	 */
}
