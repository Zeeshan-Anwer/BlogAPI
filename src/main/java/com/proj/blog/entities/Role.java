package com.proj.blog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity

public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int role_id;
	
	private String role_name;
	
//	@ManyToMany
//	@JoinTable(name="user_roles")
//	joinColumn =JoinColumns()
//	private roles
//	
}
