package com.recipe.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "ROLE")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "value")
	private String value;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "roles_permissions", joinColumns = {@JoinColumn(name = "role_id", nullable = false, updatable = false)},
			inverseJoinColumns = {@JoinColumn(name = "permission_id", nullable = false, updatable = false)})
	private List<Permission> permissions;

	//private List<User> users;
}
