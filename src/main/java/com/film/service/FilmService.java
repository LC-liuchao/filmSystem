package com.film.service;

import java.util.List;

import com.film.entity.Film;
import com.film.util.PageBean;
import com.film.vo.FilmVo;

public interface FilmService {

	public String saveFilm(Film film);
	
	public List<Film> findAllFilms();
	
	public Film findOne(Integer id);
	
	/*
	 * 根据id删除
	 */
	public String deleteFilms(String[] ids);
	
	/*
	 * 根据指定条件查找
	 */
	public List<Film> findFilmListByCondition(FilmVo filmVo);
	
	
	/**
	 * 分页查询列表
	 * @param currentPage 当前页
	 * @param size 每页数
	 * @param filmVo
	 * @return
	 */
	public PageBean<Film> queryFilmByCondition(Integer currentPage,Integer size,FilmVo filmVo);
	
}
