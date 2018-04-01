package com.film.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 电影实体
 * @author 柳超
 * @date 2018年3月14日 上午10:33:47
 */
public class Film {
	private Integer id;
	private String filmcode;
	private String filmname;
	private String years;
	private String type;
	private String language;
	private String captions;
	private String director;
	private String actor;
	private String showtime;
	private String playhall;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date playtime;
	private String description;
	
	private String delflag = "0";//删除表示位 0正常 1删除
	/**
	 * 
	 */
	public Film() {
		super();
	}
	
	
	
	
	

	/**
	 * @param filmcode
	 * @param filmname
	 * @param years
	 * @param type
	 * @param language
	 * @param captions
	 * @param director
	 * @param actor
	 * @param showtime
	 * @param playhall
	 * @param playtime
	 * @param description
	 * @param delflag
	 */
	public Film(String filmcode, String filmname, String years, String type, String language, String captions,
			String director, String actor, String showtime, String playhall, Date playtime, String description,
			String delflag) {
		super();
		this.filmcode = filmcode;
		this.filmname = filmname;
		this.years = years;
		this.type = type;
		this.language = language;
		this.captions = captions;
		this.director = director;
		this.actor = actor;
		this.showtime = showtime;
		this.playhall = playhall;
		this.playtime = playtime;
		this.description = description;
		this.delflag = delflag;
	}


	/**
	 * @return the delflag
	 */
	public String getDelflag() {
		return delflag;
	}



	/**
	 * @param delflag the delflag to set
	 */
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}






	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the filmcode
	 */
	public String getFilmcode() {
		return filmcode;
	}
	/**
	 * @param filmcode the filmcode to set
	 */
	public void setFilmcode(String filmcode) {
		this.filmcode = filmcode;
	}
	/**
	 * @return the filmname
	 */
	public String getFilmname() {
		return filmname;
	}
	/**
	 * @param filmname the filmname to set
	 */
	public void setFilmname(String filmname) {
		this.filmname = filmname;
	}
	/**
	 * @return the years
	 */
	public String getYears() {
		return years;
	}
	/**
	 * @param years the years to set
	 */
	public void setYears(String years) {
		this.years = years;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the captions
	 */
	public String getCaptions() {
		return captions;
	}
	/**
	 * @param captions the captions to set
	 */
	public void setCaptions(String captions) {
		this.captions = captions;
	}
	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}
	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	/**
	 * @return the actor
	 */
	public String getActor() {
		return actor;
	}
	/**
	 * @param actor the actor to set
	 */
	public void setActor(String actor) {
		this.actor = actor;
	}
	/**
	 * @return the showtime
	 */
	public String getShowtime() {
		return showtime;
	}
	/**
	 * @param showtime the showtime to set
	 */
	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}
	/**
	 * @return the playhall
	 */
	public String getPlayhall() {
		return playhall;
	}
	/**
	 * @param playhall the playhall to set
	 */
	public void setPlayhall(String playhall) {
		this.playhall = playhall;
	}
	/**
	 * @return the playtime
	 */
	public Date getPlaytime() {
		return playtime;
	}
	/**
	 * @param playtime the playtime to set
	 */
	public void setPlaytime(Date playtime) {
		this.playtime = playtime;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film [id=").append(id).append(", filmcode=").append(filmcode).append(", filmname=")
				.append(filmname).append(", years=").append(years).append(", type=").append(type).append(", language=")
				.append(language).append(", captions=").append(captions).append(", director=").append(director)
				.append(", actor=").append(actor).append(", showtime=").append(showtime).append(", playhall=")
				.append(playhall).append(", playtime=").append(playtime).append(", description=").append(description)
				.append(", delflag=").append(delflag).append("]");
		return builder.toString();
	}

}
