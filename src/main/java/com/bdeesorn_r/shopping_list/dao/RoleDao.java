package com.bdeesorn_r.shopping_list.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "shopping_list", name = "sl_role")
public class RoleDao extends CommonDao {
    @Id
    private Integer id;

    @Column(name = "fk_user_id")
    private Integer userId;

    @Column(name = "module_code")
    private String moduleCode;

    @Column(name = "can_view")
    private String canView;

    @Column(name = "can_create")
    private String canCreate;

    @Column(name = "can_update")
    private String canUpdate;

    @Column(name = "can_delete")
    private String canDelete;
}
