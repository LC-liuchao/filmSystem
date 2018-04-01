package com.film.mapper;

import java.util.List;

import com.film.entity.Film;
import com.film.vo.FilmVo;

public interface FilmMapper {
	/*
	 * 插入电影
	 */
	public Integer insertFilm(Film film);
	
	/*
	 * 查询所有电影
	 */
	public List<Film> selectAll();
	
	/*
	 * 根据id查找
	 */
	public Film selectOne(Integer id);
	
	/*
	 * 根据id更改信息
	 */
	public Integer updateFilm(Film film);
	
	/*
	 * 批量删除
	 */
	public Integer batchDeleteFilms(int[] ids);
	
	/*
	 * 根据指定条件查询
	 */
	public List<Film> queryFilmListByCondition(FilmVo filmVo);
	
	
	/*
	 * 分页
	 * 查询总记录数
	 */
	public Integer selectCountByCondition(FilmVo filmVo);
	
	/*
	 * 查询分页
	 */
	public List<Film> selectListByPage(FilmVo filmVo);
}
