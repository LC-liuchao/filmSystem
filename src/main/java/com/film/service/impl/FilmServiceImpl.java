package com.film.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.film.entity.Film;
import com.film.mapper.FilmMapper;
import com.film.service.FilmService;
import com.film.util.PageBean;
import com.film.vo.FilmVo;

@Service
public class FilmServiceImpl implements FilmService {
	@Autowired
	private FilmMapper filmMapper;
	@Override
	public String saveFilm(Film film) {
		film.setDelflag("0");
		int i = 0;
		if(film.getId() != null){
			i = filmMapper.updateFilm(film);
		}else {
			i = filmMapper.insertFilm(film);
		}
		if(i > 0){
			return "true";
		}
		return "false";
	}

	@Override
	public List<Film> findAllFilms() {
		return filmMapper.selectAll();
	}

	@Override
	public Film findOne(Integer id) {
		return filmMapper.selectOne(id);
	}

	@Override
	public String deleteFilms(String[] ids) {
		int[] filmIds = new int[ids.length];
		for (int i = 0; i < ids.length; i++) {
			filmIds[i] = Integer.parseInt(ids[i]);
		}
		int i = filmMapper.batchDeleteFilms(filmIds);
		if(i > 0) {
			return "true";
		}
		return "false";
	}

	@Override
	public List<Film> findFilmListByCondition(FilmVo filmVo) {
		return filmMapper.queryFilmListByCondition(filmVo);
	}

	@Override
	public PageBean<Film> queryFilmByCondition(Integer currentPage, Integer size, FilmVo filmVo) {
		//获取记录总数
		int count = filmMapper.selectCountByCondition(filmVo);
		//获取list集合
		filmVo.setCurrentPage(currentPage);
		filmVo.setPageCount(size);
		List<Film> filmList = filmMapper.selectListByPage(filmVo);
		PageBean<Film> pageBean = new PageBean<>(count, size);
		pageBean.setCurrent(currentPage);
		pageBean.setDatas(filmList);
		return pageBean;
	}
}
