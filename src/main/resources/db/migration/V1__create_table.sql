CREATE SCHEMA IF NOT EXISTS shopping_list;

SET search_path = shopping_list;

CREATE TABLE IF NOT EXISTS shopping_list.sl_user (
    id SERIAL NOT NULL PRIMARY KEY,
    username VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(40),
    salt VARCHAR(30) NOT NULL,
    hashed_password VARCHAR(60) NOT NULL,
    created_by VARCHAR(20) NOT NULL,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(20),
    updated_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS shopping_list.sl_role (
    id SERIAL NOT NULL PRIMARY KEY,
    role_code VARCHAR(20) NOT NULL,
    role_name VARCHAR(40) NOT NULL,
    role_desc VARCHAR(100) NOT NULL,
    created_by VARCHAR(20) NOT NULL,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(20),
    updated_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS shopping_list.sl_module (
    id SERIAL NOT NULL PRIMARY KEY,
    module_code VARCHAR(20) NOT NULL,
    module_name VARCHAR(40) NOT NULL,
    module_desc VARCHAR(100) NOT NULL,
    created_by VARCHAR(20) NOT NULL,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(20),
    updated_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS shopping_list.sl_role_module (
    id SERIAL NOT NULL PRIMARY KEY,
    fk_role_id INTEGER NOT NULL REFERENCES shopping_list.sl_role(id),
    fk_module_id INTEGER NOT NULL REFERENCES shopping_list.sl_module(id),
    can_view VARCHAR(1) NOT NULL,
    can_create VARCHAR(1) NOT NULL,
    can_update VARCHAR(1) NOT NULL,
    can_delete VARCHAR(1) NOT NULL,
    created_by VARCHAR(20) NOT NULL,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(20),
    updated_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS shopping_list.sl_user_role (
    id SERIAL NOT NULL PRIMARY KEY,
    fk_user_id INTEGER NOT NULL REFERENCES shopping_list.sl_user(id),
    fk_role_id INTEGER NOT NULL REFERENCES shopping_list.sl_role(id),
    created_by VARCHAR(20) NOT NULL,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(20),
    updated_date TIMESTAMP
);
