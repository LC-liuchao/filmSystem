package com.film.mapper;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.film.entity.Film;
import com.film.vo.FilmVo;

public class FilmMapperTest {
	
	ApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
	}

	@Test
	public void testInsertFilm() {
		FilmMapper filmMapper = (FilmMapper) context.getBean("filmMapper");
		//Film film = new Film("20180314001", "红海行动", "2018年", "战争", "中文", "英文", "林超贤", "张译/杜江", "2018/2/16", "1号厅", new Date(), "讲述中国海军执行撤侨任务...");
		Film film = new Film("20180314002", "唐人街探案2", "2018年", "喜剧/悬疑", "中文", "英文", "陈思诚", "王宝强/刘昊然", "2018/2/16", "2号厅", new Date(), "讲述唐仁为巨额奖金骗秦风参加世界名侦探大赛...", "1");
		Integer i = filmMapper.insertFilm(film);
		System.out.println(i);
	}

	@Test
	public void testSelectAll() {
		FilmMapper filmMapper = (FilmMapper) context.getBean("filmMapper");
		List<Film> films = filmMapper.selectAll();
		for (Film film : films) {
			System.out.println(film);
		}
	}
	
	/*@Test
	public void testSelectOne() {
		FilmMapper filmMapper = (FilmMapper) context.getBean("filmMapper");
		Film film = filmMapper.selectOne(3);
		System.out.println(film);
	}*/
	
	@Test
	public void testUpdate() {
		FilmMapper filmMapper = (FilmMapper) context.getBean("filmMapper");
		Film film = filmMapper.selectOne(3);
		film.setFilmname("唐人");
		Integer i = filmMapper.updateFilm(film);
		System.out.println(i);
		
	}
	@Test
	public void testqueryFilmcou(){
		FilmMapper filmMapper = (FilmMapper) context.getBean("filmMapper");
		FilmVo filmVo = new FilmVo();
		Film film = new Film();
		film.setFilmname("2");
		filmVo.setFilm(film);
		List<Film> films = filmMapper.queryFilmListByCondition(filmVo);
		for (Film film2 : films) {
			System.out.println(film2);
		}
	}
	
	
	@Test
	public void testSelect(){
		FilmMapper filmMapper = (FilmMapper) context.getBean("filmMapper");
		FilmVo filmVo = new FilmVo();
		filmVo.setCurrentPage(1);
		filmVo.setPageCount(4);
		Film film = new Film();
		film.setFilmname("2");
		filmVo.setFilm(film);
		List<Film> films = filmMapper.selectListByPage(filmVo);
		for (Film film2 : films) {
			System.out.println(film2);
		}
	}
}
